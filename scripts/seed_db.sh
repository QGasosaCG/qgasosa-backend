#!/bin/bash

APP_PATH=/home/luiz/Documentos/UFCG/engenharia-de-software/qgasosa-backend
SEED_FILE=$APP_PATH/src/main/resources/db/seed/seed.sql

docker exec -i qgasosa-db psql -U postgres postgres < $SEED_FILE