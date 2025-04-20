package youtube.collection.list.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Stack is a part of Collections framework, it extends the Vector class.
 * It uses the LIFO (Last In First Out) principle while performing operations.
 * Since it is a subclass of Vector, Stack is also thread-safe.
 * */
public class StackExample {

    public static void main(String[] args) {
//        basicStackOperations();
//        linkedListAsStack();
        arrayListAsStack();
    }

    private static void basicStackOperations() {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Stack size: " + stack.size() + ", Is stack empty? " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack size: " + stack.size() + ", Is stack empty? " + stack.isEmpty());
        System.out.println("Stack: " + stack);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Stack: " + stack);
        System.out.println("Top element: " + stack.peek());
        // search() returns 1 based index from top of stack if found, else returns -1
        System.out.println("Index of element 1 from top: " + stack.search(1));
    }

    // not recommended as Stack exists
    private static void linkedListAsStack() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5); // push
        System.out.println("Stack: " + linkedList);
        System.out.println("Top element: " + linkedList.getLast()); // peek
        System.out.println("Removed element: " + linkedList.removeLast()); // pop
        System.out.println("Top element: " + linkedList.getLast()); // peek
        // linkedList has indexOf() which is 0 based indexing from start i.e. bottom
        System.out.println("Index of element 1 from bottom: " + linkedList.indexOf(1));
        System.out.println("Index of element 10 from bottom: " + linkedList.indexOf(10));
        System.out.println("Stack size: " + linkedList.size() + ", Is stack empty? " + linkedList.isEmpty());
    }

    // never recommended
    private static void arrayListAsStack() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5); // push
        System.out.println("Stack: " + arrayList);
        System.out.println("Top element: " + arrayList.get(arrayList.size()-1)); // peek
        System.out.println("Removed element: " + arrayList.remove(arrayList.size()-1)); // pop
        System.out.println("Top element: " + arrayList.get(arrayList.size()-1)); // peek
        // linkedList has indexOf() which is 0 based indexing from start i.e. bottom
        System.out.println("Index of element 1 from bottom: " + arrayList.indexOf(1));
        System.out.println("Index of element 10 from bottom: " + arrayList.indexOf(10));
        System.out.println("Stack size: " + arrayList.size() + ", Is stack empty? " + arrayList.isEmpty());
    }

}
