#!/bin/bash

cd ../..

mvn clean install

cd movie/k8/

eval $(minikube docker-env)

cd ..

bash build-image.sh

cd k8

kubectl apply -f deploy-movie.yaml -n spring-k8