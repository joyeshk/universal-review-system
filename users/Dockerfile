FROM openjdk:17-alpine
EXPOSE 8081
VOLUME /tmp
COPY target/users-0.0.1-SNAPSHOT.jar users.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/users.jar"]