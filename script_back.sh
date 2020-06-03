#!/bin/bash
docker ps -q --filter publish=8082 | grep -q . && docker kill $(docker ps -q --filter publish=8082)

docker run -d -p 8082:8082 dashboard/back-test-jenkins
