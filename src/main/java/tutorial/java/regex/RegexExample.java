package tutorial.java.regex;

import java.util.regex.Pattern;

/**
 * Refer: https://www.geeksforgeeks.org/regular-expressions-in-java/?ref=lbp
 *
 * In Java, Regular Expressions or Regex (in short) in Java is an API for defining String patterns that can be used for searching,
 * manipulating, and editing a string in Java. Email validation and passwords are a few areas of strings where Regex is widely
 * used to define the constraints. Regular Expressions in Java are provided under java.util.regex package.
 *
 * Conclusion
 * Lastly, let us do discuss some of the important observations as retrieved from the above article
 * - We create a pattern object by calling Pattern.compile(), there is no constructor. compile() is a static method in the Pattern class.
 * - Like above, we create a Matcher object using matcher() on objects of the Pattern class.
 * - Pattern.matches() is also a static method that is used to check if a given text as a whole matches the pattern or not.
 * - find() is used to find multiple occurrences of patterns in the text.
 * - We can split a text based on a delimiter pattern using the split() method
 * */
public class RegexExample {

    public static void main(String args[]){

        matchExample();
        characterClasses();
        metaCharacters();
        regexFinder();

    }

    static void matchExample(){
        // Following line prints "true" because the whole
        // text "geeksforgeeks" matches pattern
        // "geeksforge*ks"
        System.out.println("Does geeksforge*ks match geeksforgeeks : " + Pattern.matches(
                "geeksforge*ks", "geeksforgeeks"));

        // Following line prints "false" because the whole
        // text "geeksfor" doesn't match pattern "g*geeks*"
        System.out.println("Does g*geeks* match geeksfor : " + Pattern.matches(
                "g*geeks*", "geeksfor"));
    }

    static void characterClasses(){
        {
            // Checks if the string matches with the regex
            // Should be single character a to z
            System.out.println("Does [a-z] match g : " + Pattern.matches("[a-z]",
                    "g"));
            // Check if the element is range a to z or A to Z
            System.out.println("Does [a-zA-Z] match Gfg : " + Pattern.matches("[a-zA-Z]",
                    "Gfg"));
        }
    }

    static void metaCharacters(){
        // Checking all the strings using regex
        System.out.println("Does [b-z]? match a : " + Pattern.matches("[b-z]?",
                "a"));

        // Check if all the elements are in range a to z
        // or A to Z
        System.out.println("Does [a-zA-Z]+ match GfgTestCase : " + Pattern.matches("[a-zA-Z]+",
                "GfgTestCase"));

        // Check if elements is not in range a to z
        System.out.println("Does [^a-z]? match g : " + Pattern.matches("[^a-z]?",
                "g"));

        // Check if all the elements are either g,e,k or s
        System.out.println("Does [geks]* match geeksgeeks : " + Pattern.matches("[geks]*",
                "geeksgeeks"));

    }

    static void regexFinder(){
        // Check if all elements are numbers
        System.out.println("Does \\d+ match 1234 : " + Pattern.matches("\\d+", "1234"));

        // Check if all elements are non-numbers
        System.out.println("Does \\D+ match 1234 : " + Pattern.matches("\\D+", "1234"));

        // Check if all the elements are non-numbers
        System.out.println("Does \\D+ match Gfg : " + Pattern.matches("\\D+", "Gfg"));

        // Check if all the elements are non-spaces
        System.out.println("Does \\S+ match gfg : " + Pattern.matches("\\S+", "gfg"));
    }

}
