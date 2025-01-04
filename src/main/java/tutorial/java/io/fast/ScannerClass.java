package tutorial.java.io.fast;

import java.util.Scanner;

/**
 * Refer: https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/?ref=next_article
 *
 * Using Java in competitive programming is not something many people would suggest just because of its slow input and output,
 * and well indeed it is slow.
 * In this article, we have discussed some ways to get around the difficulty and change the verdict from TLE to (in most cases) AC.
 *
 * 1. Scanner Class (easy, less typing, but not recommended very slow, refer this for reasons of slowness):
 * In most of the cases, we get TLE while using scanner class. It uses built-in nextInt(), nextLong(), nextDouble methods to read
 * the desired object after initiating scanner object with the input stream(e.g. System.in). The following program many times
 * gets time limit exceeded verdict and therefore not of much use.
 * */
public class ScannerClass {

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int count = 0;
        while (n-- > 0) {
            int x = s.nextInt();
            if (x % k == 0)
                count++;
        }
        System.out.println(count);
    }

}
