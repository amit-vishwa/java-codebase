package tutorial.dsa.datastructures.queues.deque.monotonic;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * Refer: https://www.youtube.com/watch?v=MCvGwtkqJS0&t=503s
 *
 * A monotonic deque is a double-ended queue (deque) where the elements are arranged in either non-increasing
 * or non-decreasing order. This structure is particularly useful when you need to maintain an ordered set of
 * elements while supporting efficient insertions and deletions from both ends. A common use case is solving
 * sliding window problems, such as finding the maximum or minimum in a sliding window of fixed size.
 *
 * Key Points of the Code:
 * i.Deque Structure: We use a Deque<Integer> to store the indices of elements in the array. The deque helps
 * maintain the ordering of elements in either non-increasing (for maximum) or non-decreasing (for minimum) order.
 * ii.addElementToDequeMax: This method ensures that the deque is ordered in such a way that it maintains a
 * non-increasing order of elements. The current element is added in a manner that removes all elements smaller
 * than it from the deque before adding it, ensuring that the largest element is always at the front.
 * iii.addElementToDequeMin: Similar to the above method but ensures a non-decreasing order of elements for finding
 * the sliding window minimum.
 * iv.removeOutOfWindow: This method removes elements that are out of the current sliding window.
 * v.slidingWindowMaximum: A method that uses the monotonic deque to find the maximum in each sliding window of size k.
 * vi.slidingWindowMinimum: Similar to the sliding window maximum but finds the minimum in each sliding window of size k.
 *
 * Example Output:
 * For the input array nums = {1, 3, -1, -3, 5, 3, 6, 7} and window size k = 3:
 *
 * Sliding Window Maximum: [3, 3, 5, 5, 5, 6, 7]
 * Sliding Window Minimum: [-1, -3, -3, -3, 3, 3]
 * This approach runs in O(n) time complexity where n is the length of the array because each element is added
 * and removed from the deque at most once.
 *
 * */
public class MonotonicDequeExample {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Array: " + Arrays.toString(nums));
        MonotonicDeque monotonicDeque = new MonotonicDeque();
        // Test sliding window maximum
        int[] maxResult = monotonicDeque.slidingWindowMaximum(nums, k);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(maxResult));
        // Test sliding window minimum
        int[] minResult = monotonicDeque.slidingWindowMinimum(nums, k);
        System.out.println("Sliding Window Minimum: " + Arrays.toString(minResult));
    }
}

class MonotonicDeque{

    // Deque to store the indices of elements in the array
    private Deque<Integer> deque;

    // Constructor to initialize the deque
    public MonotonicDeque(){
        deque = new LinkedList<>();
    }

    // Method to maintain the deque in a non-increasing order (for finding max in sliding window)
    public void addElementToDequeMax(int[] nums, int index){
        // Remove indices that are less than the current element
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[index]){
            deque.removeLast();
        }
        // Add the current index to the deque
        deque.addLast(index);
    }

    // Method to maintain the deque in a non-decreasing order (for finding min in sliding window)
    public void addElementToDequeMin(int[] nums, int index){
        // Remove indices that are greater than the current element
        while (!deque.isEmpty() && nums[deque.peekLast()] >= nums[index]){
            deque.removeLast();
        }
        // Add the current index to the deque
        deque.addLast(index);
    }

    // Method to remove the element which is out of the window from the deque
    public void removeOutOfWindow(int index){
        if(!deque.isEmpty() && deque.peekFirst() == index){
            deque.removeFirst();
        }
    }

    // Get the index of the maximum element in the current window, as it is the first element only
    public int getMaxIndex(){
        return deque.peekFirst();
    }

    // Get the index of the minimum element in the current window, as it is the first element only
    public int getMinIndex(){
        return deque.peekFirst();
    }

    // Example usage for sliding window maximum
    public int[] slidingWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        if(n == 0){
            return new int[0];
        }
        int[] result = new int[n - k + 1];
        for(int i = 0; i < n; i++){
            // Remove indices that are out of the window
            removeOutOfWindow(i - k);
            // Add the current element to the deque for max (non-increasing order)
            addElementToDequeMax(nums, i);
            // Start adding results to the output array once the window is valid
            if(i >= k - 1){
                result[i - k + 1] = nums[getMaxIndex()];
            }
        }
        return result;
    }

    // Example usage for sliding window maximum
    public int[] slidingWindowMinimum(int[] nums, int k) {
        int n = nums.length;
        if(n == 0){
            return new int[0];
        }
        int[] result = new int[n - k + 1];
        for(int i = 0; i < n; i++){
            // Remove indices that are out of the window
            removeOutOfWindow(i - k);
            // Add the current element to the deque for min (non-decreasing order)
            addElementToDequeMin(nums, i);
            // Start adding results to the output array once the window is valid
            if(i >= k - 1){
                result[i - k + 1] = nums[getMinIndex()];
            }
        }
        return result;
    }

}
