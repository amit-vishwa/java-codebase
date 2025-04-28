package youtube.map.weakhashmap;

import java.lang.ref.WeakReference;

/**
 * Garbage collection is done by JVM when memory allocated for object is not in use.
 * It clears the unused memory to free the space.
 *
 * Garbage collection on weak reference can be performed by JVM, or it can be done through code.
 * Garbage collection on strong reference can be performed by JVM only when object reference is null,
 * cannot be performed explicitly as well, until reference is not null.
 * */
public class GarbageCollection {

    public static void main(String[] args) {
        strongWeakReference();
    }

    private static void strongWeakReference() {
        // creating a weak reference
        WeakReference<Phone> weakReference = new WeakReference<>(new Phone("Samsung","S23"));
        System.out.println(weakReference.get());
        System.gc(); // ask JVM to perform garbage collection on weak reference
        System.out.println(weakReference.get()); // this will be null after GC

        // creating a string reference
        Phone phone = new Phone("Apple","16 pro max");
        System.out.println(phone);
        System.gc(); // asking JVM to clean up, it won't be able to clean up the strong reference
        System.out.println(phone);
        phone = null; // reference is set to null, Phone object is not accessible now
        System.gc(); // this is of no use, as JVM does cleanup when needed
        System.out.println(phone);
    }

}

class Phone {

    String brand;
    String model;

    Phone(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

}
