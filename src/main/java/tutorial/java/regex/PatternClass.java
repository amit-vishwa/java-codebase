package tutorial.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Refer: https://www.geeksforgeeks.org/pattern-pattern-method-in-java-with-examples/?ref=lbp
 *
 * Pattern Class
 * This class is a compilation of regular expressions that can be used to define various types of patterns, providing no public
 * constructors. This can be created by invoking the compile() method which accepts a regular expression as the first argument,
 * thus returning a pattern after execution.
 * */
public class PatternClass {

    public static void main(String args[]){

        // Following line prints "true" because the whole
        // text "geeksforgeeks" matches pattern
        // "geeks.*"
        System.out.println(Pattern.matches("geeks.*", "geeksforgeeks"));

        // Following line prints "false" because the whole
        // text "geeks12s" doesn't match pattern "geeks[0-9]+"
        System.out.println(Pattern.matches("geeks[0-9]+", "geeks12s"));

        patternExample();
        matcherExample();
    }

    /**
     * The pattern() method of the Pattern class in Java is used to get the regular expression which is compiled to create this
     * pattern. We use a regular expression to create the pattern and this method used to get the same source expression.
     * */
    static void patternExample(){
        // create a REGEX String
        String REGEX = "(.*)(ee)(.*)?";

        // create the string
        // in which you want to search
        String actualString = "geeks";

        // create pattern
        Pattern pattern1 = Pattern.compile(REGEX);

        // find the regular expression of pattern
        String RegularExpression = pattern1.pattern();

        System.out.println("Pattern's RegularExpression = "
                + RegularExpression);
    }

    static void matcherExample(){
        String input1
                = "The quick brown fox jumps over the lazy dog";
        String input2
                = "The quick red fox jumps over the lazy dog";
        String regex = "(?i)the";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(input1);
        Matcher matcher2 = pattern.matcher(input2);
        while (matcher1.find()) {
            System.out.println("Match 1: "
                    + matcher1.group());
        }
        while (matcher2.find()) {
            System.out.println("Match 2: "
                    + matcher2.group());
        }
    }
}
