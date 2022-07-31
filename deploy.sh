#!/bin/bash

docker build -t jonatasflima/qgasosa-backend:$1 . && docker push jonatasflima/qgasosa-backend:$1

bash production.sh $1
