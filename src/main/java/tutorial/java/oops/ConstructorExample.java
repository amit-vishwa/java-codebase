package tutorial.java.oops;

/**
 *
 * Rules of constructor chaining :
 *
 * The this() expression should always be the first line of the constructor.
 * There should be at-least be one constructor without the this() keyword (constructor 3 in above example).
 * Constructor chaining can be achieved in any order.
 *
 * Alternative method : using Init block :
 * When we want certain common resources to be executed with every constructor we can put the code in the
 * init block. Init block is always executed before any constructor, whenever a constructor is used for
 * creating a new object. Multiple init blocks will result in execution in same order as they are created
 *
 * */


public class ConstructorExample {
    public static void main(String args[])
    {
        // calls parameterized constructor 4
        Derived obj = new Derived("test");

        // Calls No-argument constructor
         Derived obj1 = new Derived();
    }
}

// Java program to illustrate Constructor Chaining to
// other class using super() keyword
class Base
{
    String name;

    // constructor 1
    Base()
    {
        this("");
        System.out.println("No-argument constructor of" +
                " base class");
    }

    // constructor 2
    Base(String name)
    {
        this.name = name;
        System.out.println("Calling parameterized constructor"
                + " of base");
    }
}

class Derived extends Base
{
    // constructor 3
    Derived()
    {
        System.out.println("No-argument constructor " +
                "of derived");
    }

    // parameterized constructor 4
    Derived(String name)
    {
        // invokes base class constructor 2
        super(name);
        System.out.println("Calling parameterized " +
                "constructor of derived");
    }


}
