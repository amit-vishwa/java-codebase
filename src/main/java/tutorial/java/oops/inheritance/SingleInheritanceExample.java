package tutorial.java.oops.inheritance;

// In single inheritance, a sub-class is derived from only one super class.
// It inherits the properties and behavior of a single-parent class.
// Sometimes, it is also known as simple inheritance.

import java.math.BigInteger;

public class SingleInheritanceExample {
    public static void main(String[] args)
    {
        Two g = new Two();
        g.print_geek();
        g.print_for();
        g.print_geek();
        BigInteger b1 = BigInteger.valueOf(5);
        BigInteger b2 = BigInteger.valueOf(21);
        BigInteger gcd = b1.gcd(b2);
        System.out.println(gcd.intValue());
    }
}

// Java program to illustrate the concept of single inheritance
// Parent class
class One {
    public void print_geek()
    {
        System.out.println("Geeks");
    }
}

class Two extends One {
    public void print_for() { System.out.println("for"); }
}
