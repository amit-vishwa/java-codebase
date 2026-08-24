# overview 
This repo consists of Java and DSA tutorials from GeeksForGeeks

i. Java
- Java from beginner to advanced
- Source link - https://www.geeksforgeeks.org/java/?ref=dhm

ii. DSA
- DSA for beginners
- Source link - https://www.geeksforgeeks.org/introduction-to-dsa/

## Requirements

- JDK 17
- Maven 3.8 or newer

The examples are independent learning snippets. Some require console input, local files, or external services and are not intended to run together as one application.

### JDBC examples

The JDBC examples connect to a local MySQL database and read connection settings from environment variables. Set these before running an example:

```powershell
$env:JDBC_URL = "jdbc:mysql://localhost:3306/gfg"
$env:JDBC_USERNAME = "root"
$env:JDBC_PASSWORD = "your-local-password"
```

`JDBC_URL` and `JDBC_USERNAME` have the defaults shown above. `JDBC_PASSWORD` is required and must not be committed to the repository.

## Repository structure

This repository uses topic branches. This `java` branch contains core Java and introductory DSA examples. Other learning areas are maintained in the `java8`, `collections`, `multithreading`, `spring`, and `mongodb` branches. The `main` branch provides the top-level index.
