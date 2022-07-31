#!/bin/bash

docker rm -f app && docker run --name app --network host -d jonatasflima/qgasosa-backend:$1
