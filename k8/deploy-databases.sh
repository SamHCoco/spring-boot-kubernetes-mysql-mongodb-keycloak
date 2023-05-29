#!/bin/bash

cd mongodb
kubectl apply -f mongodb-config.yaml -n spring-k8
kubectl apply -f mongodb-secret.yaml -n spring-k8
kubectl apply -f statefulset.yaml -n spring-k8

cd ..

cd mysql
kubectl apply -f mysql-config.yaml -n spring-k8
kubectl apply -f mysql-secret.yaml -n spring-k8
kubectl apply -f statefulset.yaml -n spring-k8
