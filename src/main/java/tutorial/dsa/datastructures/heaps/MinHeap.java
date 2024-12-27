package tutorial.dsa.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-min-heap-data-structure/
 *
 * MinHeap is a complete binary tree where the value of each node is less than or equal to the values of its children.
 * This implementation uses an ArrayList to store the elements.
 *
 * MinHeap Class: Implements a min-heap using an ArrayList.
 * insert() Method: Adds a new element and maintains the heap property by calling heapifyUp().
 * extractMin() Method: Removes and returns the minimum element, then calls heapifyDown() to maintain the heap property.
 * getMin() Method: Returns the minimum element without removing it.
 * heapifyUp() Method: Ensures the heap property is maintained after insertion.
 * heapifyDown() Method: Ensures the heap property is maintained after extraction.
 * swap() Method: Swaps two elements in the heap.
 * main() Method: Demonstrates the usage of the MinHeap class.
 */
public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
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
     * Removes and returns the minimum element from the heap.
     * @return the minimum element.
     *
     * Time complexity: O(log n) where n is no of elements in the heap
     * Auxiliary Space: O(n)
     */
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return min;
    }

    /**
     * Returns the minimum element without removing it.
     * @return the minimum element.
     *
     * Time complexity: O(1)
     * Auxiliary Space: O(1)
     */
    public int getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    // The time complexity of heapify in a min-heap is O(n).
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
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
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);

        System.out.println("Min element: " + minHeap.getMin());
        System.out.println("Extracted min element: " + minHeap.extractMin());
        System.out.println("Min element after extraction: " + minHeap.getMin());
        System.out.println("Is 6 present in min heap: " + minHeap.search(6));

    }
}