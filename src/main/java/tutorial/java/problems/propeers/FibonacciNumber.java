package tutorial.java.problems.propeers;

public class FibonacciNumber {

    public static int fibonacciNumber(int n){
        // Write your code here.
        int mod = 1000000007;
        int a = 0, b = 1;
        int res = 0;
        if(n < 2) return 1;
        for(int i = 2; i <= n; i++){
            res = a + b;
            a = b;
            b = res;
            if(b > mod){
                b = b - mod;
            }
        }
        return b;
    }

    // traditional approach
//    public static int fibonacciNumber(int n){
//        // Write your code here.
//        if(n < 2) return 1;
//        int[] arr = new int[n+1];
//        arr[0] = 0;
//        arr[1] = 1;
//        for(int i = 2; i <= n; i++){
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//        return arr[n];
//    }

    public static void main(String args[]){
        System.out.println(fibonacciNumber(95));
        System.out.println(fibonacciNumber(93));
        System.out.println(fibonacciNumber(22));
        System.out.println(fibonacciNumber(9));
    }

}
