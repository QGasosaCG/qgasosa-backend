#!/bin/bash

DB_NAME='qgasosa-db'

function install_docker() {
  # instalando o docker
  curl -fSsL https://get.docker.com | bash

  # adicionando o usuário ao grupo docker
  sudo usermod -aG docker $USER

  # reinicializando os grupos (melhor abrir outro terminal)
  newgrp
}

function create_db_container() {
  docker run --name $DB_NAME \
             -dp 5433:5432 \
             -e POSTGRES_USER=postgres \
             -e POSTGRES_PASSWORD=postgres \
             -v qgasosa-data:/var/lib/postgresql/data \
              postgres:14.4
}

docker &>/dev/null

if [ $? -ne 0 ]; then
  echo "docker nao instalado, instalando..."
  install_docker
fi

echo "Subindo banco de dados"

container_exists=$(docker container ls -a | grep $DB_NAME | wc -l)

if [ $container_exists -eq 1 ]; then
  echo "Container existe, startando..."
  docker start $DB_NAME
else
  echo "Criando container..."
  create_db_container
fi