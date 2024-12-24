package tutorial.java.oops.polymorphism;

/**
 *
 * It is also known as Dynamic Method Dispatch. It is a process in which a function call to the
 * overridden method is resolved at Runtime. This type of polymorphism is achieved by Method Overriding.
 * Method overriding, on the other hand, occurs when a derived class has a definition for one of the member
 * functions of the base class. That base function is said to be overridden.
 *
 * */

public class RunTimeExample {

    public static void main(String[] args)
    {
        // Creating object of class 1
        Parent a;

        // Now we will be calling print methods
        // inside main() method

        a = new subclass1();
        a.Print();

        a = new subclass2();
        a.Print();
    }

}

// Java Program for Method Overriding

// Class 1
// Helper class
class Parent {

    // Method of parent class
    void Print()
    {
        // Print statement
        System.out.println("parent class");
    }
}

// Class 2
// Helper class
class subclass1 extends Parent {

    // Method
    void Print() { System.out.println("subclass1"); }
}

// Class 3
// Helper class
class subclass2 extends Parent {

    // Method
    void Print()
    {
        // Print statement
        System.out.println("subclass2");
    }
}
