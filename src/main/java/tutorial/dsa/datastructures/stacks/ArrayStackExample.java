package tutorial.dsa.datastructures.stacks;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/implement-stack-using-array/
 *
 * Static sized stack
 *
 * Time Complexity:
 * push: O(1)
 * pop: O(1)
 * peek: O(1)
 * is_empty: O(1)
 * is_full: O(1)
 *
 * Auxiliary Space: O(n), where n is the number of items in the stack.
 * */
public class ArrayStackExample {
    public static void main(String args[]){
        ArrayStack stack = new ArrayStack();
        stack.printStack();
        stack.pop();
        stack.push(1);
        stack.pop();
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Is stack empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
        stack.pop();
        stack.push(4);
        System.out.println("Top element: " + stack.peek());
        stack.push(5);
        stack.push(6);
        stack.printStack();
        stack.push(7);
        stack.push(8);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is stack empty: " + stack.isEmpty());
        System.out.println("Is stack full: " + stack.isFull());
        System.out.println("Top element: " + stack.peek());
        stack.push(9);
        stack.printStack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is stack empty: " + stack.isEmpty());
        System.out.println("Is stack full: " + stack.isFull());
        stack.printStack();
    }
}

class ArrayStack{
    private int[] list;
    private int top;
    private int capacity;
    private int size;

    public ArrayStack(){
        capacity = 10;
        list = new int[capacity];
        top = -1;
        size = 0;
    }

    public void push(int x){
        if(top == -1 || size <= capacity-1){
            list[++top] = x;
            size++;
            System.out.println("Pushed: " + x);
        }else {
            System.out.println("Stack over flow occurred: Cannot push " + x);
        }
    }

    public int pop(){
        int popElement = 0;
        if(top >= 0){
            size--;
            popElement = list[top--];
            System.out.println("Popped: " + popElement);
        }else {
            System.out.println("Stack under flow occurred: Cannot pop");
            popElement = -1;
        }
        return popElement;
    }

    public int peek(){
        return top>=0 ? list[top] : -1;
    }

    public int size(){
        return size;
    }

    public boolean isFull(){
        return capacity == size;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void printStack(){
        System.out.println(Arrays.toString(list));
    }

}
