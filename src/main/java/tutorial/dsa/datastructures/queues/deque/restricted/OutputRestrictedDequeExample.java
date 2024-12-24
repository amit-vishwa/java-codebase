package tutorial.dsa.datastructures.queues.deque.restricted;

/**
 * Refer: https://www.geeksforgeeks.org/output-restricted-queue/?ref=next_article
 * An output-restricted queue is a special case of a double-ended queue where data can be removed from one
 * end(front) but can be inserted from both ends (front and rear). This kind of Queue does not follow
 * FIFO(first in first out):
 *
 * Operations on Input Restricted Queue:
 *
 * Mainly the following three basic operations are performed on input restricted queue:
 * insertRear(): Adds an item at the rear of the queue.
 * insertFront(): Adds an item at the front of the queue.
 * deleteFront(): Deletes an item from the front of the queue.
 *
 * In addition to above operations, following operations are also supported
 * getFront(): Gets the front item from the queue.
 * getRear(): Gets the last item from the queue.
 * isEmpty(): Checks whether queue is empty or not.
 * isFull(): Checks whether queue is full or not.
 * */
public class OutputRestrictedDequeExample {
    public static void main(String[] args){
        tcOne();
    }

    static void tcOne(){
        OutputRestrictedDeque dq = new OutputRestrictedDeque(5);
        // Function calls
        System.out.println("Deque size: " + dq.size());
        System.out.println("Is Deque full: " + dq.isFull());
        System.out.println("Is Deque empty: " + dq.isEmpty());
        dq.display();
        dq.insertRear(5);
        dq.insertFront(10);
        dq.insertRear(15);
        dq.insertFront(25);
        dq.insertRear(35);
        dq.insertRear(45);
        System.out.println("Deque size: " + dq.size());
        System.out.println("Is Deque full: " + dq.isFull());
        System.out.println("Is Deque empty: " + dq.isEmpty());
        dq.display();
        System.out.println("Rear element: " + dq.getRear());
        System.out.println("Front element: " + dq.getFront());
        dq.deleteFront();
        System.out.println("Front element: " + dq.getFront());
        dq.display();
        dq.deleteFront();
        dq.display();
        dq.deleteFront();
        dq.deleteFront();
        dq.deleteFront();
        dq.deleteFront();
        System.out.println("Deque size: " + dq.size());
        System.out.println("Is Deque full: " + dq.isFull());
        System.out.println("Is Deque empty: " + dq.isEmpty());
        dq.display();
    }
}

class OutputRestrictedDeque{
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public OutputRestrictedDeque(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
        this.front = this.rear = -1;
    }

    public int size(){
        return size;
    }

    public boolean isFull(){
        return size >= capacity;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public int getFront(){
        return isEmpty() ? -1 : arr[front];
    }

    public int getRear(){
        return isEmpty() ? -1 : arr[rear];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        // Counter used for printing number of elements
        int counter = rear+size;
        System.out.println("Front: " + front + ", Rear: " + rear + ", Size: " + size);
        System.out.print("Queue: [ ");
        do{
            // Print front at initial
            System.out.print(arr[i] + " ");
            // Increase pointer and modulo it by queue capacity
            i = ++i % capacity;
            // Decrease counter after printing an element
            counter--;
        } while(i <= counter); // Print till rear index
        System.out.println("]");
    }

    public void insertRear(int x){
        if(isFull()){
            System.out.println("Overflow: Cannot insert");
            return;
        }
        if(front == -1){
            front = rear = 0;
        }else if(rear == capacity - 1){
            rear = 0;
        }else{
            rear++;
        }
        arr[rear] = x;
        size++;
        System.out.println("Inserted rear: " + x);
    }

    public void insertFront(int x){
        if(isFull()){
            System.out.println("Overflow: Cannot insert");
            return;
        }
        if(front == -1){
            front = rear = 0;
        }else if(front == 0){
            front = capacity - 1;
        }else{
            front--;
        }
        arr[front] = x;
        size++;
        System.out.println("Inserted front: " + x);
    }

    public int deleteFront(){
        if(isEmpty()){
            System.out.println("Underflow: Cannot delete");
            return -1;
        }
        int popped = arr[front];
        if(front == rear){
            front = rear = -1;
        }else if(front == capacity - 1){
            front = 0;
        }else{
            front++;
        }
        size--;
        System.out.println("Deleted front: " + popped);
        return popped;
    }

}