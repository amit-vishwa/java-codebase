package tutorial.dsa.datastructures.queues.priority;

/**
 *
 * Refer: https://www.geeksforgeeks.org/priority-queue-set-1-introduction/
 *
 * 1) Implement Priority Queue Using Array:
 * A simple implementation is to use an array of the following structure.
 *
 * struct item {
 *         int item;
 *         int priority;
 * }
 *
 * Operations:
 * enqueue(): This function is used to insert new data into the queue.
 * dequeue(): This function removes the element with the highest priority from the queue.
 * peek()/top(): This function is used to get the highest priority element in the queue without removing it from the queue.
 *
 * Time complexities:
 * enqueue() - O(1)
 * dequeue() - O(n)
 * peek() - O(n)
 *
 * */
public class ArrayPriorityQueueExample {
    public static void main(String... args){
        tcOne();
    }
    static void tcOne(){
        ArrayPriorityQueue queue = new ArrayPriorityQueue(5);
        // Function Call to insert elements
        // as per the priority
        queue.enqueue(10, 2);
        queue.enqueue(14, 4);
        queue.enqueue(16, 4);
        queue.enqueue(12, 3);

        // Stores the top element
        // at the moment
        int index = queue.peek();

        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueArray()[index].getValue() +" with priority "
                +queue.getPriorityQueueArray()[index].getPriority());

        // Dequeue the top element
        queue.dequeue();

        // Check the top element
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueArray()[index].getValue() +" with priority "
                +queue.getPriorityQueueArray()[index].getPriority());

        // Dequeue the top element
        queue.dequeue();

        // Check the top element
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueArray()[index].getValue() +" with priority "
                +queue.getPriorityQueueArray()[index].getPriority());

        // Dequeue the top element
        queue.dequeue();

        // Check the top element
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueArray()[index].getValue() +" with priority "
                +queue.getPriorityQueueArray()[index].getPriority());

        // Output is 16, 14, 12, 10 based on max value with max priority for Descending Priority Queue
        // Output is 10, 12, 14, 16 based on min value with min priority for Ascending Priority Queue
    }
}

class ArrayPriorityQueue{

    // Store the element of a priority queue
    private PriorityQueue[] priorityQueue;
    // Pointer to the last index
    private int size = -1;

    // Initialize the queue array
    public ArrayPriorityQueue(int size){
        priorityQueue = new PriorityQueue[size];
    }

    // Function to insert a new element into priority queue
    public void enqueue(int value, int priority){
        // Increase size
        size++;
        // Insert the element
        priorityQueue[size] = new PriorityQueue(value, priority);
        System.out.println("Enqueued priority queue with value " + value + " and priority " + priority);
    }

    // Function to check the top element with the highest priority for Descending Priority Queue
    /*public int peek(){
        int highestPriority, index;
        highestPriority = index = -1;
        // Check for the element with the highest priority
        for(int i = 0; i <= size; i++){
            // If priority is same choose the element with the highest value
            if((highestPriority == priorityQueue[i].getPriority() && index > -1 &&
            priorityQueue[index].getValue() < priorityQueue[i].getValue())
            || (highestPriority < priorityQueue[i].getPriority())){
                highestPriority = priorityQueue[i].getPriority();
                index = i;
            }
        }
        // Return position of the element
        return index;
    }*/

    // Function to check the top element with the lowest priority for Ascending Priority Queue
    public int peek(){
        int lowestPriority = Integer.MAX_VALUE;
        int index = -1;
        // Check for the element with the highest priority
        for(int i = 0; i <= size; i++){
            // If priority is same choose the element with the highest value
            if((lowestPriority == priorityQueue[i].getPriority() && index > -1 &&
                    priorityQueue[index].getValue() > priorityQueue[i].getValue())
                    || (lowestPriority > priorityQueue[i].getPriority())){
                lowestPriority = priorityQueue[i].getPriority();
                index = i;
            }
        }
        // Return position of the element
        return index;
    }

    // Function to remove the element with the highest priority
    public void dequeue(){
        // Find the position of the element with the highest priority
        int index = peek();
        // Shift the element one index before from the position of the element with the highest priority is found
        for (int i = index; i < size; i++) {
            priorityQueue[i] = priorityQueue[i + 1];
        }
        // Decrease the size of the priority queue by one
        size--;
    }

    public PriorityQueue[] getPriorityQueueArray(){
        return priorityQueue;
    }

}

