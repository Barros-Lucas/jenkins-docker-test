#!/bin/bash
docker ps -q --filter publish=8081 | grep -q . && docker kill $(docker ps -q --filter publish=8081)

docker run -d -p 8081:80 dashboard/front-test-jenkins
