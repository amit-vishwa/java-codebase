package tutorial.dsa.datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Refer: https://www.geeksforgeeks.org/search-insert-and-delete-in-an-unsorted-array/
 * */
public class ArrayOperations {
    public static void main(String... args){
        int arr[] = new int[15];
        arr[0] = 10;
        arr[1] = 50;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 20;
        int n = 5;
        int capacity = arr.length;
        int pos = 2;
        int key = 30;
        System.out.println("Array before:");
        System.out.println(Arrays.toString(arr));
        findElement(arr, n, key);
        insertAtEnd(arr, n, key, capacity);
        insertAtAnyPosition(arr, n, pos, key, capacity);
        deleteElement(arr, n+2, key);
    }

    /**
     * Time Complexity: O(N)
     * Auxiliary Space: O(1)
     * */
    private static void findElement(int arr[], int n, int key){
        int index = -1;
        for (int i = 0; i < n; i++){
            if (arr[i] == key){
                index = i;
            }
        }
        System.out.println(key +" found at index "+index);
    }

    /**
     * Time Complexity: O(1)
     * Auxiliary Space: O(1)
     * */
    private static void insertAtEnd(int arr[], int n, int key, int capacity){
        if (n < capacity){
            arr[n] = key;
        }
        System.out.println("Array after insertion at end:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Time Complexity: O(N)
     * Auxiliary Space: O(1)
     * */
    private static void insertAtAnyPosition(int arr[], int n, int pos, int key, int capacity){
        if(n < capacity){
            for (int i = n; i >= pos; i--){
                arr[i + 1] = arr[i];
            }
            arr[pos] = key;
        }
        System.out.println("Array after insertion at specified position:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Time Complexity: O(N)
     * Auxiliary Space: O(1)
     * */
    private static void deleteElement(int arr[], int n, int key){
        // find index of the key
        int index = -1;
        for (int i = 0; i < n; i++){
            if (arr[i] == key){
                index = i;
                break;
            }
        }
        if(index != -1){
            // if index found, then delete element
            for (int i = index; i < n - 1; i++){
                arr[i] = arr[i + 1];
            }
            arr[n-1] = 0;
        }
        System.out.println("Array after deleting element at specified position:");
        System.out.println(Arrays.toString(arr));
    }

}
