package com.spring.tutorial.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating instance of Sim interface inside main() method
        // with reference to Jio class constructor
//        Sim sim = new Jio();
//        Sim sim = new Airtel();

        // Using ApplicationContext to implement Spring IoC
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc-beans.xml");

        // Get the bean with id or name, here we can simply update class in xml to get desired object
        Sim sim = applicationContext.getBean("sim", Sim.class);

        sim.calling();
        sim.data();
    }

}
