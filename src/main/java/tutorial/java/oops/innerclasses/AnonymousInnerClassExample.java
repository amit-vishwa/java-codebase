package tutorial.java.oops.innerclasses;

/**
 *
 * Anonymous inner classes are declared without any name at all. They are created in below ways.
 *
 * As a subclass of the specified type
 * As an implementer of the specified interface
 * Anonymous Inner class that defines inside method/constructor argument
 *
 * */

// Java Program to Illustrate Anonymous Inner Classes
// Declaration Without Any Name
// As an implementer of Specified interface

// Interface
interface Hello {

    // Method defined inside interface
    void show();
}

// Class 1
// Helper class
class Demo {

    // Method of helper class
    void show()
    {
        // Print statement
        System.out.println(
                "i am in show method of super class");
    }
}

// Main class
class AnonymousInnerClassExample {

    // Class implementing interface
    static Hello h = new Hello() {

        // Method 1
        // show() method inside main class
        public void show()
        {
            // Print statement
            System.out.println("i am in anonymous class");
        }
    };

    //  An anonymous class with Demo as base class
    static Demo d = new Demo() {
        // Method 1
        // show() method
        void show()
        {
            // Calling method show() via super keyword
            // which refers to parent class
            super.show();

            // Print statement
            System.out.println("i am in AnonymousInnerClassExample class");
        }
    };

    // Method 2
    // Main driver method
    public static void main(String[] args)
    {
        // Calling show() method inside main() method
        h.show();
        d.show();
    }
}