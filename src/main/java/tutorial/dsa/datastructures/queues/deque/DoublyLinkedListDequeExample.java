package tutorial.dsa.datastructures.queues.deque;

/**
 *
 * Refer: https://www.geeksforgeeks.org/implementation-deque-using-doubly-linked-list/
 *
 * Deque or Double Ended Queue is a generalized version of Queue data structure that allows insert and delete
 * at both ends. In previous post Implementation of Deque using circular array has been discussed.
 * Now in this post we see how we implement Deque using Doubly Linked List.
 *
 * Operations on Deque :
 * Mainly the following four basic operations are performed on queue :
 *
 * insertFront() : Adds an item at the front of Deque.
 * insertRear()  : Adds an item at the rear of Deque.
 * deleteFront() : Deletes an item from front of Deque.
 * deleteRear()  : Deletes an item from rear of Deque.
 *
 * In addition to above operations, following operations are also supported :
 *
 * getFront() : Gets the front item from queue.
 * getRear()  : Gets the last item from queue.
 * isEmpty()  : Checks whether Deque is empty or not.
 * size()     : Gets number of elements in Deque.
 * erase()    : Deletes all the elements from Deque.
 *
 * */
public class DoublyLinkedListDequeExample {
    public static void main(String[] args){
        tcOne();
    }

    static void tcOne(){
        DoublyLinkedListDeque dq = new DoublyLinkedListDeque();
        dq.display();
        dq.insertRear(5);
        dq.insertRear(10);
        dq.insertFront(20);
        dq.insertFront(50);
        dq.insertRear(30);
        System.out.println("Deque size: " + dq.size());
        dq.display();
        dq.deleteRear();
        System.out.println("Rear element: " + dq.getRear());
        dq.deleteFront();
        System.out.println("Front element: " + dq.getFront());
        dq.display();
        dq.insertFront(15);
        dq.display();
        System.out.println("Deque size: " + dq.size());
        dq.deleteFront();
        dq.deleteRear();
        dq.deleteFront();
        dq.deleteRear();
        dq.deleteRear();
        System.out.println("Front element: " + dq.getFront());
        System.out.println("Rear element: " + dq.getRear());
        System.out.println("Deque size: " + dq.size());
        dq.display();
    }
}

class DoublyLinkedListDeque{
    private Node front;
    private Node rear;
    private int size;

    public DoublyLinkedListDeque(){
        front = rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void erase(){
        front = rear = null;
    }

    public int getFront(){
        return isEmpty() ? -1 : front.data;
    }

    public int getRear(){
        return isEmpty() ? -1 : rear.data;
    }

    /**
     * Insertion at Front end :
     *
     * 1. Allocate space for a newNode of doubly linked list.
     * 2. IF newNode == NULL, then
     * 3.     print "Overflow"
     * 4. ELSE
     * 5.     IF front == NULL, then
     * 6.         rear = front = newNode
     * 7.     ELSE
     * 8.         newNode->next = front
     * 9.       front->prev = newNode
     * 10.        front = newNode
     * */
    public void insertFront(int x){
        Node node = new Node(x);
        if(node == null){
            System.out.println("Overflow: Cannot insert");
            return;
        }
        if (isEmpty()){
            front = rear = node;
        } else {
           node.next = front;
        }
        front.prev = node;
        front = node;
        size++;
        System.out.println("Inserted front: " + x);
    }

    /**
     * Insertion at Rear end :
     *
     * 1. Allocate space for a newNode of doubly linked list.
     * 2. IF newNode == NULL, then
     * 3.     print "Overflow"
     * 4. ELSE
     * 5.     IF rear == NULL, then
     * 6.         front = rear = newNode
     * 7.     ELSE
     * 8.         newNode->prev = rear
     * 9.       rear->next = newNode
     * 10.        rear = newNode
     * */
    public void insertRear(int x){
        Node node = new Node(x);
        if(node == null){
            System.out.println("Overflow: Cannot insert");
            return;
        }
        if (isEmpty()){
            front = rear = node;
        } else {
            node.prev = rear;
        }
        rear.next = node;
        rear = node;
        size++;
        System.out.println("Inserted rear: " + x);
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        Node node = front;
        System.out.print("Queue: [ ");
        for(int i = 0; i < size; i ++){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    /**
     * Deletion from Front end :
     *
     * 1. IF front == NULL
     * 2.     print "Underflow"
     * 3. ELSE
     * 4.     Initialize temp = front
     * 5.     front = front->next
     * 6.     IF front == NULL
     * 7.         rear = NULL
     * 8.     ELSE
     * 9.         front->prev = NULL
     * 10     Deallocate space for temp
     * */
    public int deleteFront(){
        if(front == null){
            System.out.println("Underflow: Cannot delete");
            return -1;
        }
        Node temp = front;
        int popped = temp.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        else {
            front.prev = null;
        }
        temp = null;
        size--;
        System.out.println("Deleted front: " + popped);
        return popped;
    }

    /**
     * Deletion from Rear end :
     *
     * 1. IF front == NULL
     * 2.     print "Underflow"
     * 3. ELSE
     * 4.     Initialize temp = rear
     * 5.     rear = rear->prev
     * 6.     IF rear == NULL
     * 7.         front = NULL
     * 8.     ELSE
     * 9.         rear->next = NULL
     * 10     Deallocate space for temp
     * */
    public int deleteRear(){
        if(front == null){
            System.out.println("Underflow: Cannot delete");
            return -1;
        }
        Node temp = rear;
        int popped = temp.data;
        rear = rear.prev;
        if(rear == null){
            front = null;
        }
        else {
            rear.next = null;
        }
        temp = null;
        size--;
        System.out.println("Deleted rear: " + popped);
        return popped;
    }

}

class Node{
    int data;
    Node prev;
    Node next;
    public Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}