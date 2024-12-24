package tutorial.dsa.problems.queues;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Refer: https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1?page=1&category=Queue&difficulty=Basic&sortBy=submissions
 * */
public class QueueUsingLinkedList {
    public static void main(String... args){
//        tcOne(new LLQueue());
//        tcTwo(new LLQueue());
//        tcThree(new LLQueue());
//        1 78 2 2 2 1 93 2 2 1 28 1 60 2 1 41 1 73 1 12 1 68 2 1 31 1 24 2 2 2 1 23 1
//    70 2 2 1 12 1 30 2 2 2 1 38 1 25 2 1 14 1 92 1 57 2 1 71 1 82 2 2 1 28 1 6 1 30 2 2 1 96
//    1 46 1 68 1 65 2 1 88
        tcFour(new LLQueue());

    }

    static void tcOne(LLQueue queue){
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
    }

    static void tcTwo(LLQueue queue){
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(3);
    }

    static void tcThree(LLQueue queue){
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(78);
        queue.push(8);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(1);
        queue.push(9);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    static void tcFour(LLQueue queue){
        queue.push(78);
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        queue.push(93);
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        queue.push(28);
        queue.push(60);
        System.out.print(queue.pop() + " ");
        queue.push(41);
        queue.push(73);
        queue.push(12);
        queue.push(68);
        System.out.print(queue.pop() + " ");
        queue.push(31);
        queue.push(24);
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        queue.push(23);
        queue.push(70);
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        queue.push(12);
    }

}

class LLQueue
{
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
        // Your code here
        QueueNode node = new QueueNode(a);
        if(front == null || rear == null){
            rear = front = node;
        }else{
            rear.next = node;
            rear = node;
        }
    }

    //Function to pop front element from the queue.
    int pop()
    {
        // Your code here
        if(front == null){
            return -1;
        }
        QueueNode temp = front;
        int popped = temp.data;
        front = front.next;
        return popped;
    }
}

class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}