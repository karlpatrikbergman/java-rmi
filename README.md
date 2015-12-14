# java-rmi 

To run example from http://docs.oracle.com/javase/tutorial/rmi/TOC.html:

1. Build parent project

2. Copy compute-api-1.0-SNAPSHOT.jar to accessible webserver, like
   http://localhost:6060/compute-api/compute-api-1.0-SNAPSHOT.jar
   (adjust start-server if necessary) 

3. Copy compute-client-1.0-SNAPSHOT.jar to accessible webserver, like
   http://localhost:6060/compute-client/compute-client-1.0-SNAPSHOT.jar
   (adjust start-client if necessary)

4. With a terminal in compute-server, run
   start-rmiregistry

5. With another terminal in compute-server, run
   start-server

6. With yet another terminal in compute-client, run
   start-client
   
TODO:
Run rmiregistry, compute-server and compute-client on differents hosts/
JVMs using Docker.

