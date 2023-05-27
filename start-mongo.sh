#!/usr/bin/bash

user=admin
password=admin

docker run -d -p 27017:27017 \
        -e MONGO_INITDB_ROOT_USERNAME=${user} \
	      -e MONGO_INITDB_ROOT_PASSWORD=${password} \
	      --name mongo-db \
	      mongo:5.0.18

docker run -d \
        -p 8081:8081 \
        -e ME_CONFIG_MONGODB_ADMINUSERNAME=${user} \
        -e ME_CONFIG_MONGODB_ADMINPASSWORD=${password} \
        --link mongo-db:mongo \
        --name mongo-express \
        mongo-express:0.54