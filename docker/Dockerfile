####
# This Dockerfile is used in order to build a container that runs the Spring Boot application
#
# Build the image with:
#
# docker build -f docker/Dockerfile -t springboot/sample-demo .
#
# Then run the container using:
#
# docker run -i --rm -p 8081:8081 springboot/sample-demo
####
FROM maven:3.8.1-openjdk-11-slim

WORKDIR /build

# Build dependency offline to streamline build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn package -D maven.test.skip=true

FROM openjdk:11-jdk
COPY --from=0 /build/target/GestionInmuebles-0.0.1-SNAPSHOT.jar /app/target/GestionInmuebles-0.0.1-SNAPSHOT.jar

EXPOSE 8081
<<<<<<< HEAD
ENTRYPOINT [ "java", "-jar", "/app/target/GestionInmuebles-0.0.1-SNAPSHOT.jar", "--server.port=8081" ]
=======
ENTRYPOINT [ "java", "-jar", "/app/target/GestionInmuebles-0.0.1-SNAPSHOT.jar", "--server.port=8081" ]
>>>>>>> 2709993df4d95d05540241c5364a79256be3b162
