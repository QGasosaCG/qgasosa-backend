#!/bin/bash

APP_PATH=/home/marcosguillermo/Documentos/ES-2021.1/qgasosa-backend

cd $APP_PATH && mvn clean flyway:migrate -DflywayConf=flyway.conf
