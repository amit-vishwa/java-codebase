package tutorial.dsa.algorithms.patternsearching;

/**
 * Refer: https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
 *
 * Rabin-Karp Algorithm:
 * In the Naive String Matching algorithm, we check whether every substring of the text of the pattern’s size is
 * equal to the pattern or not one by one.
 * Like the Naive Algorithm, the Rabin-Karp algorithm also check every substring. But unlike the Naive algorithm, the Rabin
 * Karp algorithm matches the hash value of the pattern with the hash value of the current substring of text, and if the hash
 * values match then only it starts matching individual characters. So Rabin Karp algorithm needs to calculate hash values for
 * the following strings.
 * - Pattern itself
 * - All the substrings of the text of length m which is the size of pattern.
 *
 * Step-by-step approach:
 * - Initially calculate the hash value of the pattern.
 * - Start iterating from the starting of the string:
 *   -> Calculate the hash value of the current substring having length m.
 *   -> If the hash value of the current substring and the pattern are same check if the substring is same as the pattern.
 *   -> If they are same, store the starting index as a valid answer. Otherwise, continue for the next substrings.
 * - Return the starting indices as the required answer.
 *
 * Time Complexity:
 * The average and best-case running time of the Rabin-Karp algorithm is O(n+m), but its worst-case time is O(nm).
 * The worst case of the Rabin-Karp algorithm occurs when all characters of pattern and text are the same as the hash values of all the substrings of T[] match with the hash value of P[].
 *
 * Auxiliary Space: O(1)
 *
 * Limitations of Rabin-Karp Algorithm
 * Spurious Hit: When the hash value of the pattern matches with the hash value of a window of the text but the window is not
 * the actual pattern then it is called a spurious hit. Spurious hit increases the time complexity of the algorithm. In order
 * to minimize spurious hit, we use good hash function. It greatly reduces the spurious hit.
 * */
public class RobinKarpAlgorithm {

    // d is the number of characters in the input alphabet
    public final static int d = 256;

    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    static void search(String pat, String txt, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    System.out.println(
                            "Pattern found at index " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h)
                        + txt.charAt(i + M))
                        % q;

                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    /* Driver Code */
    public static void main(String[] args)
    {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";

        // A prime number
        int q = 101;

        // Function Call
        search(pat, txt, q);
    }
}
