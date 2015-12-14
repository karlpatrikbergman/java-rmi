FROM java:8
MAINTAINER "patrik_bergman@yahoo.com"
RUN mkdir /opt/compute-client
ADD target/compute-client-1.0-SNAPSHOT.jar /opt/compute-client/compute-client-1.0-SNAPSHOT.jar
ADD start-client /opt/compute-client/start-client
WORKDIR /opt/compute-client
RUN chmod +x start-client
#CMD ["start-client"]