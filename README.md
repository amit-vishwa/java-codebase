# Spring Framework Learning Examples

This branch preserves introductory Spring Framework exercises created for learning purposes. It is intentionally incomplete and is kept as a revision reference rather than as a production application.

## Topics covered

- Inversion of control and dependency injection
- `ApplicationContext` and `BeanFactory`
- Java-based bean configuration
- XML bean configuration
- A small interface-based mobile service example

Reference material: <https://www.geeksforgeeks.org/spring/>

## Requirements and usage

- JDK 17
- Maven 3.8 or newer

Run the existing test from this branch's root:

```powershell
mvn test
```

The examples are small demonstrations and not HTTP endpoints or a deployed service. Generated Maven output and IDE-specific settings are excluded from version control.

## Repository structure

This `spring` branch contains introductory Spring examples. More complete Spring applications are maintained in separate repositories. Other areas in this repository are available from the `java`, `java8`, `collections`, `multithreading`, and `mongodb` branches, while `main` provides the top-level index.
