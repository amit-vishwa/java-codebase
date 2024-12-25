package tutorial.dsa.algorithms.sorting.comparisonbased;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/insertion-sort-algorithm/
 *
 * Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list
 * into its correct position in a sorted portion of the list. It is like sorting playing cards in your hands.
 * You split the cards into two groups: the sorted cards and the unsorted cards. Then, you pick a card from the
 * unsorted group and put it in the right place in the sorted group.
 *
 * Time Complexity of Insertion Sort
 * Best case: O(n) , If the list is already sorted, where n is the number of elements in the list.
 * Average case: O(n 2 ) , If the list is randomly ordered
 * Worst case: O(n 2 ) , If the list is in reverse order
 * Space Complexity of Insertion Sort
 *
 * Auxiliary Space: O(1), Insertion sort requires O(1) additional space, making it a space-efficient sorting algorithm.
 * */
public class InsertionSort {

    public static void main(String... args){
        int arr[] = { 12, 11, 13, 5, 6 };
        System.out.println("Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

    }

    static void insertionSort(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            int j = i;
            // Compare current element with left array
            while(j > 0 ){
                // If right element is less than left then swap
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                j--;
            }
        }
    }

}
