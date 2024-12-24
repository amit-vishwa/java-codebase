package tutorial.dsa.datastructures.strings;

import java.util.Stack;

/**
 * Refer: https://www.geeksforgeeks.org/reverse-a-string/
 * */
public class ReverseString {
    public static void main(String... args){
        String s = "abcdef";
        System.out.println("Original string: "+s);
        reverseUsingBackwardTraversal(s);
        reverseUsingTwoPointers(s);
        reverseUsingRecursion(s);
        reverseUsingStack(s);
        reverseUsingInbuiltMethod(s);
    }

    /**
     * 1.Using backward traversal – O(n) Time and O(n) Space
     * The idea is to start at the last character of the string and move backward, appending each character
     * to a new string res. This new string res will contain the characters of the original string in reverse order.
     *
     * Time Complexity: O(n) for backward traversal
     * Auxiliary Space: O(n) for storing the reversed string.
     * */
    static void reverseUsingBackwardTraversal(String s){
        String reverse = "";
        // Traverse on s in backward direction
        // and add each character to a new string
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        System.out.println("Reversed using backward traversal: "+reverse);
    }

    /**
     * 2.Using Two Pointers – O(n) Time and O(n) Space
     * The idea is to maintain two pointers: left and right, such that left points to the beginning of
     * the string and right points to the end of the string.
     * While left pointer is less than the right pointer, swap the characters at these two positions.
     * After each swap, increment the left pointer and decrement the right pointer to move towards the center
     * of the string. This will swap all the characters in the first half with their corresponding character
     * in the second half.
     * */
    static void reverseUsingTwoPointers(String s){
        StringBuilder reverseString = new StringBuilder(s);
        int start = 0;
        int end = s.length()-1;
        // Update chars till left pointer is less than right one
        while(start<end){
            char temp = reverseString.charAt(start);
            reverseString.setCharAt(start++, reverseString.charAt(end));
            reverseString.setCharAt(end--, temp);
        }
        System.out.println("Reversed using two pointers: "+reverseString.toString());
    }

    /**
     * 3.Using Recursion – O(n) Time and O(n) Space
     * The idea is to use recursion and define a recursive function that takes a string as input and reverses it. Inside the recursive function,
     * Swap the first and last element.
     * Recursively call the function with the remaining substring.
     * */
    static void reverseUsingRecursion(String s){
        StringBuilder reverseString = new StringBuilder(s);
        int start = 0;
        int end = s.length()-1;
        reverse(reverseString, start, end);
        System.out.println("Reversed using recursion: "+reverseString.toString());
    }
    static void reverse(StringBuilder reverseString, int start, int end){
        if(start>=end){
            return;
        }
        char temp = reverseString.charAt(start);
        reverseString.setCharAt(start++, reverseString.charAt(end));
        reverseString.setCharAt(end--, temp);
        reverse(reverseString, start, end);
    }

    /**
     * 4.Using Stack – O(n) Time and O(n) Space
     * The idea is to use stack for reversing a string because Stack follows Last In First Out (LIFO) principle.
     * This means the last character you add is the first one you’ll take out. So, when we push all the
     * characters of a string into the stack, the last character becomes the first one to pop.
     * */
    static void reverseUsingStack(String s){
        Stack<Character> stack = new Stack<>();
        // Push character by character in stack
        for(char c : s.toCharArray()){
            stack.push(c);
        }
        String reverse = "";
        // Pop character by character from stack and store in new string
        for (int i = 0; i < s.length(); i++) {
            reverse += stack.pop();
        }
        System.out.println("Reversed using stack: "+reverse);
    }

    /**
     * 5.Using Inbuilt methods – O(n) Time and O(1) Space
     * The idea is to use built-in reverse method to reverse the string. If built-in method  for string
     * reversal does not exist, then convert string to array or list and use their built-in method for reverse.
     * Then convert it back to string.
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1) in C++ and python and O(n) in Java, C# and JavaScript
     * (extra space is used to store in array or list or StringBuilder for reversal).
     * */
    static void reverseUsingInbuiltMethod(String s){
        StringBuilder reverseString = new StringBuilder(s);
        reverseString.reverse();
        System.out.println("Reversed using reverse(): "+reverseString.toString());
    }

}
