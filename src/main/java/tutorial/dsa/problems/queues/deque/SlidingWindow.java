package tutorial.dsa.problems.queues.deque;

import java.util.*;

/**
 * Refer: https://www.youtube.com/watch?v=MCvGwtkqJS0&t=503s
 * */
public class SlidingWindow {
    public static void main(String[] args){
//        int arr[] = {4,1,3,5,1,2,3,2,1,1,5};
//        int k = 3;
        int arr[] = {33, 38, 46, 24, 26, 6, 42, 28};
        int k = 2;
        System.out.println("Array: " + Arrays.toString(arr) + ", Window size: " + k);
//        System.out.println("Sliding window results using iteration approach:");
//        iterationApproach(arr, k);
//        System.out.println("Sliding window results using priority queue approach:");
//        priorityQueueApproach(arr, k);
        System.out.println("Sliding window results using monotonic deque approach:");
        monotonicDequeApproach(arr, k);
    }

    /**
     * 1.Using iteration
     * Time complexity: O(n*k), n is number of elements in array and k is window size
     * Space Complexity: O(1)
     * */
    static void iterationApproach(int[] arr, int k){
        naiveMaximumApproach(arr, k);
        naiveMinimumApproach(arr, k);
    }
    static void naiveMaximumApproach(int[] arr, int k){
        int n = arr.length;
        int res[] = new int[n-k+1];
        for(int i = 0; i <= n-k; i++){
            int max = arr[i];
            for(int j = i+1; j < i+k; j++){
                if(arr[j]>max){
                    max = arr[j];
                }
            }
            res[i] = max;
        }
        System.out.println("Max: " + Arrays.toString(res));
    }
    static void naiveMinimumApproach(int[] arr, int k){
        int n = arr.length;
        int res[] = new int[n-k+1];
        for(int i = 0; i <= n-k; i++){
            int min = arr[i];
            for(int j = i+1; j < i+k; j++){
                if(arr[j]<min){
                    min = arr[j];
                }
            }
            res[i] = min;
        }
        System.out.println("Min: " + Arrays.toString(res));
    }

    /**
     * 2.Using priority queue
     * Time complexity: O(n * log(k)), n is number of elements in array and k is window size
     * Space Complexity: O(k)
     * */
    static void priorityQueueApproach(int[] arr, int k){
        priorityQueueMaximumApproach(arr, k);
        priorityQueueMinimumApproach(arr, k);
    }
    static void priorityQueueMaximumApproach(int[] arr, int k){
        int n = arr.length;
        // Creating max heap, to always get max element
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        for(; i < k; i++){
            queue.add(arr[i]);
        }
        // Adding max element among first k elements
        res.add(queue.peek());
        // Removing first element of the array
        queue.remove(arr[0]);
        // Iterating next elements
        for(; i < n; i++){
            // Adding new element in the window
            queue.add(arr[i]);
            // Finding and adding max element in current sliding window
            res.add(queue.peek());
            // Removing first element from front end of the queue
            queue.remove(arr[i-k+1]);
        }
        System.out.println("Max: " + res);
    }
    static void priorityQueueMinimumApproach(int[] arr, int k){
        int n = arr.length;
        // Creating max heap, to always get max element
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        for(; i < k; i++){
            queue.add(arr[i]);
        }
        // Adding max element among first k elements
        res.add(queue.peek());
        // Removing first element of the array
        queue.remove(arr[0]);
        // Iterating next elements
        for(; i < n; i++){
            // Adding new element in the window
            queue.add(arr[i]);
            // Finding and adding max element in current sliding window
            res.add(queue.peek());
            // Removing first element from front end of the queue
            queue.remove(arr[i-k+1]);
        }
        System.out.println("Min: " + res);
    }

    /**
     * 3.Using Deque
     * Time complexity: O(n), n is number of elements in array
     * Space Complexity: O(k)
     * */
    static void monotonicDequeApproach(int[] arr, int k){
        monotonicDequeMaximumApproach(arr, k);
//        monotonicDequeMinimumApproach(arr, k);
    }
    private static void monotonicDequeMaximumApproach(int[] arr, int k) {
        int n =  arr.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int i;
        // Process first window elements of array
        for(i = 0; i < k; i++){
            // Remove previous elements that are less than current one
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                // Remove from rear
                deque.removeLast();
            }
            // Add new element at rear of the queue
            deque.addLast(i);
        }
        System.out.print("Max: [");
        // Process rest of element, i.e. arr[k] to arr[n-1]
        for(; i < n; i++){
            // Print first element of window i.e. largest element
            System.out.print(arr[deque.peek()] + ", ");
            // Remove elements which are out of this window
            while (!deque.isEmpty() && deque.peek() <= i-k){
                // Remove first element
                deque.removeFirst();
            }
            // Remove previous elements that are less than current one
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                // Remove from rear
                deque.removeLast();
            }
            // Add new element at rear of the queue
            deque.addLast(i);
        }
        // Print maximum element of last window
        System.out.println(arr[deque.peek()] + "]");
    }
    private static void monotonicDequeMinimumApproach(int[] arr, int k) {
        int n =  arr.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int i;
        // Process first window elements of array
        for(i = 0; i < k; i++){
            // Remove previous elements that are less than current one
            while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]){
                // Remove from rear
                deque.removeLast();
            }
            // Add new element at rear of the queue
            deque.addLast(i);
        }
        System.out.print("Min: [");
        // Process rest of element, i.e. arr[k] to arr[n-1]
        for(; i < n; i++){
            // Print first element of window i.e. largest element
            System.out.print(arr[deque.peek()] + ", ");
            // Remove elements which are out of this window
            while (!deque.isEmpty() && deque.peek() <= i-k){
                // Remove first element
                deque.removeFirst();
            }
            // Remove previous elements that are less than current one
            while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]){
                // Remove from rear
                deque.removeLast();
            }
            // Add new element at rear of the queue
            deque.addLast(i);
        }
        // Print maximum element of last window
        System.out.println(arr[deque.peek()] + "]");
    }
}

