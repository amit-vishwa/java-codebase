package tutorial.java.interfaces.nested;

public class InterfaceInClassExample {

    public static void main(String[] args)
    {
        Test.Yes obj;
        Testing t = new Testing();
        obj = t;
        obj.show();
    }
}

// Java program to demonstrate working of interface inside a class.
class Test {
    // here interface can be public, protected or default (i.e. package-private)
    interface Yes {
        void show();
    }
    public interface No {
        void show();
    }
    protected interface DontKnow {
        void show();
    }
}

class Testing implements Test.Yes, Test.No, Test.DontKnow {
    public void show()
    {
        System.out.println("show method of interface");
    }
}
