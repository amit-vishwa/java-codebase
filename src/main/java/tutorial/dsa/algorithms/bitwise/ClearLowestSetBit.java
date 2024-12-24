package tutorial.dsa.algorithms.bitwise;

/**
 *
 * Refer: https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * 2) Clear the Lowest Set bit of x
 *  x & (x-1)
 * Logic:
 * When you subtract 1 from x, all the bits to the right of the lowest set bit become 1, and the lowest set bit becomes 0 and performing a bitwise AND operation between x and (x-1) sets each bit to 0 except for the bits that are common in both x and (x-1).
 * Example:
 * x = 10101010
 * x-1 = 10101001
 * x & (x-1) = 10101000
 *
 * */
public class ClearLowestSetBit {
    public static void main(String[] args){
        int num = 36561;
        System.out.println(Integer.toBinaryString(num));
        num = num & num - 1;
        System.out.println(Integer.toBinaryString(num));
        System.out.println();
        int num2 = 12342300;
        System.out.println(Integer.toBinaryString(num2));
        num2 = num2 & num2 - 1;
        System.out.println(Integer.toBinaryString(num2));
    }
}
