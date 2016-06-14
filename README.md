# java-rmi 

To run example from http://docs.oracle.com/javase/tutorial/rmi/TOC.html:

1. Build parent project

2. In root folder run
   ./build-jetty-docker-image.sh

3. With a terminal in compute-server, run
   ./start-rmiregistry

4. With another terminal in compute-server, run
   ./start-server

5. With yet another terminal in compute-client, run
   ./start-client
   
TODO:
Run rmiregistry, compute-server and compute-client on differents hosts/
JVMs using Docker.

