package tutorial.java.io.readconsoleinput;

/**
 * Refer: https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/?ref=next_article
 *
 * 4. Using Command line argument
 * Most used user input for competitive coding available right from the initial release of Java (JDK 1.0). The command-line
 * arguments are stored in the String format. The parseInt method of the Integer class converts string argument into Integer.
 * Similarly, for float and others during execution. The usage of args[] comes into existence in this input form. The passing
 * of information takes place during the program run. The command line is given to args[]. These programs have to be run on cmd.
 * */
public class CommandLineArgument {

    public static void main(String[] args)
    {
        // check if length of args array is
        // greater than 0
        if (args.length > 0) {
            System.out.println("The command line arguments are:");

            // iterating the args array and printing
            // the command line arguments
            for (String val : args)
                System.out.println(val);
        }
        else
            System.out.println("No command line arguments found.");
    }

}
