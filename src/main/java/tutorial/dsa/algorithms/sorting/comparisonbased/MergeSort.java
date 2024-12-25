package tutorial.dsa.algorithms.sorting.comparisonbased;

import java.util.Arrays;

/**
 *
 * Refer: https://www.geeksforgeeks.org/merge-sort/
 *
 * Merge sort is a sorting algorithm that follows the divide-and-conquer approach. It works by recursively dividing
 * the input array into smaller subarrays and sorting those subarrays then merging them back together to obtain the
 * sorted array.
 *
 * In simple terms, we can say that the process of merge sort is to divide the array into two halves, sort each half,
 * and then merge the sorted halves back together. This process is repeated until the entire array is sorted.
 *
 * How does Merge Sort work?
 * Merge sort is a popular sorting algorithm known for its efficiency and stability. It follows the divide-and-conquer
 * approach to sort a given array of elements.
 *
 * Here’s a step-by-step explanation of how merge sort works:
 * Divide: Divide the list or array recursively into two halves until it can no more be divided.
 * Conquer: Each subarray is sorted individually using the merge sort algorithm.
 * Merge: The sorted subarrays are merged back together in sorted order. The process continues until all elements
 * from both subarrays have been merged.
 *
 * Time Complexity:
 * Best Case: O(n log n), When the array is already sorted or nearly sorted.
 * Average Case: O(n log n), When the array is randomly ordered.
 * Worst Case: O(n log n), When the array is sorted in reverse order.
 *
 * Auxiliary Space: O(n), Additional space is required for the temporary array used during merging.
 *
 * Merge Function: The merge function merges two subarrays of arr[]. It uses System.arraycopy for efficient copying of elements to temporary arrays.
 * MergeSort Function: The mergeSort function recursively divides the array into two halves, sorts them, and then merges them.
 * Main Method: The main method demonstrates the usage of the mergeSort function.
 * */
public class MergeSort {

    // Merges two subarrays of arr[], First subarray is arr[l..m] and Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
//        for (int i = 0; i < n1; ++i)
//            L[i] = arr[l + i];
//        for (int j = 0; j < n2; ++j)
//            R[j] = arr[m + 1 + j];
        // Copy data to temp arrays
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // Main function that sorts arr[l..r] using merge()
    static void mergesort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            // Sort first and second halves
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array: " + Arrays.toString(arr));
        mergesort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}