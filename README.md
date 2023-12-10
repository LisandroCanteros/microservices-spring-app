# Microservices-Spring-App
Learning about microservices with Spring

## DB SETUP
1) create volume → docker volume create postgres-volume
2) create network → docker network create quizapp-network

3) start up db w/ volume → docker run --name postgres-quiz --network quizapp-network -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -d --mount source=postgres_volume,target=/var/lib/postgresql/data postgres

4) access db and create database "quizapp_question":  
a) docker exec -it postgres-quiz bash  
b) psql  
c) CREATE DATABASE quizapp_question;  

## APP SETUP
5) build image from dockerfile → docker build -t quizapp .
6) run app container → docker run --name quizapp --network quizapp-network -p 8080:8080 quizapp
