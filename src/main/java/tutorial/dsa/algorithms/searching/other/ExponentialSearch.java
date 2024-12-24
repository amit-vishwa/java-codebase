package tutorial.dsa.algorithms.searching.other;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Refer: https://www.geeksforgeeks.org/exponential-search/
 *
 * The name of this searching algorithm may be misleading as it works in O(Log n) time.
 * The name comes from the way it searches an element.
 *
 * We have discussed, linear search, binary search for this problem.
 * Exponential search involves two steps:
 * i.Find range where element is present
 * ii.Do Binary Search in above found range.
 *
 * How to find the range where element may be present?
 * The idea is to start with subarray size 1, compare its last element with x, then try size 2, then 4 and so on until
 * last element of a subarray is not greater.
 * Once we find an index i (after repeated doubling of i), we know that the element must be present between i/2 and
 * i (Why i/2? because we could not find a greater value in previous iteration)
 *
 * Time Complexity : O(Log n)
 * Auxiliary Space : O(Log n) for recursion and O(1) for iteration
 *
 * Applications of Exponential Search:
 * Exponential Binary Search is particularly useful for unbounded searches, where size of array is infinite.
 * Please refer Unbounded Binary Search for an example.
 * It works better than Binary Search for bounded arrays, and also when the element to be searched is closer to the
 * first element.
 *
 * */
public class ExponentialSearch {

    // Exponential search function
    public static int exponential_search(ArrayList<Integer> arr, int x) {
        int n = arr.size();

        if (n == 0)
            return -1;

        // Find range for binary search by repeatedly doubling i
        int i = 1;
        while (i < n && arr.get(i) < x)
            i *= 2;

        // Perform binary search on the range [i/2, min(i, n-1)]
        int left = i / 2;
        int right = Math.min(i, n - 1);

        while (left <= right) {
            int mid = (left + right) / 2; // finding mid

            if (arr.get(mid) == x)
                return mid;
            else if (arr.get(mid) < x)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // Driver Code
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 3, 4, 10, 40));
        int x = 10;
        System.out.println("Array: " + arr + ", Key: " + x);
        int result = exponential_search(arr, x);
        if (result == -1) {
            System.out.println("Key not found in the array");
        }
        else {
            System.out.println("Key is present at index " + result);
        }
    }

}
