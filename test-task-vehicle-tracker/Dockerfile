FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/test-task-vehicle-tracker*.jar /car-rental-0.0.1-SNAPSHOT.jar
ENV DB_USER="root" 
ENV DB_PASS="0123456789"
ENV DB_URL="jdbc:mysql://localhost:3307/car_rental_tracking?useUnicode=yes&characterEncoding=UTF-8"
ENV REDIS_URL="redis://localhost:6379"

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/car-rental-0.0.1-SNAPSHOT.jar"]