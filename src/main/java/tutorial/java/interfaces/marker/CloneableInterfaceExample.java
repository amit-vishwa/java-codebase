package tutorial.java.interfaces.marker;

import java.lang.Cloneable;

/**
 *
 * Marker interface in Java
 * It is an empty interface (no field or methods). Examples of marker interface are Serializable,
 * Cloneable and Remote interface. All these interfaces are empty interfaces.
 *
 * Cloneable interface is present in java.lang package. There is a method clone() in Object class.
 * A class that implements the Cloneable interface indicates that it is legal for clone() method to make
 * a field-for-field copy of instances of that class.
 * Invoking Object’s clone method on an instance of the class that does not implement the
 * Cloneable interface results in an exception CloneNotSupportedException being thrown.
 * By convention, classes that implement this interface should override Object.clone() method.
 *
 * */


public class CloneableInterfaceExample {
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        A a = new A(20, "GeeksForGeeks");

        // cloning 'a' and holding
        // new cloned object reference in b

        // down-casting as clone() return type is Object
        A b = (A)a.clone();

        System.out.println(b.i);
        System.out.println(b.s);
    }
}

// Java program to illustrate Cloneable interface

// By implementing Cloneable interface
// we make sure that instances of class A
// can be cloned.
class A implements Cloneable
{
    int i;
    String s;

    // A class constructor
    public A(int i,String s)
    {
        this.i = i;
        this.s = s;
    }

    // Overriding clone() method
    // by simply calling Object class
    // clone() method.
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

