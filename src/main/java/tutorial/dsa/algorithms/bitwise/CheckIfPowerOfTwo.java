package tutorial.dsa.algorithms.bitwise;

/**
 * Refer : https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * 12) Checking if given 32-bit integer is power of 2
 * int isPowerof2(int x)
 * {
 *     return (x && !(x & x-1));
 * }
 * Logic:
 * All the power of 2 have only single bit set e.g. 16 (00010000). If we minus 1 from this, all the bits from LSB to set bit get toggled, i.e., 16-1 = 15 (00001111). Now if we AND x with (x-1) and the result is 0 then we can say that x is power of 2 otherwise not. We have to take extra care when x = 0.
 * Example :
 * x = 16(00010000)
 * x – 1 = 15(00001111)
 * x & (x-1) = 0
 * so, 16 is power of 2
 * */
public class CheckIfPowerOfTwo {
    public static void main(String args[]){
        int num = 128;
        boolean isPowerOfTwo = (num & num-1) == 0;
        System.out.println(num+" "+isPowerOfTwo);
        int num2 = 127;
        boolean isPowerOf2 = (num2 & num2-1) == 0;
        System.out.println(num2+" "+isPowerOf2);
    }
}
