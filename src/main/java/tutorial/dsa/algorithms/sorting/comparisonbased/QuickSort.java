package tutorial.dsa.algorithms.sorting.comparisonbased;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/quick-sort-algorithm/
 *
 * QuickSort is a sorting algorithm based on the Divide and Conquer that picks an element as a pivot and partitions
 * the given array around the picked pivot by placing the pivot in its correct position in the sorted array.
 *
 * How does QuickSort Algorithm work?
 * QuickSort works on the principle of divide and conquer, breaking down the problem into smaller sub-problems.
 *
 * There are mainly three steps in the algorithm:
 * i.Choose a Pivot: Select an element from the array as the pivot. The choice of pivot can vary (e.g., first element,
 * last element, random element, or median).
 * ii.Partition the Array: Rearrange the array around the pivot. After partitioning, all elements smaller than the pivot
 * will be on its left, and all elements greater than the pivot will be on its right. The pivot is then in its correct
 * position, and we obtain the index of the pivot.
 * iii.Recursively Call: Recursively apply the same process to the two partitioned sub-arrays (left and right of the pivot).
 * iv.Base Case: The recursion stops when there is only one element left in the sub-array, as a single element is
 * already sorted.
 *
 * Time Complexity:
 * Best Case: (Ω(n log n)), Occurs when the pivot element divides the array into two equal halves.
 * Average Case (θ(n log n)), On average, the pivot divides the array into two parts, but not necessarily equal.
 * Worst Case: (O(n²)), Occurs when the smallest or largest element is always chosen as the pivot (e.g., sorted arrays).
 *
 * Auxiliary Space: O(n), due to recursive call stack
 * */
public class QuickSort {

    public static void main(String... args){
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high){
        // If low is less than high index then perform quicksort
        if(low < high){
            // Get pivot index from partition
            int pivot = partition(arr, low, high);
            // Perform quicksort for left portion
            quickSort(arr, low, pivot-1);
            // Perform quicksort for right portion
            quickSort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Consider pivot element as last one
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            // If current element is less than pivot, increment i and swap
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        // Increment i and swap with pivot
        swap(arr, i+1, high);
        // Return new pivot index
        return i+1;
    }

    // Swap two elements in array
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
