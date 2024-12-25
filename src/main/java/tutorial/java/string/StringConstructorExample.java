package tutorial.java.string;

// Java Program to implement String Constructor
import java.nio.charset.Charset;

class StringConstructorExample {
    // Variables in Methods
    static byte[] b_arr = {71, 101, 101, 107, 115};
    static Charset cs = Charset.defaultCharset();
    static char[] char_arr = {'G', 'e', 'e', 'k', 's'};
    static int[] uni_code = {71, 101, 101, 107, 115};
    static StringBuffer s_buffer = new StringBuffer("Geeks");
    static StringBuilder s_builder = new StringBuilder("Geeks");

    public static void main(String[] args) {
        // Method 1
        String s1 = new String(b_arr);
        System.out.println("Method 1: " + s1);
        System.out.println();

        // Method 2
        String s2 = new String(b_arr, cs);
        System.out.println("Method 2: " + s2);
        System.out.println();

        // This is alternative way for Method 2
        String s3 = new String(b_arr, Charset.forName("US-ASCII"));
        System.out.println("Method 2 Alternative: " + s3);
        System.out.println();

        // Method 3
        String s4 = new String(b_arr, 1, 3);
        System.out.println("Method 3: " + s4);
        System.out.println();

        // Method 4
        String s5 = new String(b_arr, 1, 3, cs);
        System.out.println("Method 4: " + s5);
        System.out.println();

        // This is alternative way for Method 4
        String s6 = new String(b_arr, 1, 4, Charset.forName("US-ASCII"));
        System.out.println("Method 4 Alternative: " + s6);
        System.out.println();

        // Method 5
        String s7 = new String(char_arr);
        System.out.println("Method 5: " + s7);
        System.out.println();

        // Method 6
        String s8 = new String(char_arr, 1, 3);
        System.out.println("Method 6: " + s8);
        System.out.println();

        // Method 7
        String s9 = new String(uni_code, 1, 3);
        System.out.println("Method 7: " + s9);
        System.out.println();

        // Method 8
        String s10 = new String(s_buffer);
        System.out.println("Method 8: " + s10);
        System.out.println();

        // Method 9
        String s11 = s_builder.toString();
        System.out.println("Method 9: " + s11);
        System.out.println();
    }
}