package tutorial.java.io;

import java.util.Scanner;

// Java Program to show how to take
// input from user using Scanner Class

class ScannerExample {

    public static void main(String[] args)
    {
        // Scanner definition
        Scanner scn = new Scanner(System.in);

        // input is a string ( one word )
        // read by next() function
        String str1 = scn.next();

        // print String
        System.out.println("Entered String str1 : " + str1);

        // input is a String ( complete Sentence )
        // read by nextLine()function
        String str2 = scn.nextLine(); // it can take input from first input string after first word

        // print string
        System.out.println("Entered String str2 : " + str2);

        // input is an Integer
        // read by nextInt() function
        int x = scn.nextInt();

        // print integer
        System.out.println("Entered Integer : " + x);

        // input is a floatingValue
        // read by nextFloat() function
        float f = scn.nextFloat();

        // print floating value
        System.out.println("Entered FloatValue : " + f);

        char c = scn.next().charAt(0); // it can take input from first input string after first word

        // print character
        System.out.println("Entered Character c : " + c);
    }
}