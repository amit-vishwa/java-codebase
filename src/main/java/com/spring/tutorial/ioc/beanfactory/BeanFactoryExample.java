package com.spring.tutorial.ioc.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryExample {

    public static void main(String[] args)
    {
        // Creating object in a spring container (Beans)
        BeanFactory factory = new ClassPathXmlApplicationContext("ioc/bean-factory-demo.xml");
        Student student = (Student) factory.getBean("student");

        System.out.println(student);
    }

}
