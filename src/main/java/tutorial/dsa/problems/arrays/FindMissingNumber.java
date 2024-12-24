package tutorial.dsa.problems.arrays;

/**
 *
 * Refer: https://www.geeksforgeeks.org/find-the-missing-number/
 *
 * Given an array arr[] of size n-1 with integers in the range of [1, n], the task is to find the missing number from the first n integers.
 *
 * Note: There are no duplicates in the list.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 4, 6, 3, 7, 8] , n = 8
 * Output: 5
 * Explanation: Here the size of the array is 8, so the range will be [1, 8]. The missing number between 1 to 8 is 5
 *
 *
 * Input: arr[] = [1, 2, 3, 5], n = 5
 * Output: 4
 * Explanation: Here the size of the array is 4, so the range will be [1, 5]. The missing number between 1 to 5 is 4
 *
 * */

public class FindMissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingNumberUsingHashArray(new int[]{ 1, 2, 3, 5 }));
        System.out.println(findMissingNumberUsingSummation(new int[]{ 1, 2, 3, 4, 6 }));
        System.out.println(findMissingNumberUsingXOR(new int[]{ 1, 2, 4, 7, 3, 5, 8 }));
    }

    /**
     *
     * [Naive Approach] Using Hashing – O(n) time and O(n) auxiliary space
     * The very basic idea is to use an array to store the frequency of each element
     * in the given array. The number with a frequency of 0 is the missing number.
     *
     **/
    private static int findMissingNumberUsingHashArray(int arr[]){
        int n = arr.length + 1;
        // Create hash array of size n+1
        int[] hash = new int[n + 1];
        // Store frequencies of elements
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * [Expected Approach-1] Using Sum of n terms Formula – O(n) time and O(1) auxiliary space
     * An efficient approach is to use summation formula. As we know that the sum of the first n natural
     * numbers is given by the formula n * (n + 1) / 2. Compute this sum and subtract the sum of all
     * elements in the array from it to get the missing number.
     *
     **/
    private static int findMissingNumberUsingSummation(int arr[]){
        int n = arr.length + 1;
        // Calculate the sum of array elements
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += arr[i];
        }
        // Calculate the expected sum
        int expectedSum = (n * (n + 1)) / 2;
        // Return the missing number
        return expectedSum - sum;
    }

    /**
     *
     * [Expected Approach-2] Using XOR Operation – O(n) time and O(1) auxiliary space
     * Another efficient approach is to use the XOR operation. The approach is based on the idea that
     * XOR of a number with itself is 0, and XOR of a number with 0 is the number itself.
     * This means that if we find XOR of first N natural numbers and then take XOR of each array
     * elements with this, then the resultant will be the missing number.
     *
     **/
    private static int findMissingNumberUsingXOR(int arr[]){
        int xor1 = 0, xor2 = 0;
        int n= arr.length+1;
        // XOR all array elements
        for (int i = 0; i < n - 1; i++) {
            xor2 ^= arr[i];
        }
        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
        // Missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
    }

}
