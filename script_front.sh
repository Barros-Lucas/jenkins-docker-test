#!/bin/bash
docker ps -q --filter publish=80 | grep -q . && docker kill $(docker ps -q --filter publish=80)

docker run -d -p 8081:80 dashboard/front-test-jenkins
