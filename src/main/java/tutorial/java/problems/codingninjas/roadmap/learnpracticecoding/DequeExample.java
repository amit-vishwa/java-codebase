package tutorial.java.problems.codingninjas.roadmap.learnpracticecoding;

public class DequeExample {
    public static void main(String... args){
        Deque queue = new Deque(7);
        System.out.println(queue.isEmpty());
        System.out.println(queue.pushFront(10));
        System.out.println(queue.pushFront(20));
        System.out.println(queue.pushRear(30));
        System.out.println(queue.getFront());
        System.out.println(queue.popRear());
        System.out.println(queue.popRear());
    }
}

class Deque
{
    // Initialize your data structure.
    private int data[];
    private int front;
    private int rear;
    private int size;
    private int capacity;


    public Deque(int n)
    {
        // Write your code here.
        capacity = n;
        data = new int[n];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x)
    {
        // Write your code here.
        if(isFull()) return false;
        if(isEmpty()){
            front=rear=0;
        }else{
            front=(front-1+capacity)%capacity;
        }
        data[front] = x;
        size++;
        return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x)
    {
        // Write your code here.
        if(isFull()) return false;
        if(isEmpty()){
            front=rear=0;
        }else{
            rear=(rear+1)%capacity;
        }
        data[rear] = x;
        size++;
        return true;
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popFront()
    {
        // Write your code here.
        if(isEmpty()) return -1;
        int popElement=data[front];
        if(front==rear){
            front=rear=-1;
        }else{
            front=(front+1)%capacity;
        }
        size--;
        return popElement;
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popRear()
    {
        // Write your code here.
        if(isEmpty()) return -1;
        int popElement=data[rear];
        if(front==rear){
            front=rear=-1;
        }else{
            rear=(rear-1+capacity)%capacity;
        }
        size--;
        return popElement;
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront()
    {
        // Write your code here.
        if(isEmpty()) return -1;
        return data[front];
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear()
    {
        // Write your code here.
        if(isEmpty()) return -1;
        return data[rear];
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty()
    {
        // Write your code here.
        return size==0;

    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull()
    {
        // Write your code here.
        return size==capacity;
    }
}