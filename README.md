# Task 1. Basic implementation of REST API

**A small REST API has been implemented with the main available CRUD methods:**

1. Getting a list of all products
2. Getting product information
3. Creating a product card
4. Updating product information
5. Deleting product information

The products contain all the specified fields with constraints set on them.
A global exception handler is also included.

API documented via Swagger.

## Run project
```
git clone https://github.com/yanmayak/RomashkaCo.git
mvn clear
mvn package
java -jar target/RomaskaCo-0.0.1-SNAPSHOT.jar
```
To view swagger open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html#/)
