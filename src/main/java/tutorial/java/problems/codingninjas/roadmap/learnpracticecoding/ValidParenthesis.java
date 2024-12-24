package tutorial.java.problems.codingninjas.roadmap.learnpracticecoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValidParenthesis(String s) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                 stack.push(c);
            }else{
                if(c == ']'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek() != '['){
                        return false;
                    }
                    stack.pop();
                }
                else if(c == ')'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek() != '('){
                        return false;
                    }
                    stack.pop();
                }
                else if(c == '}'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek() != '{'){
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return true;
//        Map<Character,Integer> map = new HashMap<>();
//        map.put('(',0);map.put('{',0);map.put('[',0);
//        map.put(')',0);map.put('}',0);map.put(']',0);
//        for(char c : s.toCharArray()){
//            if(map.containsKey(c)){
//                map.put(c,  map.get(c)+1);
//            }
//        }
//        if(!map.get('(').equals(map.get(')'))){
//            return false;
//        }
//        if(!map.get('{').equals(map.get('}'))){
//            return false;
//        }
//        if(!map.get('[').equals(map.get(']'))){
//            return false;
//        }
//        return true;
    }
    public static void main(String... args){
        System.out.println(isValidParenthesis("[()]{}{[()()]()}"));
        System.out.println(isValidParenthesis("[[}["));
        System.out.println(isValidParenthesis("[]([(]([{]]}{]{{)[}}{[{)}(}({{{])[){])({[[{[)]{)][)]{)({)[{)]{])}](]{)}][})}){({{{(){}{{(])]{{)]({{][)]{({(]{(}]{([)((}([()()[)][[}((}]}{}]]{]{{(}{)]])(((({(]}})}([{{]{]{)[]((]))[[])(]{}{)]]{[[}[][][]([(]][{[}[]}}]}{{]{}[))}}])]([))[{([(]){)}))])[]{}{[]]}})){[{]][(]}]{){[][]{[)[]}]}{{)][{[)[]{]){{(}({)))[()(}}(]}[}"));
    }
}
