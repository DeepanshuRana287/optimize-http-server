FROM openjdk:18
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/optimize-http-server-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} optimize-http-server.jar
ENTRYPOINT ["java","-jar","/optimize-http-server.jar"]