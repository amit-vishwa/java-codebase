package tutorial.java.string;

// Java program to demonstrate difference between
// String, StringBuilder and StringBuffer
class StringImmutableExample {

    // Method 1
    // Concatenates to String
    public static void concat1(String s1)
    {
        s1 = s1 + "forgeeks";
    }

    // Method 2
    // Concatenates to StringBuilder
    public static void concat2(StringBuilder s2)
    {
        s2.append("forgeeks");
    }

    // Method 3
    // Concatenates to StringBuffer
    public static void concat3(StringBuffer s3)
    {
        s3.append("forgeeks");
    }

    // Method 4
    // Main driver method
    public static void main(String[] args)
    {
        // Custom input string
        // String 1
        String s1 = "Geeks";

        // Calling above defined method
        concat1(s1);

        // s1 is not changed
        System.out.println("String: " + s1);

        // String 1
        StringBuilder s2 = new StringBuilder("Geeks");

        // Calling above defined method
        concat2(s2);

        // s2 is changed
        System.out.println("StringBuilder: " + s2);

        // String 3
        StringBuffer s3 = new StringBuffer("Geeks");

        // Calling above defined method
        concat3(s3);

        // s3 is changed
        System.out.println("StringBuffer: " + s3);

        /*
        Concat1: In this method, we pass a string “Geeks” and perform “s1 = s1 + ”forgeeks”.
        The string passed from main() is not changed, this is due to the fact that String is immutable.
        Altering the value of string creates another object and s1 in concat1() stores reference of the
        new string. References s1 in main() and cocat1() refer to different strings.

        Concat2: In this method, we pass a string “Geeks” and perform “s2.append(“forgeeks”)” which
        changes the actual value of the string (in main) to “Geeksforgeeks”.
        This is due to the simple fact that StringBuilder is mutable and hence changes its value.

        Concat3: StringBuilder is similar and can be compatible at all places to StringBuffer except for
        the key difference of thread safety.
        StringBuffer is thread-safe while StringBuilder does not guarantee thread safety which means
        synchronized methods are present in StringBuffer making control of one thread access at a time
        while it is not seen in StringBuilder, hence thread-unsafe.
         */
    }
}