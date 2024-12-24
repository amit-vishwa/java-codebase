package tutorial.java.interfaces.marker;

import java.io.*;

/**
 *
 * Serializable interface: Serializable interface is present in java.io package. It is used to make an
 * object eligible for saving its state into a file. This is called Serialization.
 * Classes that do not implement this interface will not have any of their state serialized or deserialized.
 * All subtypes of a serializable class are themselves serializable.
 *
 * Remote interface : Remote interface is present in java.rmi package.
 * A remote object is an object which is stored at one machine and accessed from another machine.
 * So, to make an object a remote object, we need to flag it with Remote interface.
 * Here, Remote interface serves to identify interfaces whose methods may be invoked from a non-local
 * virtual machine.Any object that is a remote object must directly or indirectly implement this interface.
 * RMI (Remote Method Invocation) provides some convenience classes that remote object implementations
 * can extend which facilitate remote object creation.
 *
 * Refer: https://www.geeksforgeeks.org/marker-interface-java/?ref=next_article
 *
 * */

public class SerializableInterfaceExample {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException
    {
        ClassA a = new ClassA(20,"GeeksForGeeks");

        // Serializing 'a'
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);

        // De-serializing 'a'
        FileInputStream fis = new FileInputStream("xyz.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ClassA b = (ClassA)ois.readObject();//down-casting object

        System.out.println(b.i+" "+b.s);

        // closing streams
        oos.close();
        ois.close();
    }
}

// Java program to illustrate Serializable interface

// By implementing Serializable interface
// we make sure that state of instances of class A
// can be saved in a file.
class ClassA implements Serializable
{
    int i;
    String s;

    // A class constructor
    public ClassA(int i,String s)
    {
        this.i = i;
        this.s = s;
    }
}
