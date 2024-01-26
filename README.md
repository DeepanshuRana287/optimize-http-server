# Optimize HTTP Server

*Implemented a simple HTTP server to retrieve content of file based on given fileName and lineNumber*

## How to Run Application on Local Server

*Start the application using commands mentioned below*

> *Note:* Below commands need to run inside the root folder of this project i.e inside the *optimize-http-server* folder


- *Create a jar file using* <br/>mvn clean install


- *Execute*
  <br/>java -jar target/optimize-http-server-1.0.0-SNAPSHOT.jar



## How to Run Application on Docker Container

*Start the application using commands mentioned below*

> *Note:* Below commands need to run inside the root folder of this project where Dockerfile is present i.e inside the *optimize-http-server* folder


- *Create a jar file using* <br/>mvn clean install


- *Build docker image*
  <br/>docker build -t  optimize-http-server:http-server .


- *Start docker container for the image with specific requirements*
  <br/>docker run -p 8080:8080 -m 1500m --cpus=2 optimize-http-server:http-server


## Client Request

*Send an HTTP GET request to '/data' endpoint using any of the two methods*

- *Browser or REST client*
  <br/>http://localhost:8080/data?n=1&m=2


- *cURL*
  <br/>curl --request GET 'http://localhost:8080/data?n=1&m=2'

## Further Optimizations

- *Database Storage and Indexing*
  <br/>To enhance performance, consider storing these files in a database and implementing indexing. This approach facilitates faster retrieval of data, optimizing response times.
  


- *Caching for Improved Responsiveness*
  <br/>Implementing a cache for the most recently accessed files is another strategy to achieve faster response times. This allows frequently requested data to be readily available, optimizing overall system responsiveness.