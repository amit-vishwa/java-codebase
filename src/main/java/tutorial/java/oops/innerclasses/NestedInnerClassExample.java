package tutorial.java.oops.innerclasses;

/**
 *
 * Note:  We can not have a static method in a nested inner class because an inner class is implicitly
 * associated with an object of its outer class so it cannot define any static method for itself.
 * For example, the following program doesn’t compile.
 * But Since JAVA Version 16 we can have static members in our inner class also.
 *
 * */

// Class 1
// Nest inner class also known as Member Inner Class
class NestedInnerClassExample {

    // Class 2
    // Simple nested inner class
    class Inner {

        // show() method of inner class
        public void show()
        {

            // Print statement
            System.out.println("In a nested class method");
        }

        // below method will give error as compiler fails to find class with main method
//        public static void main(String[] args)
//        {
//            System.out.println("In a nested class method");
//        }
    }
}

// Class 2
// Main class
class Main {

    // Main driver method
    public static void main(String[] args)
    {

        // Note how inner class object is created inside
        // main()
        NestedInnerClassExample.Inner in = new NestedInnerClassExample().new Inner();

        // Calling show() method over above object created
        in.show();
    }
}
