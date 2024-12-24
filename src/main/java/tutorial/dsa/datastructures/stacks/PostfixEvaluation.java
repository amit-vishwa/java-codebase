package tutorial.dsa.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * Refer: https://www.geeksforgeeks.org/evaluation-of-postfix-expression/
 *
 * Given a postfix expression, the task is to evaluate the postfix expression.
 *
 * Postfix expression: The expression of the form “a b operator” (ab+) i.e., when a pair of operands is followed by an operator.
 * Examples:
 *
 * Input: str = “2 3 1 * + 9 -“
 * Output: -4
 * Explanation: If the expression is converted into an infix expression, it will be 2 + (3 * 1) – 9 = 5 – 9 = -4.
 *
 * Input: str = “100 200 + 2 / 5 * 7 +”
 * Output: 757
 *
 * Evaluation of Postfix Expression using Stack:
 * To evaluate a postfix expression we can use a stack.
 * Iterate the expression from left to right and keep on storing the operands into a stack.
 * Once an operator is received, pop the two topmost elements and evaluate them and push the result in the stack again.
 * */
public class PostfixEvaluation {
    public static void main(String[] args)
    {
        String exp = "231*+9-";
        // Function call
        System.out.println("postfix evaluation: "
                + evaluatePostfix(exp));
    }

    private static Integer evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(c>=48 && c<=57){
                stack.push(c-48);
            }else{
                if(c == '+'){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1+num2);
                }
                else if(c == '-'){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1-num2);
                }
                else if(c == '*'){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1*num2);
                }
                else if(c == '/'){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1/num2);
                }
            }
        }
        return stack.pop();
    }
}
