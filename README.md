# spring-boot-docker

Executando Spring Boot com Docker

## Pré requisitos
- Gradle
- Java 8
- Docker 1.13.0+

## Construindo o ambiente backend

calcard-api$ ./gradlew build -x test
docker build --build-arg JAR_FILE=build/libs/*.jar -t callcard/callcard-test .
docker-compose up

## Documentação Swagger

http://localhost:8080/swagger-ui.html#/

