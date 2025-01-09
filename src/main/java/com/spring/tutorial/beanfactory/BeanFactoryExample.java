package com.spring.tutorial.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryExample {

    public static void main(String[] args)
    {
        // Creating object in a spring container (Beans)
        BeanFactory factory = new ClassPathXmlApplicationContext("bean-factory-demo.xml");
        Student student = (Student) factory.getBean("student");

        System.out.println(student);
    }

}
