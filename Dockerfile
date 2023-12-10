FROM maven AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/quizapp.jar /app
CMD ["java", "-jar", "quizapp.jar"]

# docker build -t $image_name .
# docker run --name $container_name --network $network -p 8080:8080 $image_name