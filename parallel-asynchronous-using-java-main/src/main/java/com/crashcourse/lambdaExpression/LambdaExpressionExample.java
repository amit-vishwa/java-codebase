package com.crashcourse.lambdaExpression;

public class LambdaExpressionExample {

    public static void main(String[] args) {

        // Simple single abstract method implementation of interface
        Student alex = new EngineeringStudent();
        String alexBio = alex.getBio("Alex");
        System.out.println(alexBio);

        // Single abstract method implementation of interface using anonymous class
        Student john = new Student() {
            @Override
            public String getBio(String name) {
                return name + " is a law student!";
            }
        };
        String johnBio = john.getBio("John");
        System.out.println(johnBio);

        // Single abstract method implementation of interface using lambda expression
        Student charlie = name -> name + " is a medical student!";
        String charlieBio = charlie.getBio("Charlie");
        System.out.println(charlieBio);

        // Runnable interface is implemented using lambda expression
        new Thread(() -> System.out.println("Hello, World!")).start();

    }

}
