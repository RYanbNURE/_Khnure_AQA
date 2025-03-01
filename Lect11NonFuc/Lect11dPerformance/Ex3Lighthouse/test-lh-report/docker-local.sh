#!/usr/bin/env bash

# Allow build to be cancelled when running interactively.
#
if [ -t 0 ] || [ -t 1 ]; then
  PSEUDO_TTY_OPTIONS="--tty"
fi

./docker-build-container.sh build.sh
