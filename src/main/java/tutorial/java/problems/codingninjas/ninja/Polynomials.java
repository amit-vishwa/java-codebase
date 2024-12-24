package tutorial.java.problems.codingninjas.ninja;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * https://www.naukri.com/code360/problems/polynomials_3164694?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&count=25&page=1&search=pol&sort_entity=order&sort_order=ASC
 *
 * Problem statement
 * You are given two polynomials. You have to multiply them and print the result.
 *
 * You are given the coefficients of the first and second polynomials denoted by array A and array B respectively.
 * You have to return the coefficient of the resulting polynomials.
 *
 * Example:-
 * A = [1,2,3]
 * B = [3,2,1]
 *
 * ANSWER:- The answer should be [3,8,14,8,3] as the polynomials are x^2 + 2x + 3 and 3x^2 + 2x + 1.
 * On multiplying we get 3x^4 + 8x^3 + 14x^2 + 8x + 3 and hence the answer is [3, 8, 14, 8, 3].
 *
 * */
public class Polynomials {
    private static void setElement(int index, int index1, int index2, int[] res, int[] a, int[] b){
        int i = index1;
        int j = index2;
        while(i >= index2){
            res[index] += a[i]*b[j];
            i--;
            j++;
        }
    }
    public static int[] multiply(int[] a, int[] b, int n)
    {
        // Write your code here
        if(n <= 1){
            return new int[]{a[0]*b[0]};
        }
        int[] res = new int[2 * n - 1];
        int index = 0;
        int reverseIndex = 1;
        while (index < res.length){
            if(index < n){
                setElement(index, index, 0, res, a, b);
            }else{
                setElement(index,n-1, reverseIndex, res, a, b);
                reverseIndex++;
            }
            index++;
        }
        return res;
    }
    public static void main(String... args){
        int a[] = {39,9,5,42,37,20,3,8,16,26,17,25,28};
        int b[] = {39,34,5,20,29,16,2,42,10,20,31,48,13};
        System.out.println(Arrays.toString(multiply(a,b,a.length)));
//        int a[] = {1,2,3,4,5};
//        int b[] = {6,7,8,9,10};
//        System.out.println(Arrays.toString(multiply(a,b,a.length)));
    }
}
/**
 *
 * Inputs and Outputs (=>):
 * 13
 * 39 9 5 42 37 20 3 8 16 26 17 25 28
 * 39 34 5 20 29 16 2 42 10 20 31 48 13
 * => 1521 1677 696 2633 4207 3233 2189 4208 3834 3994 5471 6548 6289 5168 5575 5363 4192 2444 2715 3444 2763 2489 2289 1669 364
 *
 * 14
 * 1 44 26 15 5 40 26 39 37 22 5 11 4 39
 * 16 23 20 12 4 37 19 16 9 28 25 29 48 28
 * => 16 727 1448 1730 1477 1580 3367 3956 4271 3765 5204 5125 5845 7379 7664 5739 5233 5616 6780 5267 4599 2975 2367 1759 1631 1984 1092
 *
 * 2
 * 48 45
 * 43 23
 * => 2064 3039 1035
 *
 * 6
 * 32 21 37 29 14 42
 * 36 26 13 14 15 45
 * => 1152 1588 2294 2727 2513 4526 3180 2842 2103 1260 1890
 *
 * 17
 * 43 11 10 5 40 12 49 50 7 7 45 2 5 34 45 33 4
 * 23 27 34 47 45 32 37 41 49 14 40 48 20 46 38 5 18
 * => 989 1414 1989 2780 3847 3867 5439 7476 8629 7909 10450 10619 10066 11524 13524 12170 12170 14265 13307 9920 11786 9993 7098 7322 6153 4873 5218 4275 3568 2275 1127 614 72
 *
 * */