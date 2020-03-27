#!/bin/bash
docker ps -q --filter ancestor=dashboard/back-test-jenkins | grep -q . && docker kill $(docker ps -q --filter ancestor=dashboard/back-test-jenkins)

docker run -p 8082:8082 dashboard/back-test-jenkins
