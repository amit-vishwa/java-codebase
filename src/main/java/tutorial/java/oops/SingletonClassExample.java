package tutorial.java.oops;

/**
 *
 * There are various scenarios where we can use private constructors. The major ones are
 *
 * Internal Constructor chaining
 * Singleton class design pattern
 *
 * */

// Java program to demonstrate implementation of Singleton
// pattern using private constructors.
class MySingleton
{
    static MySingleton instance = null;
    public int x = 10;

    // private constructor can't be accessed outside the class
    private MySingleton() { }

    // Factory method to provide the users with instances
    static public MySingleton getInstance()
    {
        if (instance == null)
            instance = new MySingleton();

        return instance;
    }
}

class SingletonClassExample
{
    public static void main(String args[])
    {
        MySingleton a = MySingleton.getInstance();
        MySingleton b = MySingleton.getInstance();
        a.x = a.x + 10;
        System.out.println("Value of a.x = " + a.x);
        System.out.println("Value of b.x = " + b.x);
        // We changed value of a.x, value of b.x also got updated because both ‘a’ and ‘b’ refer to
        // same object, i.e., they are objects of a singleton class.
    }
}
