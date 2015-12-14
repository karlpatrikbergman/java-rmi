#!/usr/bin/env bash

clear
docker stop compute-client
docker rm compute-client
docker images -q --filter "dangling=true" | xargs -n1 -r docker rmi
docker build --rm=true -t karlpatrikbergman/compute-client:v1 .
#docker run -d --name=compute-client karlpatrikbergman/compute-client:v1