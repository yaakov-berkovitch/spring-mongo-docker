# spring-mongo-docker

## Build the project
Run "gradle build" from the command line.
You can also load the project in eclipse IDE using the import of gradle project.

## Build the docker image
To build the docker image run : gradle buildImage
The image created has the same name as the jar.
To list the images, run : docker images

## Run the dockerized application
To run the application use the following command:
docker run -d --rm --name spring-mongodb-docker -e MONGODB_SERVER_NAME=1.2.3.4 -e MONGODB_DATABASE_NAME=demodb spring-mongodb-docker:1.0
