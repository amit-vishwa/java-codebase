package tutorial.java.string;

// Java code to illustrate methods of StringBuilder
public class StringBuilderClassExample {
    public static void main(String[] argv)
            throws Exception
    {

        // It is not thread-safe whereas StringBuffer is thread-safe

        // create a StringBuilder object
        // with a String pass as parameter
        StringBuilder str
                = new StringBuilder("AAAABBBCCCC");

        // print string
        System.out.println("String = "
                + str.toString());

        // reverse the string
        StringBuilder reverseStr = str.reverse();

        // print string
        System.out.println("Reverse String = "
                + reverseStr.toString());

        // Append ', '(44) to the String
        str.appendCodePoint(44);

        // Print the modified String
        System.out.println("Modified StringBuilder = "
                + str);

        System.out.println("Append = " + str.append("Hello"));
        System.out.println("Insert = " + str.insert(0,"Hello"));
        System.out.println("Capacity of StringBuilder = "
                + str.capacity());
        System.out.println("Capacity of StringBuilder = "
                + str.length());
    }
}