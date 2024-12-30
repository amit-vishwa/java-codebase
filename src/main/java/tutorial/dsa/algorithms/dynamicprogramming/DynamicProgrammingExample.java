package tutorial.dsa.algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * Refer: https://www.geeksforgeeks.org/introduction-to-dynamic-programming-data-structures-and-algorithm-tutorials/
 *
 * Dynamic Programming is a commonly used algorithmic technique used to optimize recursive solutions when same subproblems are called again.
 * The core idea behind DP is to store solutions to subproblems so that each is solved only once.
 * To solve DP problems, we first write a recursive solution in a way that there are overlapping subproblems in the recursion tree (the recursive function is called with the same parameters multiple times)
 * To make sure that a recursive value is computed only once (to improve time taken by algorithm), we store results of the recursive calls.
 * There are two ways to store the results, one is top down (or memoization) and other is bottom up (or tabulation).
 *
 * Approaches of Dynamic Programming (DP)
 * Dynamic programming can be achieved using two approaches:
 *
 * 1. Top-Down Approach (Memoization):
 * In the top-down approach, also known as memoization, we keep the solution recursive and add a memoization table to avoid repeated calls of same subproblems.
 * Before making any recursive call, we first check if the memoization table already has solution for it.
 * After the recursive call is over, we store the solution in the memoization table.
 *
 * 2. Bottom-Up Approach (Tabulation):
 * In the bottom-up approach, also known as tabulation, we start with the smallest subproblems and gradually build up to the final solution.
 * We write an iterative solution (avoid recursion overhead) and build the solution in bottom-up manner.
 * We use a dp table where we first fill the solution for base cases and then fill the remaining entries of the table using recursive formula.
 * We only use recursive formula on table entries and do not make recursive calls.
 *
 * */
public class DynamicProgrammingExample {

    public static void main(String[] args) {
        fibonacciUsingNaiveApproach(10);
        fibonacciUsingMemoizationApproach(10);
        fibonacciUsingTabulationApproach(10);
    }

    /**
     * 1.Brute Force Approach: To find the nth Fibonacci number using a brute force approach, you would
     * simply add the (n-1)th and (n-2)th Fibonacci numbers.
     *
     * The time complexity of the below approach is exponential and upper bounded by O(2^n) as we make two
     * recursive calls in every function.
     * */
    static void fibonacciUsingNaiveApproach(int n){
        System.out.println("Fibonacci of " + n + " is " + fibonacci(n));
    }
    static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 2.Using Memoization Approach – O(n) Time and O(n) Space
     * To achieve this in our example we simply take an memo array initialized to -1. As we make a recursive
     * call, we first check if the value stored in the memo array corresponding to that position is -1.
     * The value -1 indicates that we haven’t calculated it yet and have to recursively compute it.
     * The output must be stored in the memo array so that, next time, if the same value is encountered,
     * it can be directly used from the memo array.
     * */
    static void fibonacciUsingMemoizationApproach(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println("Fibonacci of " + n + " is " + fibRec(n, memo));
    }
    static int fibRec(int n, int[] memo) {
        // Base case
        if (n <= 1) {
            return n;
        }
        // To check if output already exists
        if (memo[n] != -1) {
            return memo[n];
        }
        // Calculate and save output for future use
        memo[n] = fibRec(n - 1, memo) + fibRec(n - 2, memo);
        return memo[n];
    }

    /**
     * 3.Using Tabulation Approach – O(n) Time and O(1) Space
     * In this approach, we use an array of size (n + 1), often called dp[], to store Fibonacci numbers.
     * The array is initialized with base values at the appropriate indices, such as dp[0] = 0 and dp[1] = 1.
     * Then, we iteratively calculate Fibonacci values from dp[2] to dp[n] by using the relation
     * dp[i] = dp[i-1] + dp[i-2]. This allows us to efficiently compute Fibonacci numbers in a loop.
     * Finally, the value at dp[n] gives the Fibonacci number for the input n, as each index holds the
     * answer for its corresponding Fibonacci number.
     * */
    static void fibonacciUsingTabulationApproach(int n){
        int prevPrev = 0;
        int prev = 1;
        int curr = prev + prevPrev;
        for(int i = 2; i <= n; i++){
            curr = prev + prevPrev;
            prevPrev = prev;
            prev = curr;
        }
        System.out.println("Fibonacci of " + n + " is " + curr);
    }

}
