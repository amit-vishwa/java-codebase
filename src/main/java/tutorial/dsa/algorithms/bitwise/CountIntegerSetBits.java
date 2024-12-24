package tutorial.dsa.algorithms.bitwise;

/**
 * Refer: https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * 10) Count set bits in integer
 * int countSetBits(int x)
 * {
 *     int count = 0;
 *     while (x)
 *     {
 *         x &= (x-1);
 *         count++;
 *     }
 *     return count;
 * }
 * Logic: This is Brian Kernighan’s algorithm.
 * */
public class CountIntegerSetBits {
    public static void main(String[] args){
        int x = 127;
        int count = 0;
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        while (x>0)
        {
            x &= (x-1);
            count++;
        }
        System.out.println(count);
    }
}
