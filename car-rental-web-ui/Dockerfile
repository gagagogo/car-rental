FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/car-rental-web-ui-*.jar /car-rental-0.0.1-SNAPSHOT.jar
ENV DB_USER="root" 
ENV DB_PASS="0123456789"
ENV DB_URL="jdbc:mysql://localhost:3307/car_rental?useUnicode=yes&characterEncoding=UTF-8"
ENV REDIS_URL="redis://localhost:6379"

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/car-rental-0.0.1-SNAPSHOT.jar"]