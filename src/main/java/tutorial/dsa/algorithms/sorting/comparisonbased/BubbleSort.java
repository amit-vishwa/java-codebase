package tutorial.dsa.algorithms.sorting.comparisonbased;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/bubble-sort-algorithm/
 *
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are
 * in the wrong order. This algorithm is not suitable for large data sets as its average and worst-case time complexity
 * are quite high.
 *
 * Time Complexity: O(n2)
 * Auxiliary Space: O(1)
 * */
public class BubbleSort {

    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    public static void main(String args[]){
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        bubbleSort(arr, n);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

