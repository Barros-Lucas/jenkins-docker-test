#!/bin/bash
docker ps -q --filter ancestor=dashboard/back-test-jenkins | grep -q . && docker kill $(docker ps -q --filter ancestor=dashboard/back-test-jenkins)

docker run -d -p 8082:80 dashboard/back-test-jenkins