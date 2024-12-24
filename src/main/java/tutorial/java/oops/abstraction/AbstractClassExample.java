package tutorial.java.oops.abstraction;

/**
 *
 * Java Abstract classes and Java Abstract methods
 * An abstract class is a class that is declared with an abstract keyword.
 * An abstract method is a method that is declared without implementation.
 * An abstract class may or may not have all abstract methods. Some of them can be concrete methods
 * A abstract method must always be redefined in the subclass, thus making overriding compulsory or making the subclass itself abstract.
 * Any class that contains one or more abstract methods must also be declared with an abstract keyword.
 * There can be no object of an abstract class. That is, an abstract class can not be directly instantiated with the new operator.
 * An abstract class can have parameterized constructors and the default constructor is always present in an abstract class.
 *
 * */

public class AbstractClassExample {

    public static void main(String[] args)
    {
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Fluffy");

        myDog.makeSound();
        myCat.makeSound();
    }
}

// Java program to illustrate the
// concept of Abstraction
// Java Program to implement
// Java Abstraction

// Abstract Class declared
abstract class Animal {
    private String name;

    public Animal(String name) { this.name = name; }

    public abstract void makeSound();

    public String getName() { return name; }
}

// Abstracted class
class Dog extends Animal {
    public Dog(String name) { super(name); }

    public void makeSound()
    {
        System.out.println(getName() + " barks");
    }
}

// Abstracted class
class Cat extends Animal {
    public Cat(String name) { super(name); }

    public void makeSound()
    {
        System.out.println(getName() + " meows");
    }
}
