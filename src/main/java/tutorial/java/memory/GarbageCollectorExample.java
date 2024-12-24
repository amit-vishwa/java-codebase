package tutorial.java.memory;

/**
 * Ways to make an object eligible for the garbage collector
 * i.Nullifying the reference variable
 * ii.By assigning a reference variable to another.
 * iii.By anonymous object. (eg. new Student();)
 *
 * References, method and local variables, threads are stored in fast stack memory
 * Objects are stored in slow heap memory
 * */
public class GarbageCollectorExample {

    public static void main(String[] args)
    {
        GarbageCollectorExample t1 = new GarbageCollectorExample();
        GarbageCollectorExample t2 = new GarbageCollectorExample();

        // Nullifying the reference variable
        t1 = null;

        // requesting JVM for running Garbage Collector
        System.gc();

        // Nullifying the reference variable
        t2 = null;

        // requesting JVM for running Garbage Collector
        Runtime.getRuntime().gc();

    }

    @Override
    // finalize method is called on object once
    // before garbage collecting it
    protected void finalize() {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }

}
