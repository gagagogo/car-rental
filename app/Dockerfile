FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/test-task-0.0.1-SNAPSHOT.jar /car-rental-0.0.1-SNAPSHOT.jar
ENV DB_USER="root" 
ENV DB_PASS="0123456789"
ENV DB_URL="jdbc:mysql://localhost:3307/car_rental?useUnicode=yes&characterEncoding=UTF-8"
ENV REDIS_URL="redis://localhost:6379"
#RUN apk update && apk add bash

EXPOSE 80
#ENTRYPOINT ["java", "-Ddb.user=${DB_USER} -Ddb.password=${DB_PASS} -Ddb.url=${DB_URL} -Dredis.url=${REDIS_URL}","-jar", "/car-rental-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java", "-jar", "/car-rental-0.0.1-SNAPSHOT.jar"]