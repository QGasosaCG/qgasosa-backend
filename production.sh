#!/bin/bash

PROD_SERVER=
echo $1

ssh -oStrictHostKeyChecking=no $PROD_SERVER 'bash -s' < remote_deploy.sh $1
