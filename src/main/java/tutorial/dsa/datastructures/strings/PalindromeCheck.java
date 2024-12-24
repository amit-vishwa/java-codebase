package tutorial.dsa.datastructures.strings;

/**
 * Refer: https://www.geeksforgeeks.org/palindrome-string/
 *
 * Palindrome String
 * Last Updated : 21 Sep, 2024
 * Given a string s, the task is to check if it is palindrome or not.
 *
 * Example:
 *
 * Input: s = “abba”
 * Output: 1
 * Explanation: s is a palindrome
 *
 *
 * Input: s = “abc”
 * Output: 0
 * Explanation: s is not a palindrome
 *
 * */
public class PalindromeCheck {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }

    /**
     * Optimization of two pointers approach – O(n) time and O(1) space
     * This approach is just an optimization of two variables that we have used in the above approach. Here, we can do the same with the help of single variable only. The idea is that:
     *
     * Iterates through the first half of the string.
     * For each character at index i, checks if s[i] and s[length – i – 1])
     * If any pair of characters don’t match, then returns 0.
     * If all characters match, then returns 1 (indicating the string is a palindrome).
     *
     * Time Complexity: O(n), where n is the length of the input string.
     * Auxiliary Space: O(1), no extra data structures used.
     * */
    public static int isPalindrome(String s){
        int len = s.length();

        // Iterate over the first half of the string
        for (int i = 0; i < len / 2; i++) {

            // If the characters at symmetric positions are
            // not equal
            if (s.charAt(i) != s.charAt(len - i - 1))

                // Return 0 (not a palindrome)
                return 0;
        }

        // If all symmetric characters are equal
        // then it is palindrome
        return 1;
    }

    /**
     * By Reversing String – O(n) time and O(n) space
     * According to the definition of a palindrome, a string reads the same both forwards and backwards. So, we can use this idea and compare the reversed string with the original one.
     *
     * If they are the same, the string is a palindrome, and then returns 1.
     * If they are different, then returns 0, meaning it’s not a palindrome.
     * */
    static int isPalindrome2(String s){
        // If reverse string is equal to given string,
        // then it is palindrome.
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString())?1:0;
    }
}
