FROM openjdk:11

RUN mkdir -p /movie-service

WORKDIR /movie-service

COPY target/*.jar movie-service.jar

CMD ["java", "-jar", "movie-service.jar"]