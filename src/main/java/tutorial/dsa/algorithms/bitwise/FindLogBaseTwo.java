package tutorial.dsa.algorithms.bitwise;

/**
 * Refer : https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * 11) Find log base 2 of 32 bit integer
 * int log2(int x)
 * {
 *     int res = 0;
 *     while (x >>= 1)
 *         res++;
 *     return res;
 * }
 * Logic: We right shift x repeatedly until it becomes 0, meanwhile we keep count on the shift operation.
 * This count value is the log2(x).
 * */
public class FindLogBaseTwo {
    public static void main(String... args){
        int num = 127;
        int res = 0;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        do{
            num >>= 1;
            res++;
        }while (num > 0);
        System.out.println(res);
    }
}
