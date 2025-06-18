FROM  eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . /app
EXPOSE 8091
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM  eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8091
CMD ["java", "-jar", "/app/app.jar"]
