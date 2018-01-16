FROM openjdk:8u151-jre-alpine

# By default Spring Boot application creates working directories for Tomcat in /tmp
# VOLUME can be set to any <path>, but should be joined with -Djava.io.tmpdir=<path> at ENTRYPOINT to customize the JVM
VOLUME /tmp

RUN mkdir -p /var/tmp/config

# Add the jar into the image
ADD build/libs/spring-mongodb-docker-1.0.jar spring-mongodb-docker-1.0.jar

# APP_PORTS is passed in --build-arg
#EXPOSE $APP_PORTS
EXPOSE 8080

ENTRYPOINT ["java","-Djava.io.tmpdir=/tmp","-Djava.security.egd=file:/dev/./urandom","-jar","spring-mongodb-docker-1.0.jar","-dcv"]

