#!/bin/sh
mvn clean package && docker build -t com.goldenapple/minimalSelectOneWithEntity .
docker rm -f minimalSelectOneWithEntity || true && docker run -d -p 8080:8080 -p 4848:4848 --name minimalSelectOneWithEntity com.goldenapple/minimalSelectOneWithEntity 
