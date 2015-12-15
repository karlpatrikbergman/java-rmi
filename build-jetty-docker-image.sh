#!/usr/bin/env bash

clear
docker stop rmi-jetty
docker rm rmi-jetty
docker images -q --filter "dangling=true" | xargs -n1 -r docker rmi
docker build --rm=true -t karlpatrikbergman/jetty:v1 .
docker run -d -p 6060:8080 --name=rmi-jetty karlpatrikbergman/jetty:v1