package tutorial.dsa.algorithms.mathematical.basic;

/**
 *
 * Refer: https://www.geeksforgeeks.org/program-find-sum-first-n-natural-numbers/
 *
 * */
public class SumOfNNumbers {
    // Approach 1: Naive Solution – O(n) Time and O(1) Space
    static int findSum(int n)
    {
        int sum = 0;
        for (int x = 1; x <= n; x++)
            sum = sum + x;
        return sum;
    }
    // Approach 2: Expected Approach – O(1) Time and O(1) Space
    static int findSum2(int n)
    {
        return n * (n + 1) / 2;
    }
    // Note: The above approach causes overflow, even if the result is not beyond the integer limit.
    // We can avoid overflow up to some extent by dividing first.
    // Approach 2 wth handled integer overflow for larger n
    static int findSum3(int n)
    {
        if (n % 2 == 0)
            return (n / 2) * (n + 1);
            // If n is odd, (n+1) must be even
        else
            return ((n + 1) / 2) * n;
    }
    public static void main(String args[])
    {
        System.out.println(findSum(5));
        System.out.println(findSum2(36345));
        System.out.println(findSum3(7845));
    }
}
