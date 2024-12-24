package tutorial.java.problems.propeers;

/**
 * Problem statement
 * You are given a string 'S'. Your task is to check whether the string is palindrome or not.
 * For checking palindrome, consider alphabets and numbers only and ignore the symbols and whitespaces.
 * Note :
 * String 'S' is NOT case sensitive.
 * Example : *
 * Let S = “c1 O$d@eeD o1c”.
 * If we ignore the special characters, whitespaces and convert all uppercase letters to lowercase,
 * we get S = “c1odeedo1c”, which is a palindrome. Hence, the given string is also a palindrome.
 * */
public class StringPalindromeCheck {

    private static char caseconvert(char ch){
        return (ch>='a' && ch<='z')? ch : (char) (ch-'A'+'a');
    }

    private static boolean alpnum(char ch){
        return (ch>='a'&&ch<='z'|| ch>='A'&&ch<='Z' ||ch>='0'&&ch<='1');
    }
    public static boolean checkPalindrome(String s) {

        // WRITE YOUR CODE HERE
        int i=0;
        int j=s.length()-1;
        while (i <= j) {
            if(alpnum(s.charAt(i))&&alpnum(s.charAt(j))){
                if(caseconvert(s.charAt(i))==caseconvert(s.charAt(j))){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
            else{
                if(alpnum(s.charAt(i))){
                    j--;
                }
                else if(alpnum(s.charAt(j))){
                    i++;
                }
                else{
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    // Above approach is most efficient
//    public static boolean checkPalindrome(String str) {
//        // WRITE YOUR CODE HERE
//        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//        String revStr = "";
//        for(int i = str.length()-1; i >= 0; i--){
//            revStr += str.charAt(i);
//        }
//        return revStr.equalsIgnoreCase(str);
//    }

    public static void main(String[] args){
        System.out.println(checkPalindrome("c1 O$d@eeD o1c"));
        System.out.println(checkPalindrome("aaBBa@"));
    }
}
