FROM openjdk:8u151-jre-alpine

# Required for health check
RUN apk add --update --no-cache curl

# By default Spring Boot application creates working directories for Tomcat in /tmp
# VOLUME can be set to any <path>, but should be joined with -Djava.io.tmpdir=<path> at ENTRYPOINT to customize the JVM
VOLUME /tmp

RUN mkdir -p /var/tmp/config

# APP_JAR and SRC_JAR are passed in --build-arg
#ADD $SRC_JAR app.jar
ADD build/libs/spring-mongo-docker-1.0.jar spring-mongo-docker-1.0.jar

# APP_PORTS is passed in --build-arg
#EXPOSE $APP_PORTS
EXPOSE 8080

ENTRYPOINT ["java","-Djava.io.tmpdir=/tmp","-Djava.security.egd=file:/dev/./urandom","-jar","spring-mongo-docker-1.0.jar","-dcv"]

