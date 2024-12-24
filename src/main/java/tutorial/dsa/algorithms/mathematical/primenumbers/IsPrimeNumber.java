package tutorial.dsa.algorithms.mathematical.primenumbers;

// Refer: https://www.geeksforgeeks.org/check-for-prime-number/
public class IsPrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(1190611));
        System.out.println(isPrime2(4784009));
        System.out.println(isPrime3(9999991));
    }
    // Approach 1: [Naive Approach] Basic Trial Division Method - O(n) time and O(1) space
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        // Check divisibility from 2 to n-1
        for (int i = 2; i < n; i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    // Approach 2: [Efficient Approach - 1] Trial Division Method - O(√n) time and O(1) space
    static boolean isPrime2(int n) {
        if (n <= 1)
            return false;
        // Check divisibility from 2 to n-1
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    // Approach 3: [Expected Approach - 2] Optimized Trial Division Method - O(√n) time and O(1) space
    static boolean isPrime3(int n) {
        if (n <= 1)
            return false;
        // Check if n is 2 or 3
        if (n == 2 || n == 3)
            return true;
        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        // Check from 5 to square root of n
        // Iterate i by (i+6) as i and i+2 are already being tested
        for (int i = 5; i <= Math.sqrt(n); i+=6){
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
