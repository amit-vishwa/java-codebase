package tutorial.java.interfaces.nested;

public class InterfaceInInterfaceExample {
    public static void main(String[] args)
    {
        Test1.Yes obj;
        Testing1 t = new Testing1();
        obj = t;
        obj.show();
    }
}

// Java program to demonstrate working of
// interface inside another interface.

interface Test1 {
    // this interface can be public only
    interface Yes {
        void show();
    }
}

class Testing1 implements Test1.Yes {
    public void show()
    {
        System.out.println("show method of interface");
    }
}
