package tutorial.dsa.datastructures.stacks;

import java.util.Stack;

/**
 * Refer: https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 *
 * Given an expression string s, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.
 *
 * Example:
 *
 * Input: s = “[()]{}{[()()]()}”
 * Output: true
 * Explanation: All the brackets are well-formed
 *
 *
 * Input: s = “[(])”
 * Output: false
 * Explanation: 1 and 4 brackets are not balanced because
 * there is a closing ‘]’ before the closing ‘(‘
 * */
public class ValidateParenthesis {
    public static void main(String[] args){
        System.out.println(validateUsingStack("[()]{}{[()()]()}"));
        System.out.println(validateUsingStack("{()}[]"));
        System.out.println(validateUsingStack("[(])"));
        System.out.println(validateUsingStack(""));
        System.out.println();
        System.out.println(validateWithoutStack("[()]{}{[()()]()}"));
        System.out.println(validateWithoutStack("{()}[]"));
        System.out.println(validateWithoutStack("[(])"));
        System.out.println(validateWithoutStack(""));
    }

    /**
     * 1.[Expected Approach 1] Using Stack – O(n) Time and O(n) Space
     * The idea is to put all the opening brackets in the stack. Whenever you hit a closing bracket, search if the top of the stack is the opening bracket of the same nature. If this holds then pop the stack and continue the iteration. In the end if the stack is empty, it means all brackets are balanced or well-formed. Otherwise, they are not balanced.
     *
     * Step-by-step approach:
     *
     * Declare a character stack (say temp).
     * Now traverse the string exp.
     * If the current character is a starting bracket ( ‘(‘ or ‘{‘  or ‘[‘ ) then push it to stack.
     * If the current character is a closing bracket ( ‘)’ or ‘}’ or ‘]’ ) then pop from the stack and if the popped character is the matching starting bracket then fine.
     * Else brackets are Not Balanced.
     * After complete traversal, if some starting brackets are left in the stack then the expression is Not balanced, else Balanced.
     * */
    private static boolean validateUsingStack(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='{' || c=='(' || c=='['){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && (
                        (stack.peek() == '(' && c == ')') ||
                                (stack.peek() == '{' && c == '}') ||
                                (stack.peek() == '[' && c == ']')
                        )){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 2.[Expected Approach 2] Without using Stack – O(n) Time and O(1) Space
     * Instead of using actual Stack, we can uses the input string s itself to simulate stack behavior. We can use a top variable to keep track of the “top” of this virtual stack. This approach makes use of the existing string to avoid the need for additional memory to store stack elements.
     *
     * Note: Strings are immutable in Java, Python, C#, and JavaScript. Therefore, we cannot modify them in place, making this approach unsuitable for these languages.
     *
     * Step-by-step approach:
     *
     * Initialize top = -1 to represent an empty stack.
     * Traverse over the given string and for each character:
     * If top is -1 or the current character doesn’t match the top, increment top and store the character at s[top].
     * If the current character matches s[top], decrement top to remove the last unmatched opening parenthesis.
     * After processing, if top is -1, the string is balanced. Otherwise, it is unbalanced.
     * */
    private static boolean validateWithoutStack(String s){
        int counter = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                counter++;
                str.append(c);
            }else{
                char ch = str.charAt(counter-1);
                if(ch == '(' && c == ')' || ch == '{' && c == '}' || ch == '[' && c == ']'){
                    str.deleteCharAt(counter-1);
                    counter--;
                }
            }
        }
        return counter==0;
    }

}
