#!/usr/bin/env bash

if [ "$TRAVIS_BRANCH" = "master" ]; then

    mvn clean install -U

    if [ "$?" -ne 0 ]; then
        exit 1
    fi

    mvn clean deploy --settings deploy-settings.xml -Dmaven.test.skip=true -U
fi