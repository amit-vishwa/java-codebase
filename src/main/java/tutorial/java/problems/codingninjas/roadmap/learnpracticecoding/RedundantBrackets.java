package tutorial.java.problems.codingninjas.roadmap.learnpracticecoding;

import java.util.Stack;

public class RedundantBrackets {
    public static boolean findRedundantBrackets(String s)
    {
        // Write your code here.
        Stack<Character> set=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c == '+' || c == '-' || c == '*' || c == '/'){
                set.push(c);
            }else if(c==')'){
                boolean isRedundant = true;
                while(set.peek()!='('){
                    char top = set.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isRedundant = false;
                    }
                }
                set.pop();
                if (isRedundant) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String... args){
        System.out.println(findRedundantBrackets("(a+b)"));
        System.out.println(findRedundantBrackets("(a+c*b)+(c)"));
        System.out.println(findRedundantBrackets("(a*b+(c/d))"));
        System.out.println(findRedundantBrackets("((a/b))"));
    }
}
