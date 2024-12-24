package tutorial.java.string;

import java.util.Arrays;

// Java code to illustrate different constructors and methods in String class
class StringMethodExample
{
    public static void main (String[] args)
    {
        String s= "GeeksforGeeks";
        // or String s= new String ("GeeksforGeeks");

        // Returns the number of characters in the String.
        System.out.println("String length = " + s.length());

        // Returns the character at ith index.
        System.out.println("Character at 3rd position = "
                + s.charAt(3));

        // Return the substring from the ith  index character
        // to end of string
        System.out.println("Substring " + s.substring(3));

        // Returns the substring from i to j-1 index.
        System.out.println("Substring  = " + s.substring(2,5));

        // Concatenates string2 to the end of string1.
        String s1 = "Geeks";
        String s2 = "forGeeks";
        System.out.println("Concatenated string  = " +
                s1.concat(s2));

        // Returns the index within the string
        // of the first occurrence of the specified string.
        String s4 = "Learn Share Learn";
        System.out.println("Index of Share " +
                s4.indexOf("Share"));

        // Returns the index within the string of the
        // first occurrence of the specified string,
        // starting at the specified index.
        System.out.println("Index of a  = " +
                s4.indexOf('a',3));

        // Checking equality of Strings
        String str = "Geeks";
        System.out.println("Checking Equality  " + str.equals("geeks"));
        System.out.println("Checking Equality  " + str.equals("Geeks"));
        System.out.println("Checking Equality " + str.equalsIgnoreCase("gEeks"));

        //If ASCII difference is zero then the two strings are similar
        int out1 = s1.compareTo(s2);
        System.out.println("the difference between ASCII value is="+out1);
        // Converting cases
        String w1 = "GeeKyMe";
        System.out.println("Changing to lower Case " +
                w1.toLowerCase());

        // Converting cases
        String w2 = "GeekyME";
        System.out.println("Changing to UPPER Case " +
                w2.toUpperCase());

        // Trimming the word
        String w4 = " Learn Share Learn ";
        System.out.println("Trim the word " + w4.trim());

        // Replacing characters
        String str1 = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String str2 = "feeksforfeeks".replace('f' ,'g') ;
        System.out.println("Replaced f with g -> " + str2);

        // Contains characters
        System.out.println("Is f present in str1 " + str1.contains("f"));

        // To character array
        System.out.println("Fetching character array " + str1.toCharArray()[0]);

        // Does character start with g
        System.out.println("Is f present in str1 " + str1.startsWith("g"));
    }
}