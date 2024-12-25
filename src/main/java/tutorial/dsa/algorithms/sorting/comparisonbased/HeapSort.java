package tutorial.dsa.algorithms.sorting.comparisonbased;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/heap-sort/
 *
 * Heap sort is a comparison-based sorting technique based on Binary Heap Data Structure. It can be seen as an
 * optimization over selection sort where we first find the max (or min) element and swap it with the last (or first).
 * We repeat the same process for the remaining elements. In Heap Sort, we use Binary Heap so that we can quickly find
 * and move the max element in O(Log n) instead of O(n) and hence achieve the O(n Log n) time complexity.
 *
 * Heap Sort Algorithm
 * First convert the array into a max heap using heapify, Please note that this happens in-place. The array elements
 * are re-arranged to follow heap properties. Then one by one delete the root node of the Max-heap and replace it
 * with the last node and heapify. Repeat this process while size of heap is greater than 1.
 *
 * i.Rearrange array elements so that they form a Max Heap.
 * ii.Repeat the following steps until the heap contains only one element:
 * - Swap the root element of the heap (which is the largest element in current heap) with the last element of the heap.
 * - Remove the last element of the heap (which is now in the correct position). We mainly reduce heap size and do not
 * remove element from the actual array.
 * - Heapify the remaining elements of the heap.
 * iii.Finally we get sorted array.
 *
 * Time Complexity: O(n log n)
 * Auxiliary Space: O(log n), due to the recursive call stack. However, auxiliary space can be O(1) for iterative
 * implementation.
 * */
public class HeapSort {

    // To heapify a subtree rooted with node i
    // which is an index in arr[].
    static void heapify(int arr[], int n, int i) {

        // Initialize largest as root
        int largest = i;

        // left index = 2*i + 1
        int l = 2 * i + 1;

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than root
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Main function to do heap sort
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Driver's code
    public static void main(String args[]) {
        int arr[] = {9, 4, 3, 8, 10, 2, 5};
        System.out.println("Array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}