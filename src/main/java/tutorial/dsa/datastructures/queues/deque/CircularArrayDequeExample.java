package tutorial.dsa.datastructures.queues.deque;

/**
 * Refer: https://www.geeksforgeeks.org/implementation-deque-using-circular-array/
 * */
public class CircularArrayDequeExample {
    public static void main(String... args){
        tcOne();
    }

    static void tcOne(){
        CircularArrayDeque dq = new CircularArrayDeque(4);

        dq.insertRear(5);
        dq.insertRear(10);
        dq.insertFront(40);
        dq.insertRear(50);
        dq.insertFront(60);
        dq.printQueue();

        System.out.println("Rear element: " + dq.getRear());

        dq.deleteRear();

        System.out.println("Rear element: " + dq.getRear());

        dq.insertFront(15);

        System.out.println("Front element: " + dq.getFront());

        dq.deleteFront();

        dq.printQueue();
        System.out.println("Front element: " + dq.getFront());
        dq.deleteFront();

        dq.printQueue();
        dq.deleteFront();
        dq.deleteRear();
    }
}

class CircularArrayDeque{
    int[] queue;
    int elements;
    int size;
    int front;
    int rear;

    public CircularArrayDeque(int capacity){
        this.size = capacity;
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = 0;
        this.elements = 0;
    }

    public int size(){
        return elements;
    }

    public boolean isFull(){
        // If no element is removed and all inserted till size, or front index crosses rear index
        return ((front == 0 && rear == size-1) || front == rear + 1);
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public int getFront(){
        return isEmpty() ? -1 : queue[front];
    }

    public int getRear(){
        return isEmpty() ? -1 : queue[rear];
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        System.out.println("Front: " + front + ", Rear: " + rear + ", Size: " + elements);
        System.out.print("Queue: [ ");
        do{
            // Print front at initial
            System.out.print(queue[i] + " ");
            // Increase pointer and modulo it by queue capacity
            i = ++i % size;
        } while(i <= rear); // Print till rear index
        System.out.println("]");
    }

    public void insertFront(int x){
        if(isFull()){
            System.out.println("Overflow: Cannot insert " + x);
            return;
        }
        // If queue is initially empty
        if (front == -1) {
            front = rear = 0;
        }
        // front is at first position of queue
        else if (front == 0){
            front = size-1;
        }
        // decrement front end by '1'
        else {
            front = front - 1;
        }
        queue[front] = x;
        elements++;
        System.out.println("Inserted front: " + x);
    }

    public void insertRear(int x){
        if(isFull()){
            System.out.println("Overflow: Cannot insert " + x);
            return;
        }
        // If queue is initially empty
        if (front == -1) {
            front = rear = 0;
        }
        // rear is at last position of queue
        else if(rear == size-1){
            rear = 0;
        }
        // increment rear end by '1'
        else{
            rear++;
        }
        queue[rear] = x;
        elements++;
        System.out.println("Inserted rear: " + x);
    }

    public int deleteFront(){
        if(isEmpty()){
            System.out.println("Underflow: Cannot delete");
            return -1;
        }
        int popped = queue[front];
        // Deque has only one element
        if (front == rear) {
            front = rear = -1;
        }
        // back to initial position
        else if(front == size-1){
            front = 0;
        }
        else{
            // increment front by '1' to remove current
            // front value from Deque
            front = front + 1;
        }
        elements--;
        System.out.println("Deleted front: " + popped);
        return popped;
    }

    public int deleteRear(){
        if(isEmpty()){
            System.out.println("Underflow: Cannot delete");
            return -1;
        }
        int popped = queue[rear];
        // Deque has only one element
        if (front == rear) {
            front = rear = -1;
        }
        // back to last position
        else if(rear == 0){
            rear = size-1;
        }
        else{
            // decrement rear by '1' to remove current
            // rear value from Deque
            rear--;
        }
        elements--;
        System.out.println("Deleted rear: " + popped);
        return popped;
    }

}