FROM gradle:8.8-jdk21-alpine AS build
COPY . .
RUN ./gradlew build --no-daemon

FROM amazoncorretto:21-al2023-headless
COPY --from=build /home/gradle/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]