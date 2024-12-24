package tutorial.dsa.algorithms.mathematical.primenumbers;

/**
 * Refer: https://www.geeksforgeeks.org/sieve-of-eratosthenes/
 * Time Complexity: O(N*log(log(N)))
 * Auxiliary Space: O(N)
 * */
public class SieveOfEratosthenes {
    void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and
        // initialize all entries it as true. A value in
        // prime[i] will finally be false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p greater than or
                // equal to the square of it numbers which
                // are multiple of p and are less than p^2
                // are already been marked.
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }

    // Implementation 2 of same above approach with O(n) for n less than equal to 100
    void sieveOfEratosthenes2(int n)
    {
        // mark all number as prime
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
        // iterate from 2 till number
        for (int p = 2; p <= n; p++) {
            // if 1 digit prime number then skip
            if(p<8 && (p==2 || p==3 || p==5 || p==7)){
                continue;
            }
            // if multiples of 1 digit prime number, then mark as non-prime
            if(p%2==0 || p%3==0 || p%5==0 || p%7==0){
                prime[p] = false;
            }
        }
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        System.out.println("Following are the prime numbers ");
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(100);
        System.out.println();
        g.sieveOfEratosthenes2(30);
    }
}
