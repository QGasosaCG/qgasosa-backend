#!/bin/bash

APP_PATH=/home/marcosguillermo/Documentos/ES-2021.1/qgasosa-backend/
SEED_FILE=$APP_PATH/src/main/resources/db/seed/seed.sql

docker exec -i qgasosa-db psql -U postgres postgres < $SEED_FILE
