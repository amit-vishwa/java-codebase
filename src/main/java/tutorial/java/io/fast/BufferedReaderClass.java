package tutorial.java.io.fast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Refer: https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/?ref=next_article
 *
 * 2. BufferedReader (fast, but not recommended as it requires a lot of typing):
 * The Java.io.BufferedReader class reads text from a character-input stream, buffering characters to provide for the efficient
 * reading of characters, arrays, and lines. With this method, we will have to parse the value every time for the desired type.
 * Reading multiple words from a single line adds to its complexity because of the use of Stringtokenizer and hence this is not
 * recommended. These get accepted with a running time of approx 0.89 s.but still as you can see it requires a lot of typing
 * altogether and therefore method 3 is recommended.
 * */
public class BufferedReaderClass {

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int count = 0;
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x % k == 0)
                count++;
        }
        System.out.println(count);
    }

}
