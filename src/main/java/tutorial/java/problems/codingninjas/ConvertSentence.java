package tutorial.java.problems.codingninjas;

// https://www.naukri.com/code360/problem-of-the-day/easy

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Below answer accepted partially, new approaches can be utilized
public class ConvertSentence {
    static Map<Character, List<Integer>> getKeypadMap(){
        Map<Character, List<Integer>> keypadMap = new HashMap<>();
        keypadMap.put('a', Arrays.asList(2, 1));
        keypadMap.put('b', Arrays.asList(2, 2));
        keypadMap.put('c', Arrays.asList(2, 3));
        keypadMap.put('d', Arrays.asList(3, 1));
        keypadMap.put('e', Arrays.asList(3, 2));
        keypadMap.put('f', Arrays.asList(3, 3));
        keypadMap.put('g', Arrays.asList(4, 1));
        keypadMap.put('h', Arrays.asList(4, 2));
        keypadMap.put('i', Arrays.asList(4, 3));
        keypadMap.put('j', Arrays.asList(5, 1));
        keypadMap.put('k', Arrays.asList(5, 2));
        keypadMap.put('l', Arrays.asList(5, 3));
        keypadMap.put('m', Arrays.asList(6, 1));
        keypadMap.put('n', Arrays.asList(6, 2));
        keypadMap.put('o', Arrays.asList(6, 3));
        keypadMap.put('p', Arrays.asList(7, 1));
        keypadMap.put('q', Arrays.asList(7, 2));
        keypadMap.put('r', Arrays.asList(7, 3));
        keypadMap.put('s', Arrays.asList(7, 4));
        keypadMap.put('t', Arrays.asList(8, 1));
        keypadMap.put('u', Arrays.asList(8, 2));
        keypadMap.put('v', Arrays.asList(8, 3));
        keypadMap.put('w', Arrays.asList(9, 1));
        keypadMap.put('x', Arrays.asList(9, 2));
        keypadMap.put('y', Arrays.asList(9, 3));
        keypadMap.put('z', Arrays.asList(9, 4));
        return keypadMap;
    }

    static Map<List<Character>, Integer> getCharaterMap(){
        Map<List<Character>, Integer> charaterMap = new HashMap<>();
        charaterMap.put(Arrays.asList('a','b','c'), 2);
        charaterMap.put(Arrays.asList('d','e','f'), 3);
        charaterMap.put(Arrays.asList('g','h','i'), 4);
        charaterMap.put(Arrays.asList('j','k','l'), 5);
        charaterMap.put(Arrays.asList('m','n','o'), 6);
        charaterMap.put(Arrays.asList('p','q','r','s'), 7);
        charaterMap.put(Arrays.asList('t','u','v'), 8);
        charaterMap.put(Arrays.asList('w','x','y','z'), 9);
        return charaterMap;
    }

    public static String convertSentence(String str)
    {
        //    Write your code here.
        String convertedString = "";
        Map<Character, List<Integer>> charaterMap = getKeypadMap();
        for(Character c : str.toCharArray()){
            Integer number = charaterMap.get(c).get(0);
            Integer counter = charaterMap.get(c).get(1);
            System.out.println(c + " => " + number + " " + counter);
            while(counter>0){
                convertedString += number;
                counter--;
            }
        }
        return convertedString;
    }
    public static void main(String[] args){
        System.out.println(convertSentence("codingninjas"));
        System.out.println(convertSentence("f"));
    }
}
