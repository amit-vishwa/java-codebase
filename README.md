# overview
This repo has the code for multithreading related topics of Java

i. Multithreading, Parallel & Asynchronous Coding in Modern Java
- This repo has the code for parallel and asynchronous programming in Java
- Udemy course link - https://qube.udemy.com/course/parallel-and-asynchronous-programming-in-modern-java/learn/lecture/21016178?start=0#overview

ii. Efficient Java Multithreading and Concurrency with Executors
- This repo has the code for concurrent programming in Java
- Udemy course link - https://qube.udemy.com/course/efficient-java-multithreading-with-executors/learn/lecture/3335772?start=0#overview

iii. Java Multithreading: Synchronization, Locks, Executors, Deadlock, CountdownLatch & CompletableFuture
- This repo has the code demonstrating the use of multithreading concepts from Java
- Youtube course link - https://youtu.be/4aYvLz4E1Ts?si=AFDT57D3rOof6um7

## Topics covered

- Thread creation, lifecycle, naming, interruption, and daemon threads
- Synchronization, locks, atomic values, and volatile variables
- Producer-consumer communication, deadlocks, latches, and barriers
- Executor services, scheduled tasks, futures, and `CompletableFuture`
- Parallel streams, fork/join processing, and asynchronous service composition

## Requirements and usage

- JDK 21
- Internet access for the first Gradle dependency download

Run the Gradle build from the project directory:

```powershell
Set-Location parallel-asynchronous-using-java-main
.\gradlew.bat test
```

The repository contains demonstrations that intentionally sleep, block, throw exceptions, or create deadlocks to illustrate concurrency behavior. Review an example before running its `main` method, and stop intentionally non-terminating demonstrations manually.

Generated build output, IDE settings, and standalone binary libraries are excluded from version control. The Gradle wrapper JAR remains tracked because it is required by the wrapper scripts.

## Repository structure

This `multithreading` branch contains concurrency and asynchronous-programming material. Other learning areas are maintained in the `java`, `java8`, `collections`, `spring`, and `mongodb` branches, while `main` provides the top-level index.
