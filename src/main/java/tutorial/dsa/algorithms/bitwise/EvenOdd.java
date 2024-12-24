package tutorial.dsa.algorithms.bitwise;

/**
 *
 * Refer: https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * 1) Check Whether Number is Even or Odd
 * x & 1
 * Logic:
 * Even numbers have 0 as their LSB and Odd numbers have 1 as their LSB, so Bitwise AND with even numbers results in 0 and with odd numbers results in 1.
 * Example:
 * x = 29 (00011101), (x & 1) = 1, therefore x is an odd number
 * x= 16(10000), (x & 1) = 0, therefore x is an even number
 *
 * */
public class EvenOdd {
    public static void main(String... args){
        System.out.println("Number is odd: "+ (19&1));
        System.out.println("Number is odd: "+ (80&1));
        System.out.println("Number is odd: "+ (19456&1));
        System.out.println("Number is odd: "+ (190901&1));
    }
}
