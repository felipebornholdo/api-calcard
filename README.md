# spring-boot-docker

Executando Spring Boot com Docker

## Pré requisitos
- Maven
- Java 8
- Docker 1.13.0+

## Construindo o ambiente backend
```
mvn clean -Dmaven.test.skip=true package
 ```
 ```
docker build --build-arg JAR_FILE=target/*.jar -t calcard/calcard-test .
```
 ```
docker-compose run --rm wait
```

```
/* Aguardar inicialização do mysql. */
```

```
docker-compose up docker-app
```

## Documentação Swagger

http://localhost:8080/swagger-ui.html#/

