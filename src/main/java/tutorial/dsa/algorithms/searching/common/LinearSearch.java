package tutorial.dsa.algorithms.searching.common;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/linear-search/
 *
 * In Linear Search, we iterate over all the elements of the array and check if it the current element is equal to the
 * target element. If we find any element to be equal to the target element, then return the index of the current
 * element. Otherwise, if no element is equal to the target element, then return -1 as the element is not found.
 * Linear search is also known as sequential search.
 *
 * Time complexity: O(n)
 * Auxillary space: O(1)
 *
 * */
public class LinearSearch {
    public static void main(String... args){
        int[] arr = {10, 50, 30, 70, 80, 20, 90, 40};
        int key = 30;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Key: " + key + ", fount at index " + linearSearch(arr,key));
        key = 130;
        System.out.println("Key: " + key + ", fount at index " + linearSearch(arr,key));
    }

    static int linearSearch(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
