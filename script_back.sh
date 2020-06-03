#!/bin/bash
docker ps -q --filter  publish=8081 | grep -q . && docker kill $(docker ps -q --filter  publish=8081 )

docker run -d --log-driver=none -p 8082:8082 dashboard/back-test-jenkins
