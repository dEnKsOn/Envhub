#!/bin/bash

echo "------------- REFRESHING DOCKER CONTAINERS -------------"

# On précise le chemin vers db.env pour chaque commande docker compose
docker compose --env-file ../resources/db.env down
docker compose --env-file ../resources/db.env down -v
docker compose --env-file ../resources/db.env up -d

echo "------------- DOCKER CONTAINERS REFRESHED -------------"