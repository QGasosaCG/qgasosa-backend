#!/bin/bash

APP_PATH=/home/jonatas/qgasosa/qgasosa-backend
MIGRATIONS_DIR=$APP_PATH/src/main/resources/db/migration

for file in $MIGRATIONS_DIR/*.sql; do
  docker exec -i qgasosa-db psql -U postgres postgres < $file
done
