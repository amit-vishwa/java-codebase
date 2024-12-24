package tutorial.dsa.datastructures.strings;

/**
 * Refer: https://www.geeksforgeeks.org/camel-case-given-sentence/
 *
 * Time Complexity: O(n), where n is the length of input sentence.
 * Auxiliary Space: O(n), to store the final result.
 * */
public class CamelCaseConversion {
    static String convertToCamelCase(String s) {
        StringBuilder res = new StringBuilder();

        // Flag to indicate when to capitalize the next letter
        boolean capitalizeNext = false;

        for (int i = 0; i < s.length(); i++) {

            // If we encounter a space, set the flag to capitalize
            // the next character
            if (s.charAt(i) == ' ') {
                capitalizeNext = true;
            }

            // If the flag is set, capitalize the current character
            else if (capitalizeNext == true) {
                res.append(Character.toUpperCase(s.charAt(i)));

                // Reset the flag after capitalization
                capitalizeNext = false;
            }

            // Otherwise, just add the current character to the result
            else {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "i got intern at geeksforgeeks";
        System.out.println(convertToCamelCase(s));
    }
}