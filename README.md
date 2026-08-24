# Spring Boot and MongoDB Learning API

This branch preserves a Spring Boot tutorial application for learning MongoDB persistence and Spring Data query methods. It is a local educational API, not a deployed production service.

## Topics covered

- MongoDB document entities and relationships
- Spring Data MongoDB repositories
- CRUD endpoints for student records
- Derived and custom repository queries
- Pagination and sorting
- Importing a Postman collection for local API testing

## Requirements and local setup

- JDK 17
- Maven 3.8 or newer, or the included Maven wrapper
- MongoDB available locally or through a connection URI

By default, the application connects to `mongodb://localhost:27017/spring`. Override it without committing credentials:

```powershell
$env:MONGODB_URI = "mongodb://localhost:27017/spring"
.\mvnw.cmd spring-boot:run
```

The API is available under `/api/student`. The Postman collection in `src/main/resources` contains example requests. Use only synthetic learning data when running the examples.

## Verification

Run the test suite with:

```powershell
.\mvnw.cmd test
```

Generated Maven output, local environment files, and IDE-specific settings are excluded from version control.

## Repository structure

This `mongodb` branch contains the Spring Data MongoDB tutorial. Other learning areas are maintained in the `java`, `java8`, `collections`, `multithreading`, and `spring` branches, while `main` provides the top-level index.
