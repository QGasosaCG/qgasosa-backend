#!/bin/bash

APP_PATH=/home/jonatas/qgasosa/qgasosa-backend

cd $APP_PATH && mvn clean flyway:migrate -DflywayConf=flyway.conf
