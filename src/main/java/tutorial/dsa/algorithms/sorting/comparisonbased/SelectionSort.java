package tutorial.dsa.algorithms.sorting.comparisonbased;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/selection-sort-algorithm-2/
 *
 * Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly selecting the smallest
 * (or largest) element from the unsorted portion and swapping it with the first unsorted element.
 * This process continues until the entire array is sorted.
 *
 * First we find the smallest element and swap it with the first element. This way we get the smallest element at its correct position.
 * Then we find the smallest among remaining elements (or second smallest) and swap it with the second element.
 * We keep doing this until we get all elements moved to correct position.
 *
 * Time Complexity: O(n2) ,as there are two nested loops:
 * One loop to select an element of Array one by one = O(n)
 * Another loop to compare that element with every other Array element = O(n)
 * Therefore overall complexity = O(n) * O(n) = O(n*n) = O(n2)
 *
 * Auxiliary Space: O(1) as the only extra memory used is for temporary variables.
 * */
public class SelectionSort {

    public static void main(String... args){
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.println("Original array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            // Consider i as index with min value
            int min = i;
            for (int j = i+1; j < arr.length; j++){
                // Compare will rest of element and update min index
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            // If min index is updated then swap
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
