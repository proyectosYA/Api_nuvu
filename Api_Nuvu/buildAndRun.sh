#!/bin/sh
mvn clean package && docker build -t cc.nuvu/Api_Nuvu .
docker rm -f Api_Nuvu || true && docker run -d -p 8080:8080 -p 4848:4848 --name Api_Nuvu cc.nuvu/Api_Nuvu 
