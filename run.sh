#!/bin/bash
mvn -f ./car-rental-web-ui/pom.xml clean package -Dmaven.test.skip=true
mvn -f ./test-task-vehicle-tracker/pom.xml clean package -Dmaven.test.skip=true
docker image build -t car-rental-web-ui:base ./car-rental-web-ui
docker image build -t car-rental-tracking:base ./test-task-vehicle-tracker
docker image build -t car-rental-nginx:base ./nginx
docker swarm init --advertise-addr=127.0.0.1
docker stack deploy -c docker-compose.yml car-rental