package tutorial.java.memory;

/**
 * Refer: https://www.geeksforgeeks.org/java-memory-management/?ref=lbp
 *
 * Java memory management is a fundamental concept that involves the automatic allocation and deallocation of objects, managed by
 * the Java Virtual Machine (JVM). The JVM uses a garbage collector to automatically remove unused objects, freeing up memory in
 * the background. This eliminates the need for developers to manually handle memory management. This article will focus on
 * Memory management in Java, how the heap works, reference types, garbage collection, and also related concepts.
 *
 * JVM Memory Structure
 * JVM defines various run time data area which are used during execution of a program. Some of the areas are created by the
 * JVM whereas some are created by the threads that are used in a program. However, the memory area created by JVM is destroyed
 * only when the JVM exits. The data areas of thread are created during instantiation and destroyed when the thread exits. These
 * areas include:
 * - Heap Area
 * - Method Area
 * - JVM Stacks
 * - Native Method Stacks
 * - Program Counter (PC) Registers
 * */
public class MemoryStorageExample {

    public static void main(String[] args) {
        Geeks g = new Geeks();

        // Calling the Display method
        g.Display();
    }
}

// Java Program to deomnstrate how java variables
// are stored in the different memeory areas
class Geeks {

    // static variables are stored in the Method Area
    static int v = 100;

    // instance variables are stored in the Heap
    int i = 10;

    public void Display()
    {
        // local variables are stored in the Stack
        int s = 20;

        System.out.println(v);
        System.out.println(s);
    }
}
