package tutorial.dsa.problems.stacks;

import java.util.Stack;

/**
 * Refer: https://www.naukri.com/code360/problem-of-the-day/easy
 * */
public class PostFixEvaluation {

    public static void main(String... args){
        System.out.println(evaluatePostfix(new String[]{"2","3","1","*","+","9","-"}));
    }

    public static int evaluatePostfix(String[] exp) {
        // Write your code here.
        long mod = 1000000007L;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < exp.length; i++){
            switch(exp[i]){
                case "*":
                    if(!stack.isEmpty())
                        stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    if(!stack.isEmpty()){
                        int n2 = stack.pop();
                        int n1 = stack.pop();
                        stack.push(n1/n2);
                    }
                    break;
                case "+":
                    if(!stack.isEmpty())
                        stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    if(!stack.isEmpty()){
                        int num2 = stack.pop();
                        int num1 = stack.pop();
                        stack.push(num1-num2);
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(exp[i]));
                    break;
            }
        }
        return (int) mod+stack.pop();
    }

}
