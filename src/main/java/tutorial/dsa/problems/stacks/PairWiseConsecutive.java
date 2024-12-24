package tutorial.dsa.problems.stacks;

import java.util.Stack;

/**
 * Refer: https://www.geeksforgeeks.org/problems/pairwise-consecutive-elements/1?page=1&category=Stack&difficulty=Basic&sortBy=submissions
 * */
public class PairWiseConsecutive {

    public static void main(String... args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);stack.push(2);stack.push(3);
        stack.push(4);stack.push(5);stack.push(6);
        System.out.println(pairWiseConsecutive(stack));
    }

    public static boolean pairWiseConsecutive(Stack<Integer> st)
    {
        // Your code here
        int size = st.size();
        if(size % 2 != 0){
            st.pop();
        }
         while(size>0){
             System.out.println(size);
             int num2 = st.pop();
             int num1 = st.pop();
             if(num1-num2 != 1 && num1-num2 != -1){
                 return false;
             }
             size -= 2;
         }
        return true;
    }
}
