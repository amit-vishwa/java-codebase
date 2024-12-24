package tutorial.java.problems.codingninjas;

import java.util.ArrayList;
import java.util.Scanner;

class CountPrime {

    // Write your totalPrime function here
    public int totalPrime(int s, int e){
        int counter = 0;
        for(int i = s; i <= e; i++){
            boolean isPrime = true;
            if(i<=1){
                continue;
            }
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                }
            }
            if(isPrime) {
                counter++;
            }
        }
        return counter;
    }
}

class Solution {
    public static void main(String args[]) {
        CountPrime obj = new CountPrime();
//        Scanner sc = new Scanner(System.in);
//        int s = sc.nextInt();
//        int e = sc.nextInt();
        System.out.println(obj.totalPrime(2, 9));
    }
}

