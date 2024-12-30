package tutorial.dsa.algorithms.patternsearching;

/**
 * Refer: https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
 *
 * Brute-Force:	It compares the pattern with every substring of the text. Time complexity is O(mn)
 *
 * Naive Pattern Searching Algorithm
 * The idea is, we start at every index in the text and compare it with the first character of the pattern, if they match we move
 * to the next character in both text and pattern. If there is a mismatch, we start the same process for the next index of the text.
 *
 * Given text string with length n and a pattern with length m, the task is to prints all occurrences of pattern in text.
 * Note: You may assume that n > m.
 *
 * Input:  text = “THIS IS A TEST TEXT”, pattern = “TEST”
 * Output: Pattern found at index 10
 *
 * Input:  text =  “AABAACAADAABAABA”, pattern = “AABA”
 * Output: Pattern found at index 0, Pattern found at index 9, Pattern found at index 12
 * */
public class BruteForceAlgorithm {

    public static void main(String[] args) {
        // Example 1
        String txt1 = "AABAACAADAABAABA";
        String pat1 = "AABA";
        System.out.println("Example 1:");
        search(pat1, txt1);

        // Example 2
        String txt2 = "agd";
        String pat2 = "g";
        System.out.println("\nExample 2:");
        search(pat2, txt2);
    }

    private static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // A loop to slide pat[] one by one
        for (int i = 0; i <= N - M; i++) {
            int j;

            // For current index i, check for pattern match
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // If pattern matches at index i
            if (j == M) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

}
