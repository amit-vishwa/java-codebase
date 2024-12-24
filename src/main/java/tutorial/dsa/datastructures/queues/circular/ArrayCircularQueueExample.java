package tutorial.dsa.datastructures.queues.circular;

/**
 *
 * Refer: https://www.geeksforgeeks.org/introduction-to-circular-queue/
 *
 * A Circular Queue is another way of implementing a normal queue where the last element of the queue is
 * connected to the first element of the queue forming a circle.
 *
 * The operations are performed based on the FIFO (First In First Out) principle. It is also called ‘Ring Buffer’.
 * In a normal Queue, we can insert elements until the queue becomes full. However once the queue becomes full,
 * we can not insert the next element even if there is a space in front of the queue.
 *
 * Time Complexity:
 * enqueue(x) - O(1)
 * dequeue() - O(1)
 * getFront() - O(1)
 * getRear() - O(1)
 *
 * Auxiliary Space: O(size), where size is the number of elements in the circular queue.
 *
 * */
public class ArrayCircularQueueExample {

    public static void main(String... args){
//        tcOne();
        tcTwo();
    }

    static void tcOne(){
        ArrayCircularQueue q = new ArrayCircularQueue(4);
        q.enqueue(10);
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(20);
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(30);
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(40);
        System.out.println(q.getFront() + " " + q.getRear());
        q.dequeue();
        System.out.println(q.getFront() + " " + q.getRear());
        q.dequeue();
        System.out.println(q.getFront() + " " + q.getRear());
        q.dequeue();
        System.out.println(q.getFront() + " " + q.getRear());
        q.dequeue();
        System.out.println(q.getFront() + " " + q.getRear());
        q.dequeue();
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(50);
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(60);
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(70);
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(80);
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(90);
        System.out.println(q.getFront() + " " + q.getRear());
    }

    static void tcTwo(){
        ArrayCircularQueue q = new ArrayCircularQueue(4);
        q.display();
        System.out.println("Is queue empty: " + q.isEmpty()+ ", Is queue full: " + q.isFull());
        q.enqueue(10);
        q.display();
        System.out.println("Front: " + q.getFront() + ", Rear: " + q.getRear());
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println("Is queue empty: " + q.isEmpty()+ ", Is queue full: " + q.isFull());
        System.out.println("Front: " + q.getFront() + ", Rear: " + q.getRear());
        q.display();
        q.enqueue(50);
        q.enqueue(60);
        System.out.println("Is queue empty: " + q.isEmpty()+ ", Is queue full: " + q.isFull());
        System.out.println("Front: " + q.getFront() + ", Rear: " + q.getRear());
        q.display();
        q.dequeue();
        System.out.println("Is queue empty: " + q.isEmpty()+ ", Is queue full: " + q.isFull());
        System.out.println("Front: " + q.getFront() + ", Rear: " + q.getRear());
        q.display();
        q.dequeue();
        q.dequeue();
        q.display();
        q.dequeue();
        System.out.println("Is queue empty: " + q.isEmpty()+ ", Is queue full: " + q.isFull());
        System.out.println("Front: " + q.getFront() + ", Rear: " + q.getRear());
        q.display();
        q.dequeue();
        q.enqueue(70);
        q.enqueue(80);
        q.enqueue(90);
        System.out.println("Is queue empty: " + q.isEmpty()+ ", Is queue full: " + q.isFull());
        System.out.println("Front: " + q.getFront() + ", Rear: " + q.getRear());
        q.display();
    }

}


class ArrayCircularQueue{

    private int[] queue;
    private int capacity;
    private int size;
    private int front;

    public ArrayCircularQueue(int capacity){
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
        this.front = 0;
    }

    public int size(){
        return size;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getFront(){
        return isEmpty() ? -1 : queue[front];
    }

    public int getRear(){
        // fetch rear as per circular queue logic
        return isEmpty() ? -1 : queue[(front + size - 1) % capacity];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: [ ");
        // display queue as per circular queue logic
        for(int i = front; i < front+size; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println("]");
    }

    public void enqueue(int x){
        if(isFull()){
            System.out.println("Overflow: Cannot enqueue " + x);
            return;
        }
        // update rear as per circular queue logic
        int rear = (front + size) % capacity;
        queue[rear] = x;
        size++;
        System.out.println("Enqueued: " + x);
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Underflow: Cannot dequeue");
            return -1;
        }
        int popped = queue[front];
        // update front as per circular queue logic
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + popped);
        return popped;
    }

}

// below is simple queue
/*class ArrayCircularQueue{
    private int[] queue;
    private int capacity;
    private int size;

    public ArrayCircularQueue(int capacity){
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = -1;
    }

    public int size(){
        return size;
    }

    public boolean isFull(){
        return size+1 == capacity;
    }

    public boolean isEmpty(){
        return size == -1;
    }

    public int getFront(){
        return isEmpty() ? -1 : queue[0];
    }

    public int getRear(){
        return isEmpty() ? -1 : queue[size];
    }

    public void enqueue(int x){
        if(isFull()){
            System.out.println("Overflow: Cannot enqueue " + x);
            return;
        }
        queue[++size] = x;
        System.out.println("Enqueued: " + x);
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Underflow: Cannot dequeue");
            return -1;
        }
        int popped = queue[0];
        for(int i = 0; i < size; i++){
            queue[i] = queue[i+1];
        }
        queue[size--] = 0;
        System.out.println("Dequeued: " + popped);
        return popped;
    }
}*/