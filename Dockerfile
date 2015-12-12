FROM jetty
MAINTAINER "patrik_bergman@yahoo.com"

RUN rm /bin/sh && ln -s /bin/bash /bin/sh

RUN mkdir webapps/compute-api webapps/compute-client
ADD compute-api/target/compute-api-1.0-SNAPSHOT.jar webapps/compute-api/compute-api-1.0-SNAPSHOT.jar
ADD compute-client/target/compute-client-1.0-SNAPSHOT.jar webapps/compute-client/compute-client-1.0-SNAPSHOT.jar

