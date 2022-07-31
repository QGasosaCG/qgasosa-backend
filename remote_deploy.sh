#!/bin/bash

docker rm -f app 

docker pull jonatasflima/qgasosa-backend:$1 && docker run --name app --network host -d jonatasflima/qgasosa-backend:$1
