package com.spring.tutorial.ioc.difference;

public class WelcomeBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String welcomeMsg() {
        return "Welcome " + name;
    }

    public void initializeBean() {
        System.out.println("Welcome Bean is initialized!!");
    }

    public void destroyBean() {
        System.out.println("Welcome Bean is destroyed!!");
    }

}

