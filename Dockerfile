#Compilador
FROM maven:3.8.6-jdk-11 as build
WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN mvn clean install -DskipTests=true

#Imagen final con el jar
FROM ubuntu:20.04
RUN apt update && apt install -y openjdk-11-jdk
RUN adduser --system --group spring
USER spring
ARG JAR_FILE=/usr/src/app/target/*.jar
COPY --chown=spring:spring --from=build ${JAR_FILE} app.jar

EXPOSE 3000
CMD ["java", "-jar", "app.jar"]
