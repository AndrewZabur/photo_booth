FROM maven:latest as builder
COPY src /andrewzabur/photo/booth/src
COPY pom.xml /andrewzabur/photo/booth
RUN mvn -f /andrewzabur/photo/booth/pom.xml clean install

FROM amazoncorretto:17
COPY --from=builder /andrewzabur/photo/booth/target/photo_booth-1.0-SNAPSHOT.jar photo_booth.jar
EXPOSE 8080 8081
ENTRYPOINT ["java", "-jar", "/photo_booth.jar"]