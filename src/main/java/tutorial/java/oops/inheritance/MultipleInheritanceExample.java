package tutorial.java.oops.inheritance;

/**
 *
 * In Multiple inheritances, one class can have more than one superclass and inherit features
 * from all parent classes. Please note that Java does not support multiple inheritances with classes.
 * In Java, we can achieve multiple inheritances only through Interfaces.
 *
 * Multiple Inheritance is not supported by class because of ambiguity. In the case of interface,
 * there is no ambiguity because the implementation of the method(s) is provided by the implementing
 * class up to Java 7. From Java 8, interfaces also have implementations of methods.
 * So if a class implements two or more interfaces having the same method signature with implementation,
 * it is mandated to implement the method in class also.
 *
 * */

public class MultipleInheritanceExample {
    public static void main(String[] args)
    {
        Child c = new Child();
        c.print_geek();
        c.print_for();
        c.print_geek();
    }
}

// Java program to illustrate the
// concept of Multiple inheritance

interface InterFaceOne {
    public void print_geek();
}

interface InterFaceTwo {
    public void print_for();
}

interface InterFaceThree extends InterFaceOne, InterFaceTwo {
    public void print_geek();
}
class Child implements InterFaceThree {
    @Override // optional but checks for correct signature
    public void print_geek()
    {
        System.out.println("Geeks");
    }

    @Override // optional
    public void print_for() { System.out.println("for"); }
}
