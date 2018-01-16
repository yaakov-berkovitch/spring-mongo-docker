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
docker run -d \ <br />
&nbsp;&nbsp;--rm \ <br />
&nbsp;&nbsp;--name spring-mongodb-docker \ <br />
&nbsp;&nbsp;-e MONGODB_SERVER_NAME=1.2.3.4 \ <br />
&nbsp;&nbsp;-e MONGODB_DATABASE_NAME=demodb \ <br />
&nbsp;&nbsp;spring-mongodb-docker:1.0 <br />
