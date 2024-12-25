package tutorial.dsa.algorithms.sorting.noncomparisonbased;

import java.util.Arrays;

/**
 *
 * Refer: https://www.geeksforgeeks.org/radix-sort/
 *
 * Radix Sort is a linear sorting algorithm that sorts elements by processing them digit by digit. It is an efficient
 * sorting algorithm for integers or strings with fixed-size keys.
 *
 * Rather than comparing elements directly, Radix Sort distributes the elements into buckets based on each digit’s
 * value. By repeatedly sorting the elements by their significant digits, from the least significant to the most
 * significant, Radix Sort achieves the final sorted order.
 *
 * Radix Sort Algorithm
 * The key idea behind Radix Sort is to exploit the concept of place value. It assumes that sorting numbers digit by
 * digit will eventually result in a fully sorted list. Radix Sort can be performed using different variations,
 * such as Least Significant Digit (LSD) Radix Sort or Most Significant Digit (MSD) Radix Sort.
 *
 * Time Complexity:
 * Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping the keys
 * by the individual digits which share the same significant position and value. It has a time complexity of
 * O(d * (n + b)), where d is the number of digits, n is the number of elements, and b is the base of the number
 * system being used.
 * In practical implementations, radix sort is often faster than other comparison-based sorting algorithms,
 * such as quicksort or merge sort, for large datasets, especially when the keys have many digits. However,
 * its time complexity grows linearly with the number of digits, and so it is not as efficient for small datasets.
 *
 * Auxiliary Space:
 * Radix sort also has a space complexity of O(n + b), where n is the number of elements and b is the base of the
 * number system. This space complexity comes from the need to create buckets for each digit value and to copy the
 * elements back to the original array after each digit has been sorted.
 *
 * */
public class RadixSort {

    public static void main(String[] args)
    {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        System.out.println("Array: " + Arrays.toString(arr));
        radixsort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static void radixsort(int[] arr) {
        // Find the maximum number to know number of digits
        int max = getMax(arr);
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10){
            countSort(arr, arr.length, exp);
        }
    }

    // A utility function to get maximum value in array
    static int getMax(int arr[])
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++){
            arr[i] = output[i];
        }
    }

}
