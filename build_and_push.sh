#!/bin/bash

docker_user=jonatasflima
image_name=qgasosa-backend
image_tag=$1
image=$docker_user/$image_name:$image_tag

docker build -t $image .

docker push $image