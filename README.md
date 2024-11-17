# Task 2. Connecting the database

**Added a PostgreSQL DB to the project**

Mapped entity via Mapstruct.
API documented via Swagger.

## Run project
Before the first launch you may need to change ddl-auto property in application.yaml to "create" _// will be fixed with liquibase migrations soon_
```
git clone https://github.com/yanmayak/RomashkaCo.git
mvn clear
mvn package
java -jar target/RomaskaCo-0.0.1-SNAPSHOT.jar
```
To view swagger open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html#/)
