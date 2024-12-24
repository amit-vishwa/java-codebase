package tutorial.dsa.algorithms.searching.common;

import java.util.Arrays;

/**
 *
 * Refer: https://www.geeksforgeeks.org/ternary-search/
 *
 * Ternary search is a search algorithm that is used to find the position of a target value within a sorted array.
 * It operates on the principle of dividing the array into three parts instead of two, as in binary search.
 * The basic idea is to narrow down the search space by comparing the target value with elements at two points that
 * divide the array into three equal parts.
 *
 * mid1 = l + (r-l)/3
 * mid2 = r – (r-l)/3
 *
 * When to use Ternary Search:
 * When you have a large ordered array or list and need to find the position of a specific value.
 * When you need to find the maximum or minimum value of a function.
 * When you need to find bitonic point in a bitonic sequence.
 * When you have to evaluate a quadratic expression
 *
 * Working of Ternary Search:
 * The concept involves dividing the array into three equal segments and determining in which segment the key element
 * is located. It works similarly to a binary search, with the distinction of reducing time complexity by dividing
 * the array into three parts instead of two.
 *
 * Below are the step-by-step explanation of working of Ternary Search:
 *
 * i.Initialization:
 * - Set two pointers, left and right, initially pointing to the first and last elements of our search space.
 * ii.Divide the search space:
 * - Calculate two midpoints, mid1 and mid2, dividing the current search space into three roughly equal parts:
 * mid1 = left + (right – left) / 3
 * mid2 = right – (right – left) / 3
 * - The array is now effectively divided into [left, mid1], (mid1, mid2), and [mid2, right].
 * iii.Comparison with Target:.
 * - If the target is equal to the element at mid1 or mid2, the search is successful, and the index is returned
 * - If the target is less than the element at mid1, update the right pointer to mid1 – 1.
 * - If the target is greater than the element at mid2, update the left pointer to mid2 + 1.
 * - If the target is between the elements at mid1 and mid2, update the left pointer to mid1 + 1 and the right pointer to mid2 – 1.
 * iv.Repeat or Conclude:
 * - Repeat the process with the reduced search space until the target is found or the search space becomes empty.
 * - If the search space is empty and the target is not found, return a value indicating that the target is not present in the array.
 *
 * Time Complexity: O(2 * log3n)
 *
 * */
public class TernarySearch {

    public static void main(String... args){
        int[] arr = {10, 50, 30, 70, 80, 20, 90, 40};
        int key = 30;
        System.out.println("Array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Key: " + key + ", fount at index " + ternarySearchUsingIteration(arr,key));
        key = 70;
        System.out.println("Key: " + key + ", fount at index " + ternarySearchUsingRecursion(0,arr.length,arr,key));
    }

//    Auxiliary Space: O(1)
    static int ternarySearchUsingIteration(int[] arr, int key){
        int left = 0;
        int right = arr.length;
        while(left <= right){
            // Find the mid1  mid2
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if(left >= arr.length){
                left--;
                continue;
            }
            if(right >= arr.length){
                right--;
                continue;
            }
            if(arr[mid1] == key){
                return mid1;
            }
            if(arr[mid2] == key){
                return mid2;
            }
            if(arr[mid1] > key){
                // The key lies in between left and mid1
                right = mid1 - 1;
            }else if(arr[mid2] < key){
                // The key lies in between mid2 and right
                left = mid2 + 1;
            }else{
                // The key lies in between mid1 and mid2
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }

    // Auxiliary Space: O(log3(n))
    static int ternarySearchUsingRecursion(int left, int right, int arr[], int key){
        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right - left) / 3;
        if(left >= arr.length){
            return ternarySearchUsingRecursion(--left,right,arr,key);
        }
        if(right >= arr.length){
            return ternarySearchUsingRecursion(left,--right,arr,key);
        }
        if(arr[mid1] == key){
            return mid1;
        }
        if(arr[mid2] == key){
            return mid2;
        }
        if(arr[mid1] > key){
            // The key lies in between left and mid1
            right = mid1 - 1;
        }else if(arr[mid2] < key){
            // The key lies in between mid2 and right
            left = mid2 + 1;
        }else{
            // The key lies in between mid1 and mid2
            left = mid1 + 1;
            right = mid2 - 1;
        }
        return left <= right ? ternarySearchUsingRecursion(left,right,arr,key) : -1;
    }

}
