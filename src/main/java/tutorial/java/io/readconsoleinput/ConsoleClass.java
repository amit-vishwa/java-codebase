package tutorial.java.io.readconsoleinput;

/**
 * Refer: https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/?ref=next_article
 *
 * 3. Using Console Class
 * It has been becoming a preferred way for reading user’s input from the command line, Introduced in JDK 1.6. In addition, it
 * can be used for reading password-like input without echoing the characters entered by the user; the format string syntax can
 * also be used (like System.out.printf()).
 *
 * Advantages:
 * - Reading password without echoing the entered characters.
 * - Reading methods are synchronized.
 * - Format string syntax can be used.
 * - Does not work in non-interactive environment (such as in an IDE).
 * */
public class ConsoleClass {
    // Java program to demonstrate working of System.console()
    // Note that this program does not work on IDEs as System.console() may require console
    public static void main(String[] args)
    {
        // Using Console to input data from user
        String name = System.console().readLine();

        System.out.println("You entered string " + name);
    }
}
