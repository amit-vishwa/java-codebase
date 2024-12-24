package tutorial.dsa.datastructures.strings;

/**
 * Refer: https://www.geeksforgeeks.org/basic-string-operations-with-implementation/
 *
 * */
public class BasicOperations {

    public static void main(String[] args) {
        // 1.Accessing characters by index in a string
        System.out.println("1.Accessing characters by index in a string:");
        accessCharByIndex();

        // 2.Inserting Character/String into a String
        System.out.println("\n2.Inserting Character/String into a String:");
        insertDemo();

        // 3.Modifying character in String
        System.out.println("\n3.Modifying character in String:");
        modifyCharacterInString();

        // 4.Deletion of character in String
        System.out.println("\n4.Deletion of character in String:");
        removeChar();

        // 5.Concatenating strings (combining multiple strings into one).
        System.out.println("\n5.Concatenating strings (combining multiple strings into one):");
        concatenateString();

        // 6.Finding the length/size of a string
        System.out.println("\n6.Finding the length/size of a string:");
        stringLength();

        // 7.Comparing Strings for Equality
        System.out.println("\n7.Comparing Strings for Equality:");
        compareStrings("geeks", "forGeeks");
        compareStrings("geeks", "geeks");

    }

    /**
     * 1.Accessing characters by index in a string.
     * To access any character in a String, we need:
     *
     * A non-empty string (say “s”)
     * A position/index of the character from where it is to be accessed. (say “k”)
     * Using these two, the character can be easily accessed using the below syntax:
     *
     * char ch = s[k];
     * OR
     * char ch = s.charAt(k);
     * */
    public static void accessCharByIndex() {
        String str = "GeeksforGeeks ";
        int index = 4;
        System.out.println("Accessed "+index+"th index from string '"+str+"' is: "+str.charAt(index));
    }

    /**
     * 2.Inserting Character/String into an String.
     * To insert any Character/String in a String, we need:
     *
     * A character/string that is to be inserted in the string (say “ch”)
     * A position/index of the Character/String where it is to be inserted. (say “k”)
     * */
    public static void insertDemo() {
        // Inserts ch at kth index of str
        String str = "GeeksGeeks ";
        String ch = "for";
        int index = 5;
        StringBuilder sb = new StringBuilder(str);
        sb.insert(index, ch);
        String modifiedString = sb.toString();
        System.out.println("Inserted character '" + ch + "' at index " + index + " in string '" + str + "' and got: " + modifiedString);
    }

    /**
     * 3.Modifying character in String
     * To modify any Character in a String, we need:
     *
     * A character that is to replaced in the string (say “ch”)
     * A position/index of the Character where it is to be replaced at. (say “k”)
     * */
    public static void modifyCharacterInString() {
        // Get the String
        String s = "Geeks Gor Geeks";
        // Get the index
        int index = 6;
        // Get the character
        char ch = 'F';
        // Print the original string
        System.out.print("Inserted character '" + ch + "' at index " + index + " in string '" + s + "' and got: ");
        s = s.substring(0, index) + ch
                + s.substring(index + 1);
        // Print the modified string
        System.out.println(s);
    }

    /**
     * 4.Deletion of character in String
     * To delete any Character in a String, we need:
     *
     * A character that is to deleted in the string (say “ch”)
     * */
    public static void removeChar() {
        StringBuilder s = new StringBuilder("geeksforgeeks");
        char c = 'g';
        System.out.print("Removed character '" + c + "' from string '" + s + "' and got: ");
        int j = 0;
        // Loop through the StringBuilder
        for (int i = 0; i < s.length(); i++) {
            // If the current character is not the one to be removed
            if (s.charAt(i) != c) {
                // Move the character to the position indicated by j
                s.setCharAt(j++, s.charAt(i));
            }
        }
        // Delete the remaining characters
        s.delete(j, s.length());
        System.out.println(s);
    }

    /**
     * 5.Concatenating strings (combining multiple strings into one).
     * To concatenate any String to a String, we need:
     *
     * A string that is to appended with the string (say “ch”)
     * */
    public static void concatenateString(){
        String init = "this is init";
        String add = " added now";
        System.out.print("Adding string '" + add + "' to string '" + init + "' to get: ");
        // Appending the string using string literals
        // init = init + add;
        // Concatenating the string using concat()
        init = init.concat(add);
        System.out.println(init);
    }

    /**
     * 6.Finding the length/size of a string
     * To find the length of the String, we need:
     *
     * A string for which the length/size is to be determined (say “str”)
     * */
    public static void stringLength() {
        // String object
        String str = "GeeksforGeeks";
        // Size of string object using length() method
        System.out.println("Length of string '"+str+"' is "+str.length());
    }

    // 7.Comparing Strings for Equality
    public static void compareStrings(String s1, String s2) {
        // comparing both using inbuilt function
        int x = s1.compareTo(s2);
        if (x != 0) {
            System.out.println(s1 + " is not equal to " + s2);
            if (x > 0) {
                System.out.println(s1 + " is greater than " + s2);
            } else {
                System.out.println(s2 + " is greater than " + s1);
            }
        } else {
            System.out.println(s1 + " is equal to " + s2);
        }
    }

}
