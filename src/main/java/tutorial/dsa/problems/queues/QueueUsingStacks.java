package tutorial.dsa.problems.queues;

import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String... args){
//        tcOne();
//        tcTwo();
        tcThree();
    }

    static void tcOne(){
        Queue q = new Queue();
        q.enqueue(2);
        q.enqueue(3);
        System.out.print(q.dequeue()+" ");
        q.enqueue(4);
        System.out.print(q.dequeue()+" ");
    }

    static void tcTwo(){
        Queue q = new Queue();
        q.enqueue(2);
        System.out.print(q.dequeue()+" ");
        System.out.print(q.dequeue()+" ");
    }

    static void tcThree(){
        Queue q = new Queue();
        q.enqueue(2);
        q.enqueue(6);
        q.enqueue(8);
        System.out.print(q.dequeue()+" ");
        q.enqueue(2);
        q.enqueue(1);
        System.out.print(q.dequeue()+" ");
        System.out.print(q.dequeue()+" ");
        System.out.print(q.dequeue()+" ");
        System.out.print(q.dequeue()+" ");
        System.out.print(q.dequeue()+" ");
    }

}

class Queue
{
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
        // Your code here
        if(input.size() == 0){
            return -1;
        }
        while (input.size()>1){
            output.push(input.pop());
        }
        int num = input.pop();
        while (!output.isEmpty()){
            input.push(output.pop());
        }
        return num;
    }

    /* The method push to push element into the stack */
    void enqueue(int x)
    {
        // Your code here
        input.push(x);
    }
}
