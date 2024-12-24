package tutorial.dsa.problems.arrays;

public class MyStack {
    public static void main(String... args){
        Stack stack = new Stack();

//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.pop());
//        stack.push(4);
//        System.out.println(stack.pop());
//        stack.push(2);

        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());

        System.out.println(stack.toString());
    }
}

class Stack {
    private int[] arr;
    private int top;
    private int size;

    public Stack() {
        arr = new int[1000];
        top = -1;
        size = -1;
    }

    public void push(int x) {
        // Your Code
        if(size == -1){
            arr[0] = x;
            // top = arr[0];
        }else{
            arr[size+1] = x;
            // top = arr[size];
        }
        top = x;
        size++;
    }

    public int pop() {
        // Your Code
        int n = 0;
        if(size == -1){
            top = -1;
            n = -1;
        }else{
            arr[size] = 0;
            size--;
            n = top;
            if(size>=0)
                top = arr[size];
        }
        return n;
    }

}
