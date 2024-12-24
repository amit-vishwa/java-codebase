package tutorial.dsa.algorithms.bitwise;

/**
 * Refer : https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * 13) Find the last set bit
 * int lastSetBit(int n){
 *     return log2(n & -n)+1;
 * }
 * The logarithmic value of AND of x and -x to the base 2 gives the index of the last set bit(for 0-based indexing).
 * */
public class FindLastSetBit {
    public static void main(String[] args){
        int num = 64;
        int andOfNumAndNumNegative = num & -num;
        System.out.println(num+" "+((int)Math.log(andOfNumAndNumNegative)+1));
    }
}
