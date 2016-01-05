# kevoree-docker-websocket-cdn
A docker container of a websocket CDN backed by a mongo database

## Build

```bash
$ mvn clean install docker:build
```

The generated docker image is named **docker-kevoree-gateway** in your local repository.

## Running

A Docker Compose confirguration file is available at the root of the projected.
It can be started using

```bash
$ docker-compose up
Starting kevoreedockerwebsocketcdn_mongo_1
Starting kevoreedockerwebsocketcdn_gateaway_1
$ docker-compose ps
                Name                              Command               State            Ports
-------------------------------------------------------------------------------------------------------
kevoreedockerwebsocketcdn_gateaway_1   java -jar /docker-kevoree- ...   Up      0.0.0.0:32775->8888/tcp
kevoreedockerwebsocketcdn_mongo_1      /entrypoint.sh mongod            Up      27017/tcp
```

Here the cdn is now available at http://127.0.0.1:32775/ where **32775** is a port number choose at runtime by Docker Engine.
