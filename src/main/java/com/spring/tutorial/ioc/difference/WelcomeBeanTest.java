package com.spring.tutorial.ioc.difference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.beans.factory.xml.XmlBeanFactory;

public class WelcomeBeanTest {

    public static void main(String[] args) {

        beanFactory();
        applicationContext();

    }

    static void beanFactory(){

        /**
         * Note:
         * XmlBeanFactory is deprecated in Spring 3.1 and removed in Spring 4.0. It was used for loading
         * Spring beans from XML configuration files.
         * BeanFactory is not deprecated but less commonly used directly in favor of ApplicationContext.
         * */

        /*ClassPathResource res = new ClassPathResource("beans.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);
        System.out.println("Before getBean() method");

        WelcomeBean welcome = (WelcomeBean) factory.getBean("welcomeBean");
        System.out.println(welcome.welcomeMsg());
        ((XmlBeanFactory)factory).destroySingletons();*/

    }

    static void applicationContext(){
        ApplicationContext con = new ClassPathXmlApplicationContext("ioc/bean-difference.xml");
        System.out.println("Before getBean() method");
        WelcomeBean welcome = (WelcomeBean) con.getBean("welcomeBean");
        System.out.println(welcome.welcomeMsg());
        ((ClassPathXmlApplicationContext) con).close();
    }

}
