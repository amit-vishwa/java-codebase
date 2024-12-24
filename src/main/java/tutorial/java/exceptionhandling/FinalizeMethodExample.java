package tutorial.java.exceptionhandling;

/**
 *
 * It is a method that the Garbage Collector always calls just before the deletion/destroying of the object
 * which is eligible for Garbage Collection, so as to perform clean-up activity.
 * Clean-up activity means closing the resources associated with that object like Database Connection,
 * Network Connection, or we can say resource de-allocation. Remember, it is not a reserved keyword.
 * Once the finalized method completes immediately Garbage Collector destroys that object.
 * finalize method is present in the Object class and its syntax is:
 * protected void finalize throws Throwable{}
 *
 * Since the Object class contains the finalize method, hence finalize method is available for every
 * Java class since Object is the superclass of all Java classes. Since it is available for every java
 * class hence Garbage Collector can call finalize method on any Java object Now, the finalize method
 * which is present in the Object class, has an empty implementation, in our class clean-up activities
 * are there, then we have to override this method to define our own clean-up activities.
 *
 * Cases related to finalizing method:
 * Case 1: The object which is eligible for Garbage Collection, that object’s corresponding class
 * finalize method is going to be executed
 * Case 2: We can call finalize method Explicitly then it will be executed just like a normal method call,
 * but the object won’t be deleted/destroyed
 * Case 3:
 * Part a) If the programmer calls finalize method while executing finalize method, some unchecked exception rises.
 * Part b) If the garbage Collector calls finalize method while executing finalize method, some unchecked exception rises.
 *
 * Important points:
 * There is no guarantee about the time when finalize is called. It may be called any time after the
 * object is not being referred anywhere (can be garbage collected).
 * JVM does not ignore all exceptions while executing finalize method, but it ignores only unchecked
 * exceptions. If the corresponding catch block is there, then JVM won’t ignore any corresponding catch
 * block and will be executed.
 * System.gc() is just a request to JVM to execute the Garbage Collector. It’s up to JVM to call
 * Garbage Collector or not. Usually, JVM calls Garbage Collector when there is not enough space
 * available in the Heap area or when the memory is low.
 *
 * Refer: https://www.geeksforgeeks.org/g-fact-24-finalfinally-and-finalize-in-java/?ref=next_article
 * */

// case 1
public class FinalizeMethodExample {
        public static void main(String[] args)
        {
            String s = new String("RR");
            s = null;

            // Requesting JVM to call Garbage Collector method
            System.gc();
            System.out.println("Main Completes");
        }

        // Here overriding finalize method
        public void finalize()
        {
            System.out.println("finalize method overridden");
        }
}

// case 2
class Bye {
    public static void main(String[] args)
    {
        Bye m = new Bye();

        // Calling finalize method Explicitly.
        m.finalize();
        m.finalize();
        m = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    public void finalize()
    {
        System.out.println("finalize method overridden");
    }
}


// 3.a
class Hi {
    public static void main(String[] args)
    {
        Hi j = new Hi();

        // Calling finalize method Explicitly.
        j.finalize();

        j = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    public void finalize()
    {
        System.out.println("finalize method overridden");
        System.out.println(10 / 0);
    }
}


// 3.b
class Test1 {
    public static void main(String[] args)
    {
        Test1 test1 = new Test1();
        test1 = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    public void finalize()
    {
        System.out.println("finalize method overridden");
        System.out.println(10 / 0);
    }
}
