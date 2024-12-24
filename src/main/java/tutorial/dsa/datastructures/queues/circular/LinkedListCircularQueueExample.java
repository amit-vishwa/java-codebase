package tutorial.dsa.datastructures.queues.circular;

/**
 * Refer: https://www.geeksforgeeks.org/circular-linked-list-implementation-of-circular-queue/
 *
 * Time Complexity: O(1), for enQueue, deQueue, front, rear and O(n) for printQueue.
 * Auxiliary Space: O(n), where n is the maximum number of elements that can be stored in the queue.
 * */
public class LinkedListCircularQueueExample {
    public static void main(String... args){
        tcOne();
    }

    static void tcOne(){
        LinkedListCircularQueue q = new LinkedListCircularQueue();

        q.printQueue();
        System.out.println("Is empty: " + q.isEmpty() + ", Size: " + q.size());

        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(6);
        q.enQueue(20);

        System.out.println("Front: " + q.getFront() + ", Rear: " + q.getRear());
        System.out.println("Is empty: " + q.isEmpty() + ", Size: " + q.size());
        q.printQueue();

        q.deQueue();
        q.deQueue();

        q.printQueue();
        System.out.println("Is empty: " + q.isEmpty() + ", Size: " + q.size());
    }
}

class LinkedListCircularQueue{
    private Node head, tail;
    private int size;

    public LinkedListCircularQueue(){
        head = tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getFront(){
        return isEmpty() ? -1 : head.data;
    }

    public int getRear(){
        return isEmpty() ? -1 : tail.data;
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: [ ");
        Node node = head;
        // Print data only in size range
        for(int i = 0; i < size; i++){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println(" ]");
    }

    public void enQueue(int x){
        Node node = new Node(x);
        if(isEmpty()){
            // If empty then store new node in head
            head = node;
        }else{
            // Else point tail to new node
            tail.next = node;
        }
        // Store new node to tail
        tail = node;
        // Point tail to head
        tail.next = head;
        size++;
        System.out.println("Enqueued: " + x);
    }

    public int deQueue(){
        if(isEmpty()){
            return -1;
        }
        Node node = head;
        int popped = node.data;
        if(head == tail){
            // Set head tail to null after popping data
            head = tail = null;
        }else{
            // Update head to next and point tail to new head
            head = head.next;
            tail.next = head;
        }
        size--;
        System.out.println("Dequeued: " + popped);
        return popped;
    }

}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}