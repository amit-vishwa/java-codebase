package tutorial.java.oops.inheritance;

// In Multilevel Inheritance, a derived class will be inheriting a base class, and as well as the
// derived class also acts as the base class for other classes

public class MultilevelInheritanceExample {
    public static void main(String[] args) {
        // Creating an object of class Three
        ClassThree g = new ClassThree();

        // Calling method from class One
        g.print_geek();

        // Calling method from class Two
        g.print_for();

        // Calling method from class Three
        g.print_lastgeek();
    }
}

// Parent class One
class ClassOne {
    // Method to print "Geeks"
    public void print_geek() {
        System.out.println("Geeks");
    }
}

// Child class Two inherits from class One
class ClassTwo extends ClassOne {
    // Method to print "for"
    public void print_for() {
        System.out.println("for");
    }
}

// Child class Three inherits from class Two
class ClassThree extends ClassTwo {
    // Method to print "Geeks"
    public void print_lastgeek() {
        System.out.println("Geeks");
    }
}
