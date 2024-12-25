package tutorial.dsa.algorithms.sorting.noncomparisonbased;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/counting-sort/
 *
 * Counting Sort is a non-comparison-based sorting algorithm. It is particularly efficient when the range of input
 * values is small compared to the number of elements to be sorted. The basic idea behind Counting Sort is to count
 * the frequency of each distinct element in the input array and use that information to place the elements in
 * their correct sorted positions.
 *
 * Counting Sort Algorithm:
 * - Declare an auxiliary array countArray[] of size max(inputArray[])+1 and initialize it with 0.
 * - Traverse array inputArray[] and map each element of inputArray[] as an index of countArray[] array, i.e., execute
 * countArray[inputArray[i]]++ for 0 <= i < N.
 * - Calculate the prefix sum at every index of array inputArray[].
 * - Create an array outputArray[] of size N.
 * - Traverse array inputArray[] from end and update outputArray[ countArray[ inputArray[i] ] – 1] = inputArray[i].
 * Also, update countArray[ inputArray[i] ] = countArray[ inputArray[i] ]- – .
 *
 * Time Complexity: O(N+M), where N and M are the size of inputArray[] and countArray[] respectively.
 * Worst-case: O(N+M).
 * Average-case: O(N+M).
 * Best-case: O(N+M).
 *
 * Auxiliary Space: O(N+M), where N and M are the space taken by outputArray[] and countArray[] respectively.
 * */
public class CountingSort {

    public static void main(String[] args) {
        int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
        System.out.println("Array: " + Arrays.toString(inputArray));
        int[] outputArray = countSort(inputArray);
        System.out.println("Sorted Array: " + Arrays.toString(outputArray));
    }

    private static int[] countSort(int[] inputArray) {
        int n = inputArray.length;
        int max = inputArray[0];
        for(int num : inputArray){
            if(max < num){
                max = num;
            }
        }
        // Declare an auxiliary array countArray[] of size max(inputArray[])+1 and initialize it with 0.
        int countArray[] = new int[max + 1];
        // Traverse array inputArray[] and map each element of inputArray[] as an index of countArray[] array,
        // i.e., execute countArray[inputArray[i]]++ for 0 <= i < N.
        for(int i = 0; i < n; i++){
            countArray[inputArray[i]]++;
        }
        // Calculate the prefix sum at every index of array inputArray[].
        for(int i = 1; i < countArray.length; i++){
            countArray[i] += countArray[i-1];
        }
        // Create an array outputArray[] of size N.
        int outputArray[] = new int[n];
        // Traverse array inputArray[] from end and update outputArray[ countArray[ inputArray[i] ] – 1] = inputArray[i].
        for(int i = n-1; i >= 0; i--){
            int countArrayValue = countArray[inputArray[i]];
            outputArray[countArrayValue-1] = inputArray[i];
            // Also, update countArray[ inputArray[i] ] = countArray[ inputArray[i] ]- – .
            countArray[inputArray[i]]--;
        }
        return outputArray;
    }

}
