package tutorial.dsa.datastructures.queues;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-and-array-implementation-of-queue/
 *
 * Refer: https://www.geeksforgeeks.org/different-types-of-queues-and-its-applications/
 * */
public class ArrayQueueExample {
    public static void main(String[] args){
        ArrayQueue q = new ArrayQueue(4);

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
        System.out.println("After two node deletions:");

        q.display();

        // Get the front and rear element
        System.out.println("Front: " + q.front());
        System.out.println("Rear: " + q.rear());
        System.out.println("Size: " + q.size());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(12);
        pq.remove();
        pq.contains(1);
        pq.poll();

    }
}

class ArrayQueue{
    private int[] list;
    private int size;
    private int capacity;

    public ArrayQueue(int cap){
        capacity = cap;
        list = new int[capacity];
        size = -1;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue if empty");
        }else{
            // printing all elements within size
            System.out.print("Queue: [ ");
            for(int i=0; i<=size; i++){
                System.out.print(list[i]+" ");
            }
            System.out.println("]");
        }
    }

    public boolean isFull(){
        return size==capacity-1;
    }

    public boolean isEmpty(){
        return size==-1;
    }

    public int size(){
        return size+1;
    }

    public int front(){
        return isEmpty()? -1 : list[0];
    }

    public int rear(){
        return isEmpty()? -1 : list[size];
    }

    public void enqueue(int x){
        if(isEmpty() || !isFull()){
            list[++size] = x;
            System.out.println("Enqueued: " + x);
        }else{
            System.out.println("Overflow: Cannot enqueue " + x);
        }
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Underflow: Cannot dequeue");
        }else{
            int popped = list[0];
            int i = 0;
            while(i<size){
                list[i] = list[i+1];
                i++;
            }
            list[size--] = 0;
            System.out.println("Dequeued: " + popped);
        }
    }

}
