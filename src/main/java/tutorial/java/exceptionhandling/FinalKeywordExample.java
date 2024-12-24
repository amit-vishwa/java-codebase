package tutorial.java.exceptionhandling;

/**
 *
 * final (lowercase) is a reserved keyword in java. We can’t use it as an identifier, as it is reserved.
 * We can use this keyword with variables, methods, and also with classes.
 * The final keyword in java has a different meaning depending upon whether it is applied to a variable,
 * class, or method.
 *
 * i.final with Variables: The value of the variable cannot be changed once initialized.
 * ii.final with Class: The class cannot be subclassed. Whenever we declare any class as final,
 * it means that we can’t extend that class or that class can’t be extended,
 * or we can’t make a subclass of that class.
 * iii.final with Method: The method cannot be overridden by a subclass.
 * Whenever we declare any method as final, then it means that we can’t override that method.
 *
 * */

public class FinalKeywordExample {
    public static void main(String[] args)
    {
        RR r = new RR();
        // See modified contents of variable j.
        r.j = 36;
        System.out.println(r.j);

        int a = 5;

        // final variable
        final int b = 6;

        // modifying the non final variable : Allowed
        a++;

        // modifying the final variable :  Immediately gives Compile Time error.
//        b++;
        System.out.println(a + " " + b);
        AB.finalMethodDemo();
    }
}
class AB{
    final static void finalMethodDemo(){
        System.out.println("Final Demo Method called");
    }
}
class BB extends AB{
    // below parent class method cannot be overriden as it is final
//    void finalMethodDemo(){ }
}

// Note : If a class is declared as final as by default all of the methods present in that class
// are automatically final, but variables are not.
final class RR {
    // by default it is final.
    void h() {}

    // by default it is not final.
    static int j = 30;
}
// here gets Compile time error that  we can't extend RR as it is final.
//class KK extends RR { }
