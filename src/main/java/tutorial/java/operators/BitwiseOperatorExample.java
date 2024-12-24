package tutorial.java.operators;

import java.util.Scanner;

public class BitwiseOperatorExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        byte num1 = input.nextByte();
        System.out.print("Enter second number: ");
        byte num2 = input.nextByte();
        System.out.println("num1: " + num1 + ", num2: " + num2);
        System.out.println("num1: " + Integer.toBinaryString(num1) + ", num2: " + Integer.toBinaryString(num2));
        System.out.println("Bitwise AND: " + (num1 & num2));
        System.out.println("Bitwise OR: " + (num1 | num2));
        System.out.println("Bitwise XOR: " + (num1 ^ num2));
        System.out.println("Bitwise NOT: " + (~num1));
        System.out.println("Bitwise Left Shift: " + (num1 << 2));
        System.out.println("Bitwise Right Shift: " + (num2 >> 2));
        System.out.println("Bitwise Unsigned Right Shift: " + (num2 >>> 2));
        input.close();
    }
}