package tutorial.dsa.datastructures.strings;

/**
 *
 * Refer: https://www.geeksforgeeks.org/pangram-checking/
 *
 * Check if given String is Pangram or not
 * Last Updated : 25 Nov, 2024
 * Given a string s, the task is to check if it is Pangram or not. A pangram is a sentence containing all letters of the English Alphabet.
 *
 * Examples:
 *
 * Input: s = “The quick brown fox jumps over the lazy dog”
 * Output: true
 * Explanation: The input string contains all characters from ‘a’ to ‘z’.
 *
 *
 * Input: s = “The quick brown fox jumps over the dog”
 * Output: false
 * Explanation: The input string does not contain all characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing
 *
 *  */
public class PangramCheck {

    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        if (checkPangramUsingNativeApproach(s) == true)
            System.out.println("true");
        else
            System.out.println("false");

        String str = "Mr. Jock, TV quiz PhD., bags few lynx.";
        System.out.println(checkPangramUsingVisitedApproach(str));
    }

    /**
     * 1.[Naive Approach] By Searching for each Character – O(MAX_CHAR * n) Time and O(1) Space
     * The idea is to iterate over all characters from ‘a’ to ‘z’ and for each character, check if it is
     * present in the input string or not. If any character is not present in the input string, return false.
     * Otherwise, return true. Also, we need to ignore the case while searching for a character(‘a’ and ‘A’
     * are considered same).
     *
     * Time Complexity : O(MAX_CHAR * n), where n is the length of input string and MAX_CHAR = 26 as we only need to check all English alphabets.
     * Auxiliary Space: O(1)
     * */
    static boolean checkPangramUsingNativeApproach(String s) {
        // Iterate over all the characters
        for(char ch = 'a'; ch <= 'z'; ch++) {
            boolean found = false;
            // Search for the character in the string
            for(int i = 0; i < s.length(); i++) {
                if(ch == Character.toLowerCase(s.charAt(i))) {
                    found = true;
                    break;
                }
            }
            // If ch is not present in s, return false
            if(found == false)
                return false;
        }
        return true;
    }

    /**
     * 2.[Expected Approach] Using Visited Array – O(n) Time and O(MAX_CHAR) Space
     *  The idea is to create a visited array of size 26 to mark whether a character is present in the string
     *  or not. Now, iterate through all the characters of the string and mark them as visited. Lowercase and
     *  Uppercase are considered the same. So ‘A’ and ‘a’ are marked at index 0 and similarly ‘Z’ and ‘z’
     *  are marked at index 25.
     * After iterating through all the characters, check whether all the characters are marked in visited
     * array or not. If not then return false else return true.
     *
     * Time Complexity : O(n), where n is the length of our string
     * Auxiliary Space: O(MAX_CHAR), where MAX_CHAR = 26 as we only need to mark all English alphabets.
     * */
    static final int MAX_CHAR = 26;
    static boolean checkPangramUsingVisitedApproach(String s) {
        // Visited array to mark occurrence of characters
        boolean[] vis = new boolean[MAX_CHAR];
        // Iterate over the string to mark the presence of characters
        for (int i = 0; i < s.length(); i++) {
            // If uppercase character, subtract 'A' to find index
            // (index 0 for 'A' and 25 for 'Z')
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z')
                vis[s.charAt(i) - 'A'] = true;
                // If lowercase character, subtract 'a' to find index
                // (index 0 for 'a' and 25 for 'z')
            else if ('a' <= s.charAt(i) && s.charAt(i) <= 'z')
                vis[s.charAt(i) - 'a'] = true;
        }
        // Check if any character is unvisited
        for (int i = 0; i < MAX_CHAR; i++) {
            if (!vis[i])
                return false;
        }
        // If all characters are present, return true
        return true;
    }

}
