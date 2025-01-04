package tutorial.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Refer: https://www.geeksforgeeks.org/matcher-pattern-method-in-java-with-examples/?ref=lbp
 *
 * Matcher class
 * This object is used to perform match operations for an input string in Java, thus interpreting the previously explained
 * patterns. This too defines no public constructors. This can be implemented by invoking a matcher() on any pattern object.
 *
 * Note: T Pattern.matches() checks if the whole text matches with a pattern or not. Other methods (demonstrated below) are
 * mainly used to find multiple occurrences of patterns in the text.
 * */
public class MatcherClass {

    public static void main(String args[])
    {

        // Create a pattern to be searched
        // Custom pattern
        Pattern p = Pattern.compile("geeks");

        // Search above pattern in "geeksforgeeks.org"
        Matcher m = p.matcher("geeksforgeeks.org");

        // Finding string using find() method
        while (m.find())

            // Print starting and ending indexes
            // of the pattern in the text
            // using this functionality of this class
            System.out.println("Pattern found from "
                    + m.start() + " to "
                    + (m.end() - 1));

        matcherPattern();
    }

    static void matcherPattern(){
        // Get the regex to be checked
        String regex = "Geeks";

        // Create a pattern from regex
        Pattern pattern
                = Pattern.compile(regex);

        // Get the String to be matched
        String stringToBeMatched
                = "GeeksForGeeks";

        // Create a matcher for the input String
        Matcher matcher
                = pattern.matcher(stringToBeMatched);

        // Get the Pattern using pattern() method
        System.out.println("Pattern: "
                + matcher.pattern());
    }

}
