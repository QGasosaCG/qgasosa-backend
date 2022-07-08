#!/bin/bash

APP_PATH=/home/luiz/Documentos/UFCG/engenharia-de-software/qgasosa-backend
MIGRATIONS_DIR=$APP_PATH/src/main/resources/db/migration

for file in $MIGRATIONS_DIR/*.sql; do
  docker exec -i qgasosa-db psql -U postgres postgres < $file
done
