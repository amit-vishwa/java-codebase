package tutorial.dsa.algorithms.bitwise;

/**
 *
 * Refer: https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * */
public class DivMulByTwo {
    public static void main(String... args){
        int num = 50;
        /**
         * 6) Divide by 2
         * x >>= 1;
         * Logic:
         * When we do arithmetic right shift, every bit is shifted to right and blank position is substituted with sign bit of number, 0 in case of positive and 1 in case of negative number. Since every bit is a power of 2, with each shift we are reducing the value of each bit by factor of 2 which is equivalent to division of x by 2.
         * Example:
         * x = 18(00010010)
         * x >> 1 = 9 (00001001)
         * */
        System.out.println("Number: "+num+", Divide by 2: "+(num>>1));

        /**
         * 7) Multiplying by 2
         * x <<= 1;
         * Logic:
         * When we do arithmetic left shift, every bit is shifted to left and blank position is substituted with 0 . Since every bit is a power of 2, with each shift we are increasing the value of each bit by a factor of 2 which is equivalent to multiplication of x by 2.
         * Example:
         * x = 18(00010010)
         * x << 1 = 36 (00100100)
         * */
        System.out.println("Number: "+num+", Multiply by 2: "+(num<<1));
    }
}
