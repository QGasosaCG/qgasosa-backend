#!/bin/bash

APP_PATH=$HOME/qgasosa/qgasosa-backend

cd $APP_PATH && mvn clean flyway:migrate -DflywayConf=flyway.conf
