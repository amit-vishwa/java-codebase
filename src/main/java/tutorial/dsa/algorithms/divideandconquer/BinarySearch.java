package tutorial.dsa.algorithms.divideandconquer;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/binary-search/
 * Refer: https://www.geeksforgeeks.org/two-pointers-technique/
 *
 * Binary Search Algorithm is a searching algorithm used in a sorted array by repeatedly dividing the search interval
 * in half. The idea of binary search is to use the information that the array is sorted and reduce the time
 * complexity to O(log N).
 *
 * Below is the step-by-step algorithm for Binary Search:
 *
 * Divide the search space into two halves by finding the middle index “mid”.
 * Compare the middle element of the search space with the key.
 * If the key is found at middle element, the process is terminated.
 * If the key is not found at middle element, choose which half will be used as the next search space.
 * If the key is smaller than the middle element, then the left side is used for next search.
 * If the key is larger than the middle element, then the right side is used for next search.
 * This process is continued until the key is found or the total search space is exhausted.
 * */
public class BinarySearch {

    public static void main(String... args){
        int[] arr = {10, 50, 30, 70, 80, 20, 90, 40};
        int key = 10;
        System.out.println("Array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Key: " + key + ", fount at index " + binarySearchUsingIteration(arr,key));
        key = 90;
        System.out.println("Key: " + key + ", fount at index " + binarySearchUsingRecursion(0,arr.length,arr,key));
    }

//    Auxiliary Space: O(1)
    static int binarySearchUsingIteration(int[] arr, int key){
        int left = 0;
        int right = arr.length;
        while(left <= right){
//            int mid = (left + right)/2;
            int mid = left + (right - left) / 2;
            if(mid < arr.length && arr[mid] == key){
                return mid;
            }
            if(mid < arr.length && arr[mid] > key){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    // Auxiliary Space: O(log(n))
    static int binarySearchUsingRecursion(int left, int right, int arr[], int key){
//        int mid = (left + right) / 2;
        int mid = left + (right - left) / 2;
        if(mid < arr.length && arr[mid] == key){
            return mid;
        }
        if(mid < arr.length && arr[mid] > key){
            right = mid - 1;
        }else{
            left = mid + 1;
        }
        return left <= right ? binarySearchUsingRecursion(left,right,arr,key) : -1;
    }

}
