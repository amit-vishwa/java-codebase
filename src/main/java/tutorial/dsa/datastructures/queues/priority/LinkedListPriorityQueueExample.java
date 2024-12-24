package tutorial.dsa.datastructures.queues.priority;

/**
 *
 * Refer: https://www.geeksforgeeks.org/priority-queue-set-1-introduction/
 *
 * 2) Implement Priority Queue Using Linked List:
 * In a LinkedList implementation, the entries are sorted in descending order based on their priority.
 * The highest priority element is always added to the front of the priority queue, which is formed using
 * linked lists. The functions like push(), pop(), and peek() are used to implement a priority queue using a
 * linked list and are explained as follows:
 *
 * push(): This function is used to insert new data into the queue.
 * pop(): This function removes the element with the highest priority from the queue.
 * peek() / top(): This function is used to get the highest priority element in the queue without removing
 * it from the queue.
 *
 * Time complexities:
 * push() - O(n)
 * pop() - O(1)
 * peek() - O(1)
 *
 * */
public class LinkedListPriorityQueueExample {
    public static void main(String... args){
        tcOne();
    }
    static void tcOne(){
//        LinkedListPriorityQueue queue = new LinkedListPriorityQueue(new PriorityQueue(4,1));
        LinkedListPriorityQueue queue = new LinkedListPriorityQueue();

        System.out.println("Size: " + queue.size() + ", IsEmpty: " + queue.isEmpty());

        // Function Call to insert elements as per the priority
        queue.push(5, 2);
        queue.push(6, 3);
        queue.push(4, 1);
        queue.push(9, 1);
        queue.push(7, 0);

        System.out.println("Size: " + queue.size() + ", IsEmpty: " + queue.isEmpty());
        // Stores the top element
        // at the moment
        int index = queue.peek();

        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueNode().data.getValue() +" with priority "
                +queue.getPriorityQueueNode().data.getPriority());

        // Dequeue the top element
        queue.pop();

        // Check the top element
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueNode().data.getValue() +" with priority "
                +queue.getPriorityQueueNode().data.getPriority());

        // Dequeue the top element
        queue.pop();

        // Check the top element
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueNode().data.getValue() +" with priority "
                +queue.getPriorityQueueNode().data.getPriority());

        // Dequeue the top element
        queue.pop();

        // Check the top element
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueNode().data.getValue() +" with priority "
                +queue.getPriorityQueueNode().data.getPriority());

        queue.pop();
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueNode().data.getValue() +" with priority "
                +queue.getPriorityQueueNode().data.getPriority());
        System.out.println("Size: " + queue.size() + ", IsEmpty: " + queue.isEmpty());

        queue.pop();
        index = queue.peek();
        System.out.println("Priority queue value at index "+index +" is "
                +queue.getPriorityQueueNode().data.getValue() +" with priority "
                +queue.getPriorityQueueNode().data.getPriority());
        System.out.println("Size: " + queue.size() + ", IsEmpty: " + queue.isEmpty());

        // Output is 6, 5, 9, 4, 7 based on max value with max priority for Descending Priority Queue
        // Output is 7, 4, 9, 5, 6 based on min value with min priority for Ascending Priority Queue
    }
}

class LinkedListPriorityQueue{

    // Store the element of a priority queue
    private PriorityQueueNode priorityQueueNode;
    // Pointer to the last index
    private int size;

    // Initialize the queue array
    public LinkedListPriorityQueue(){
        // Initialize node for Descending Priority Queue
        priorityQueueNode = new PriorityQueueNode(new PriorityQueue(Integer.MIN_VALUE, Integer.MIN_VALUE));
        // Initialize node for Ascending Priority Queue
//        priorityQueueNode = new PriorityQueueNode(new PriorityQueue(Integer.MAX_VALUE, Integer.MAX_VALUE));
        size = 0;
    }
    // Initialize with value
    public LinkedListPriorityQueue(PriorityQueue priorityQueue){
        priorityQueueNode = new PriorityQueueNode(priorityQueue);
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // Return the value at head
    public int peek(){
        return priorityQueueNode.data.getValue();
    }

    // Removes the element with the highest priority from the list as per ascending/descending order
    public int pop(){
        PriorityQueueNode temp = priorityQueueNode;
        int popped = temp.data.getValue();
        priorityQueueNode = priorityQueueNode.next;
        size--;
        return popped;
    }

    // Function to push according to max priority
    public void push(int value, int priority){
        PriorityQueueNode start = priorityQueueNode;
        // Create a new Node
        PriorityQueueNode temp = new PriorityQueueNode(new PriorityQueue(value,priority));
        // Special Case: The head of list has lesser priority than new node.
        // So insert new node before head node and change head node.
        if(priorityQueueNode.data.getPriority() < priority){
            // Insert New Node before head
            temp.next = priorityQueueNode;
            priorityQueueNode = temp;
        } else {
            // Traverse the list and find a position to insert new node
            while (start.next != null && start.next.data.getPriority() > priority){
                start = start.next;
            }
            // Enter at the ends of the list or at required position
            temp.next = start.next;
            start.next = temp;
        }
        // Increase size
        size++;
        System.out.println("Enqueued priority queue with value " + value + " and priority " + priority);
    }

    // Function to push according to min priority
    /*public void push(int value, int priority){
        PriorityQueueNode start = priorityQueueNode;
        // Create a new Node
        PriorityQueueNode temp = new PriorityQueueNode(new PriorityQueue(value,priority));
        // Special Case: The head of list has more priority than new node.
        // So insert new node before head node and change head node.
        if(priorityQueueNode.data.getPriority() > priority){
            // Insert New Node before head
            temp.next = priorityQueueNode;
            priorityQueueNode = temp;
        } else {
            // Traverse the list and find a position to insert new node
            while (start.next != null && start.next.data.getPriority() < priority){
                start = start.next;
            }
            // Enter at the ends of the list or at required position
            temp.next = start.next;
            start.next = temp;
        }
        // Increase size
        size++;
        System.out.println("Enqueued priority queue with value " + value + " and priority " + priority);
    }*/

    public PriorityQueueNode getPriorityQueueNode(){
        return priorityQueueNode;
    }

}

class PriorityQueueNode{
    PriorityQueue data;
    PriorityQueueNode next;
    public PriorityQueueNode(PriorityQueue data){
        this.data = data;
        this.next = null;
    }
}