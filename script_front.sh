#!/bin/bash
docker ps -q --filter ancestor=dashboard/front-test-jenkins | grep -q . && docker kill $(docker ps -q --filter ancestor=dashboard/front-test-jenkins)

docker run -d -p 8082:80 dashboard/front-test-jenkins
