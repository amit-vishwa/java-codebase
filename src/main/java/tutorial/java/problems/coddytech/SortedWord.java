package tutorial.java.problems.coddytech;

import java.util.Arrays;

public class SortedWord {

    public static String sort(String s) {
        // Write code here
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sortedString = new StringBuilder();
        for(char c : charArray){
            sortedString.append(c);
        }
        return sortedString.toString();
    }

    public static boolean isPrime(int num) {
        // Write code here
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String... args){
        System.out.println(sort("hello"));
        System.out.println(sort("test"));
        System.out.println(sort("bye"));
        System.out.println(sort("vocabulary"));
        System.out.println(sort("example"));
        System.out.println(isPrime(4));
        System.out.println(isPrime(13));
        System.out.println(isPrime(89));
        System.out.println(isPrime(87));
    }
}
