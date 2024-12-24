package tutorial.dsa.algorithms.bitwise;

/**
 *
 * Refer: https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * 3) Extract the Lowest Set bit of x
 * x & ~(x-1);
 * Logic:
 * When you subtract 1 from x, all the bits to the right of the lowest set bit become 1, and the lowest set bit becomes 0 and performing a bitwise AND operation between x and ~(x-1) sets each bit to 0 except for the lowest set bit of x.
 * Example:
 * x = 10101010
 * ~(x-1) = 01010110
 * x & ~(x-1) = 00000010
 *
 * */
public class ExtractLowestSetBit {
    public static void main(String... args){
        int num = 254300;
        System.out.println(num +" "+Integer.toBinaryString(num));
        num = num & ~(num-1);
        System.out.println(num +" "+Integer.toBinaryString(num));
    }
}
