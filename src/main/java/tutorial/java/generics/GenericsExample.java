package tutorial.java.generics;

/**
 *
 * Generics means parameterized types. The idea is to allow a type (like Integer, String, etc., or
 * user-defined types) to be a parameter to methods, classes, and interfaces. Using Generics,
 * it is possible to create classes that work with different data types. An entity such as a class,
 * interface, or method that operates on a parameterized type is a generic entity.
 *
 * Types of Java Generics
 * i.Generic Method: Generic Java method takes a parameter and returns some value after performing a task.
 * It is exactly like a normal function, however, a generic method has type parameters that are cited by
 * actual type. This allows the generic method to be used in a more general way. The compiler takes care
 * of the type of safety which enables programmers to code easily since they do not have to perform long,
 * individual type castings.
 * ii.Generic Classes: A generic class is implemented exactly like a non-generic class. The only difference
 * is that it contains a type parameter section. There can be more than one type of parameter, separated
 * by a comma. The classes, which accept one or more parameters, ?are known as parameterized classes or
 * parameterized types.
 *
 * Refer: https://www.geeksforgeeks.org/generics-in-java/
 *
 * */

public class GenericsExample {

    public static void main(String[] args)
    {

        Integer[] a = { 100, 22, 58, 41, 6, 50 };

        Character[] c = { 'v', 'g', 'a', 'c', 'x', 'd', 't' };

        String[] s = { "Virat", "Rohit", "Abhinay", "Chandu","Sam", "Bharat", "Kalam" };

        System.out.print("Sorted Integer array :  ");
        sort_generics(a);

        System.out.print("Sorted Character array :  ");
        sort_generics(c);

        System.out.print("Sorted String array :  ");
        sort_generics(s);

    }

    public static <T extends Comparable<T> > void sort_generics(T[] a)
    {

        //As we are comparing the Non-primitive data types
        //we need to use Comparable class

        //Bubble Sort logic
        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j].compareTo(a[j + 1]) > 0) {

                    swap(j, j + 1, a);
                }
            }
        }

        // Printing the elements after sorted

        for (T i : a)
        {
            System.out.print(i + ", ");
        }
        System.out.println();

    }

    public static <T> void swap(int i, int j, T[] a)
    {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}