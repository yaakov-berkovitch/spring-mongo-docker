# spring-mongo-docker

## Build the project
Run "gradle build" from the command line. <br />
You can also load the project in eclipse IDE using the import of gradle project. <br />

## Build the docker image
To build the docker image run : gradle buildImage <br />
The image created has the same name as the jar. <br />
To list the images, run : docker images <br />

## Run the dockerized application
To run the application use the following command: <br />
docker run -d --rm --name spring-mongodb-docker -e MONGODB_SERVER_NAME=1.2.3.4 -e MONGODB_DATABASE_NAME=demodb spring-mongodb-docker:1.0 <br />
