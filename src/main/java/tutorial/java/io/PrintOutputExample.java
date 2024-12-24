package tutorial.java.io;

import java.util.Date;

public class PrintOutputExample {

    public static void main(String... args){

        System.out.println("This print statement add a new line at end");
        System.out.print("This print statement will not add any line");

        // standard international numbering
        System.out.printf("\n%,d%n",10000000);

        // formatted printing decimal number, only print specified numbers after decimal
        System.out.printf("%f\n", 12423.435454);
        System.out.printf("%1.3f\n", 12423.435454);

        // printing boolean
        System.out.printf("%b\n", 10);
        System.out.printf("%B\n", true);
        System.out.printf("%b\n", false);
        System.out.printf("%B\n", null);

        // character formatting
        System.out.printf("%c\n", 'g');
        System.out.printf("%C\n", 'g');

        // Formatting from lowercase to uppercase
        System.out.printf("%s\n", "geeksforgeeks");
        System.out.printf("%S\n", "geeksforgeeks");
        // Vice-versa not possible
        System.out.printf("%S\n", "GFG");
        System.out.printf("%s\n", "GFG");

        // formatting time
        System.out.printf("Current Time: %tT\n", new Date());
        System.out.printf("Hours: %tH  Minutes: %tM Seconds: %tS\n",
                new Date(),new Date(),new Date());
        System.out.printf("%1$tH:%1$tM:%1$tS %1$tp %1$tL %1$tN %1$tz %n",
                new Date());
    }

}
