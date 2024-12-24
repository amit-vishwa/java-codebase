package tutorial.dsa.datastructures.strings;

/**
 * Refer: https://www.geeksforgeeks.org/program-print-substrings-given-string/
 *
 * Given a string as an input. We need to write a program that will print all non-empty substrings of that given string.
 * Examples :
 * Input :  s = “abc”
 * Output :  “a”,  “b”,  “c”,  “ab”,  “bc”,  “abc”
 * Input :  s = “a”
 * Output :  “a”
 * Input :  s = “”
 * Output :  “”
 *
 * We mainly use two nested loops
 * Outermost Loop : Picks starting index of current subarray
 * Inner Loop : Picks ending point of current subarray and prints the subarray using substring function.
 *
 * Time Complexity : O(n^3) Note that there are two nested loops and then we use substr function which
 * also takes O(n) time.
 * */
public class Substrings {
    static void printSubstrings(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                // Print the substring from index i to j
                System.out.print(s.substring(i, j) + " ");
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println("Original string: "+ s);
        System.out.print("Sub strings: ");
        printSubstrings(s);
    }
}
