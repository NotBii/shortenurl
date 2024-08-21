#!/usr/bin/env bash

REPOSITORY=/home/ubuntu/apps/shorturlapp
cd $REPOSITORY

APP_NAME=shorturlapp
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> service not on process"
else
  echo "> kill -9 $CURRENT_PID"
  kill -9 $CURRENT_PID
  sleep 5

fi
echo "> building gradle "
./gradlew build

echo "> $JAR_PATH 배포"
nohup java -jar $JAR_PATH.jar > /dev/null 2> /dev/null < /dev/null &