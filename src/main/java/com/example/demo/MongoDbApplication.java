package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.example.*")
@EnableMongoRepositories("com.example.repository")
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

}
