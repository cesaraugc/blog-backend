FROM maven:3.9.4-eclipse-temurin-17 AS build

COPY pom.xml /workdir/server/pom.xml
WORKDIR /workdir/server
RUN mvn dependency:go-offline

COPY src /workdir/server/src
RUN mvn clean install -DskipTests -q

CMD mvn test && mvn spring-boot:run