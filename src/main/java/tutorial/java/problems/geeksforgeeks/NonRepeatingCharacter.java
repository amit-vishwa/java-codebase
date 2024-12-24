package tutorial.java.problems.geeksforgeeks;

import java.util.*;

// https://www.geeksforgeeks.org/problems/non-repeating-character-1587115620/1
// Easy problem on GeeksForGeeks

public class NonRepeatingCharacter {
    public static void main(String... args){
        System.out.println(nonRepeatingChar("hello"));
//        System.out.println(nonRepeatingChar("uhgxusrtgqitrtpiuqxmpdmyumdputxumlxnrnfwgeuslwdysxhucykkmzfdourroagoan"));
    }
    static char nonRepeatingChar(String s) {
        // Your code here
        // Approach 1 - more optimized
//        ArrayList<Character> charList = new ArrayList<>();
//        ArrayList<Integer> charCountList = new ArrayList<>();
//        for(int i = 0; i < s.length(); i++){
//            if(!charList.contains(s.charAt(i))){
//                charList.add(s.charAt(i));
//                charCountList.add(1);
//            }else{
//                int index = charList.indexOf(s.charAt(i));
//                charCountList.set(index, charCountList.get(index)+1);
//            }
//        }
//        Integer singleCharIndex = charCountList.indexOf(1);
//        if(singleCharIndex>=0){
//            return charList.get(singleCharIndex);
//        }

        // Approach 2 - less optimized
//        int i = 0;
//        String str = "";
//        while(i <= s.length() - 1){
//            str = s.substring(0,i) +" "+ s.substring(i+1, s.length());
//            if(!str.contains(String.valueOf(s.charAt(i)))){
//                return s.charAt(i);
//            }
//            i++;
//        }

        // Approach 3 - best solution but don't iterate over map
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!charCount.containsKey(s.charAt(i))){
                charCount.put(s.charAt(i), 1);
            }else{
                charCount.replace(s.charAt(i), charCount.get(s.charAt(i)), charCount.get(s.charAt(i))+1);
            }
        }
       for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
           if(entry.getValue() == 1){
               return entry.getKey();
           }
       }
        return '$';
    }
}
