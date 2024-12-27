package tutorial.dsa.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-max-heap-data-structure/
 *
 * MaxHeap is a complete binary tree where the value of each node is greater than or equal to the values of its children.
 * This implementation uses an ArrayList to store the elements.
 * A Max-Heap is defined as a type of Heap Data Structure in which each internal node is greater than or equal to its
 * children. A max-heap is always a complete binary tree and typically represented as an array. Note that unlike a
 * normal binary tree, a complete binary tree can be represented as an array without wasting any memory.
 * The heap data structure is a type of binary tree that is commonly used in computer science for various purposes,
 * including sorting, searching, and organizing data.
 *
 * A Max heap is typically represented as an array.
 * - The root element will be at Arr[0].
 * - For any ith node Arr[i].
 *  -> left child is stored at index 2i+1
 *  -> Right child is stored at index 2i+2
 *  -> Parent is stored at index floor((i-1)/2)
 *
 * The Internal Implementation of the Max-Heap require 3 major steps:
 * - Insertion: To insert a new element into the heap, it is added to the end of the array and then “bubbled up”
 * until it satisfies the heap property.
 * - Deletion: To delete the maximum element (the root of the heap), the last element in the array is swapped with
 * the root, and the new root is “bubbled down” until it satisfies the heap property.
 * - Heapify: A heapify operation can be used to create a max heap from an unsorted array.
 */
public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Inserts a new element into the heap.
     * @param value the value to be inserted.
     *
     * Time Complexity:  O(log(n)) (where n is no of elements in the heap)
     * Auxiliary Space: O(n)
     */
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    /**
     * Removes and returns the maximum element from the heap.
     * @return the maximum element.
     *
     * Time complexity: O(log n) where n is no of elements in the heap
     * Auxiliary Space: O(n)
     */
    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return max;
    }

    /**
     * Returns the maximum element without removing it.
     * @return the maximum element.
     *
     * Time complexity:
     * - In a max heap implemented using an array or a list, the peak element can be accessed in constant time, O(1),
     * as it is always located at the root of the heap.
     * - In a max heap implemented using a binary tree, the peak element can also be accessed in O(1) time, as it is
     * always located at the root of the tree.
     * Auxiliary Space: O(n)
     */
    public int getMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    // The time complexity of heapify in a max heap is O(n).
    private void heapifyDown(int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Time complexity: O(n), where n is the size of the heap.
     * Auxiliary Space: O(1)
     * */
    public boolean search(int value) {
        return heap.contains(value);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);

        System.out.println("Max element: " + maxHeap.getMax());
        System.out.println("Extracted max element: " + maxHeap.extractMax());
        System.out.println("Max element after extraction: " + maxHeap.getMax());
        System.out.println("Is 4 present in max heap: " + maxHeap.search(4));
    }
}