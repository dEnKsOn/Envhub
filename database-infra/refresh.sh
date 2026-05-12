#!/bin/bash

echo "------------- REFRESHING DOCKER CONTAINERS -------------"

docker compose down
docker compose down -v
docker compose up -d

echo "------------- DOCKER CONTAINERS REFRESHED -------------"
