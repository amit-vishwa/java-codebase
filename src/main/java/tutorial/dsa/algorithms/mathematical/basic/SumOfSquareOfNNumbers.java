package tutorial.dsa.algorithms.mathematical.basic;

/**
 * Refer: https://www.geeksforgeeks.org/sum-of-squares-of-first-n-natural-numbers/
 *
 * */

public class SumOfSquareOfNNumbers {
    // Approach 1: Naive approach – O(n) Time and O(1) Space
    public static int summation(int n)
    {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += (i * i);
        return sum;
    }

    // Approach 2: Efficient Approach – O(1) Time and O(1) Space
    public static int summation2(int n)
    {
        // formula => n(n+1)(2n+1) / 6
        return (n * (n + 1) *
                (2 * n + 1)) / 6;
    }

    /* Avoiding the overflow:
    In the above method, sometimes due to large value of n, the value of (n * (n + 1) * (2 * n + 1))
    would overflow. We can avoid this overflow up to some extent using the fact that n*(n+1) must be
    divisible by 2. */
    // Approach 2 with no overflow
    static int summation3(int n)
    {
        return (n * (n + 1) / 2) * (2 * n + 1) / 3;
    }

    // Approach 3: Using Recursion – O(n) Time and O(n) Space (Not Recommended in Practice)
    public static int sum_of_squares(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * n + sum_of_squares(n - 1);
        }
    }

    // Driver code
    public static void main(String args[])
    {
        System.out.println(summation(2));
        System.out.println(summation2(3));
        System.out.println(summation3(2));
        System.out.println(sum_of_squares(2));
    }
}
