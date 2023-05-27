#!/bin/bash

password=admin

docker run -d --name mysql8 \
              -e MYSQL_ROOT_PASSWORD=${password} \
              -p 3307:3306 \
              mysql:8