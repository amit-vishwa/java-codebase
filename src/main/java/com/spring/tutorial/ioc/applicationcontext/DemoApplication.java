package com.spring.tutorial.ioc.applicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// Class
 @SpringBootApplication
public class DemoApplication {

    // Main driver method
    public static void main(String[] args) {

        usingSpringApplication(args);
        usingAnnotationConfigApplicationContext();
        usingFileSystemXmlApplicationContext();
        usingClassPathXmlApplicationContext();

    }

    static void usingSpringApplication(String[] args){
        // Student bean is fetched by SpringBootApplication using Annotation
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Student student = context.getBean(Student.class);
        System.out.println("Using spring application: " + student);
    }

    static void usingAnnotationConfigApplicationContext(){
        // Student bean is fetched from config file
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = context.getBean(Student.class);
        System.out.println("Using annotation config application context: " + student);
    }

    static void usingFileSystemXmlApplicationContext(){
        String path = "src/main/resources/ioc/application-context-demo.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(path);
        Student student = context.getBean("student", Student.class);
        System.out.println("Using file system xml application context: " + student);
    }

    static void usingClassPathXmlApplicationContext(){
        String path = "ioc/application-context-demo.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        Student student = context.getBean("student", Student.class);
        System.out.println("Using class path xml application context: " + student);
    }

}