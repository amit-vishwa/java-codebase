package tutorial.dsa.datastructures.stacks;

/**
 * Refer: https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/
 *
 * Dynamic sized stack
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
public class LinkedListStackExample {
    public static void main(String... args){
// Creating a stack
        LinkedListStack st = new LinkedListStack();
        System.out.println("Stack size: " + st.size());
        System.out.println("Is stack empty: " + st.isEmpty());
        System.out.println("Is stack full: " + st.isFull());

        // Push elements onto the stack
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        st.display();
        System.out.println("Stack size: " + st.size());
        System.out.println("Is stack full: " + st.isEmpty());
        System.out.println("Is stack empty: " + st.isFull());

        // Print top element of the stack
        System.out.println("Top element: " + st.peek());

        st.pop();
        st.pop();

        System.out.println("Stack size: " + st.size());
        // Print top element of the stack
        System.out.println("Top element: " + st.peek());
        st.display();
        st.pop();
        // Print size of the stack
        System.out.println("Stack size: " + st.size());
    }
}

class LinkedListStack{
    // Head of the linked list
    private Node head;
    private int size;
    private boolean isFull;

    // Constructor to initialize the stack
    public LinkedListStack(){
        head = null;
        size = 0;
        isFull = false;
    }

    // Returns true if list is empty, false otherwise
    public boolean isEmpty(){
        return head == null;
    }

    // Returns true if list is full, false otherwise
    public boolean isFull(){
        return isFull;
    }

    // Returns true if list is empty, false otherwise
    public int size(){
        return size;
    }

    // Prints all list data
    public void display(){
        Node temp = head;
        System.out.print("Stack elements are: ");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Pushes an element in the stack
    public void push(int x){
        Node node = new Node(x);
        if(node == null){
            isFull = true;
            System.out.println("Stack Overflow: Cannot push " + x);
            return;
        }
        if(head != null){
            // Link the new node to the current top node
            node.next = head;
        }
        size++;
        // Update the top to the new node
        head = node;
        System.out.println("Pushed: " + x);
    }

    // Pops an element from the stack
    public int pop(){
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop");
            return -1;
        }
        int top = head.data;
        Node temp = head;
        // Update the top to the next node
        head = head.next;
        // Deallocate the memory of the old top node
        temp = null;
        size--;
        isFull = false;
        System.out.println("Popped: " + top);
        return top;
    }

    // Returns -1 if list is empty, else head data
    public int peek(){
        return isEmpty() ? -1 : head.data;
    }
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next= null;
    }
}
