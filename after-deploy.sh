#!/usr/bin/env bash

REPOSITORY=/home/ubuntu/apps/shorturlapp
cd $REPOSITORY

echo "> building gradle "
sudo chmod +x ./gradlew
sudo chmod -R 777 ~/apps/shorturlapp
sudo ./gradlew build

APP_NAME=shorturlapp
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

pkill -f 'java -jar'

echo "> $JAR_PATH 배포"
cd /home/ubuntu/apps/shorturlapp/build/libs
nohup java -jar shorturlapp-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &