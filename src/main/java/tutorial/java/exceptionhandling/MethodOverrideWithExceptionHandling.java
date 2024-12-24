package tutorial.java.exceptionhandling;

import java.io.IOException;

/**
 *
 * Exception Handling with Method Overriding
 * When Exception handling is involved with Method overriding, ambiguity occurs. The compiler gets confused as to which definition is to be followed.
 *
 * Types of problems:
 *
 * There are two types of problems associated with it which are as follows:
 *
 * Problem 1:  If The SuperClass doesn’t declare an exception
 * In this problem, two cases that will arise are as follows: *
 * Case 1: If SuperClass doesn’t declare any exception and subclass declare checked exception
 * Case 2: If SuperClass doesn’t declare any exception and SubClass declare Unchecked exception
 *
 * Problem 2: If The SuperClass declares an exception
 * Now dwelling onto the next problem associated with that is if The SuperClass declares an exception. In this problem 3 cases will arise as follows:
 * Case 1: If SuperClass declares an exception and SubClass declares exceptions other than the child exception of the SuperClass declared Exception.
 * Case 2: If SuperClass declares an exception and SubClass declares a child exception of the SuperClass declared Exception.
 * Case 3: If SuperClass declares an exception and SubClass declares without exception.
 *
 * Refer: https://www.geeksforgeeks.org/exception-handling-with-method-overriding-in-java/?ref=next_article
 *
 * */

public class MethodOverrideWithExceptionHandling {
    public static void main(String args[]) {
        SuperClass s = new SubClass();
        s.method();
    }
}

// Problem 1: Case 1: If SuperClass doesn’t declare any exception and subclass declare checked exception.
class SuperClass {
    // SuperClass doesn't declare any exception
    void method() {
        System.out.println("SuperClass");
    }
}
// SuperClass inherited by the SubClass
class SubClass extends SuperClass {
    // method() declaring Checked Exception IOException
//    void method() throws IOException {
//        // IOException is of type Checked Exception
//        // so the compiler will give Error
//        System.out.println("SubClass");
//    }
}


// Problem 1: Case 1: If SuperClass doesn’t declare any exception and subclass declare checked exception.
class SuperClass1 {
    // SuperClass doesn't declare any exception
    void method()
    {
        System.out.println("SuperClass1");
    }
}
// SuperClass inherited by the SubClass
class SubClass1 extends SuperClass1 {
    // method() declaring Unchecked Exception ArithmeticException
    void method() throws ArithmeticException
    {
        // ArithmeticException is of type Unchecked Exception
        // so the compiler won't give any error
        System.out.println("SubClass1");
    }
    // Driver code
    public static void main(String args[])
    {
        SuperClass1 s = new SubClass1();
        s.method();
    }
}

// Problem 2: Case 1: If SuperClass declares an exception and SubClass declares exceptions other than the child exception of the SuperClass declared Exception.
class SuperClass2 {
    // SuperClass declares an exception
    void method() throws RuntimeException {
        System.out.println("SuperClass2");
    }
}
// SuperClass inherited by the SubClass
class SubClass2 extends SuperClass2 {
    // SubClass declaring an exception
// which are not a child exception of RuntimeException
//    void method() throws Exception {
//        // Exception is not a child exception
//        // of the RuntimeException
//        // So the compiler will give an error
//        System.out.println("SubClass2");
//    }
    // Driver code
    public static void main(String args[]) {
        SuperClass2 s = new SubClass2();
        s.method();
    }
}

// Problem 2: Case 2: If SuperClass declares an exception and SubClass declares a child exception of the SuperClass declared Exception.
class SuperClass3 {
    // SuperClass declares an exception
    void method() throws RuntimeException
    {
        System.out.println("SuperClass3");
    }
}
// SuperClass inherited by the SubClass
class SubClass3 extends SuperClass3 {
    // SubClass declaring a child exception
    // of RuntimeException
    void method() throws ArithmeticException
    {
        // ArithmeticException is a child exception
        // of the RuntimeException
        // So the compiler won't give an error
        System.out.println("SubClass3");
    }
    // Driver code
    public static void main(String args[])
    {
        SuperClass3 s = new SubClass3();
        s.method();
    }
}

// Problem 2: Case 3: If SuperClass declares an exception and SubClass declares without exception.
class SuperClass4 {

    // SuperClass declares an exception
    void method() throws IOException
    {
        System.out.println("SuperClass4");
    }
}

// SuperClass inherited by the SubClass
class SubClass4 extends SuperClass4 {

    // SubClass declaring without exception
    void method()
    {
        System.out.println("SubClass4");
    }
    // Driver code
    public static void main(String args[])
    {
        SuperClass4 s = new SubClass4();
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
