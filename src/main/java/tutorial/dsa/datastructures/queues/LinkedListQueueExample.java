package tutorial.dsa.datastructures.queues;

/**
 * Refer: https://www.geeksforgeeks.org/queue-linked-list-implementation/
 * */
public class LinkedListQueueExample {
    public static void main(String... args){
        LinkedListQueue q = new LinkedListQueue();
        System.out.println("Queue is full: " + q.isFull());
        System.out.println("Queue is empty: " + q.isEmpty());

        q.dequeue();
        // Display the empty queue
        q.display();

        // Insert elements
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        q.enqueue(60);

        q.display();

        // Delete elements
        q.dequeue();
        q.dequeue();
//        q.dequeue();
//        q.dequeue();
//        q.dequeue();
//        q.dequeue();
        System.out.println("After two node deletions:");

        q.display();

        // Get the front and rear element
        System.out.println("Front: " + q.front());
        System.out.println("Rear: " + q.rear());
        System.out.println("Size: " + q.size());
        System.out.println("Queue is full: " + q.isFull());
        System.out.println("Queue is empty: " + q.isEmpty());

    }
}

class LinkedListQueue{
    private Node head;
    private Node tail;
    private boolean isFull;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
        isFull = false;
    }

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public boolean isFull(){
        return isFull;
    }

    public int size(){
        return size;
    }

    public int front(){
        return head != null ? head.data : -1;
    }

    public int rear(){
        return tail != null ? tail.data : -1;
    }

    public void enqueue(int x){
        Node node = new Node(x);
        // if there is any issue with memory allocation
        if(node == null){
            isFull = true;
            System.out.println("Overflow: Cannot enqueue " + x);
            return;
        }
        if(tail == null){
            // queue is empty, point tail and head to node
            head = tail = node;
        }else{
            // point next of tail to node to add it to head
            tail.next = node;
            // store node in tail
            tail = node;
        }
        size++;
        isFull = false;
        System.out.println("Enqueued: " + x);
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Underflow: Cannot dequeue");
            return;
        }
        Node temp = head;
        int popped = temp.data;
        head = temp.next;
        if(head == null){
            tail = null;
        }
        size--;
        System.out.println("Dequeued: " + popped);
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }else{
            Node temp = head;
            System.out.print("Queue: ");
            while (temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
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