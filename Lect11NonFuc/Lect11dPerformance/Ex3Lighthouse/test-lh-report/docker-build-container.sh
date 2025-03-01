#!/bin/bash

#
# Poor man's docker cleanup. The 'head' command is used to limit how
# much artifact garbage is collected per invocation. All failures are
# ignored.
#
docker-gc() {
    exited_containers=$(docker ps -f status=exited -q | head)
    if [ -n "$exited_containers" ]; then
        docker rm -v $exited_containers > /dev/null 2>&1
    fi

    unused_images=$(docker images -q -f dangling=true | head)
    if [ -n "$unused_images" ]; then
        docker rmi $unused_images > /dev/null 2>&1
    fi
}

die() {
    err=$?
    msg=$1
    if [ -n "$msg" ]; then
        echo "$msg" >&2
    fi
    echo "Failed with exit code $err." >&2
	
    exit $err
}

#
# Setup environment variables
#
EPIC_BUILD_SOURCE_PATH=$(pwd)

#
# Check Docker daemon is running.
#
docker version > /dev/null 2>&1 || die "Could not connect to Docker daemon."

#
# Perform an incremental cleanup up of old docker artifacts before starting build.
#
docker-gc

#
# Run project inside docker container
#
echo "EPIC_BUILD_SOURCE_PATH:     $EPIC_BUILD_SOURCE_PATH"

#
# Impersonate the caller's UID/GID so docker builds will
# create artifacts with the same permissions as the external
# volume. This is necessary because docker currently does not
# support user namespace root remapping.
#
# see:
#
#    https://github.com/docker/docker/issues/7906
#    https://github.com/docker/docker/pull/11253
#
if [ -n "$(uname -a | grep Linux)" ]; then
    UID_GID_IMPERSONATION_OPTIONS="--user $(id -u):$(id -g)"
else
    #
    # The Docker daemon on Mac OS X and Windows runs in a lightweight
    # VM. It automatically mounts and shares the /Users path from the
    # host's filesystem with docker:staff permissions. This allows the
    # VM and launched containers to read and write files back to the
    # host OS.
    #
    UID_GID_IMPERSONATION_OPTIONS="--user 1000:50"
fi

DOCKER_REGISTRY_DOMAIN=hub.ol.epicgames.net
DOCKER_REGISTRY_NAMESPACE=epicgames

#
# Use a Nexus reverse proxy if NEXUS_PROXY_HOST is set or a local container is running.
#
if [ -z "$NEXUS_PROXY_HOST" ]; then
   NEXUS_PROXY_RUNNING=$(docker inspect --format "{{.State.Running}}" nexus-proxy 2> /dev/null)
   if [ "$NEXUS_PROXY_RUNNING" == "true" ]; then
      NEXUS_PROXY_HOST=$(docker inspect --format "{{.NetworkSettings.IPAddress}}" nexus-proxy)
      if [ -z "$NEXUS_PROXY_HOST" ]; then
         NEXUS_PROXY_HOST=$(docker inspect --format "{{.NetworkSettings.IPAddress}}" pod-network)
      fi
   fi
fi
if [ -n "$NEXUS_PROXY_HOST" ]; then
   echo "Found Nexus proxy. Mapping nexus-server-01.ol.epicgames.net to ${NEXUS_PROXY_HOST}."
   HOST_OPTIONS="--add-host nexus-server-01.ol.epicgames.net:$NEXUS_PROXY_HOST"
fi

docker pull ${DOCKER_REGISTRY_DOMAIN}/${DOCKER_REGISTRY_NAMESPACE}/build-web-test

docker run \
    --cap-drop ALL \
    $HOST_OPTIONS \
	$UID_GID_IMPERSONATION_OPTIONS \
    --volume /$EPIC_BUILD_SOURCE_PATH://workspace \
    --workdir //workspace \
    --interactive \
    --entrypoint /bin/sh \
    --env "TEAMCITY_VERSION=$TEAMCITY_VERSION" \
    --rm \
    ${DOCKER_REGISTRY_DOMAIN}/${DOCKER_REGISTRY_NAMESPACE}/build-web-test "$@" || die
