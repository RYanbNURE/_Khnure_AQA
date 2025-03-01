#
# Dockerfile to create a sandbox build environment.
#
# Building:
#
#    docker build -f Dockerfile -t hub.ol.epicgames.net/epicgames/build-web-test .
#
# Running:
#
#    docker run --interactive \
#               --rm \
#               --tty \
#               --user $(id -u):$(id -g) \
#               --volume <path to src>:/workspace \
#               --workdir /workspace \
#               hub.ol.epicgames.net/epicgames/build-web-test <build target>
#
# Publishing:
#
#    docker push hub.ol.epicgames.net/epicgames/build-web-test
#
#


FROM node:10.16.0-alpine
LABEL maintainer="olena.lunova@epicgames.com"

# Installs latest Chromium package.
RUN apk update && apk upgrade && \
    echo @edge http://nl.alpinelinux.org/alpine/edge/community >> /etc/apk/repositories \
    && echo @edge http://nl.alpinelinux.org/alpine/edge/main >> /etc/apk/repositories \
    && apk add --no-cache \
    bash \
    chromium@edge \
    harfbuzz@edge \
    freetype@edge \
    ttf-freefont@edge \
    xvfb \
    yarn \
    nss@edge
    
ENV CHROME_BIN=/usr/bin/chromium-browser \
    CHROME_PATH=/usr/lib/chromium/

# Log versions

RUN set -x \
    && node -v \
    && yarn --version \
    && ${CHROME_PATH}chrome --version



