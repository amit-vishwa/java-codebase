package tutorial.java.problems.propeers;

import java.util.ArrayList;
import java.util.Arrays;

// This is one of practice problem
public class MinSubArray {
    public static int minSubarraySum(ArrayList<Integer> arr, int n, int k)
    {
        // Write your code here.
        int min = 0;
        int l = k;
        while(l>0){
            min += arr.get(l-1);
            l--;
        }
        for(int i = 1; i < arr.size(); i++){
            int m = k;
            int sumSubArr = 0;
            while(m>=i){
                sumSubArr += arr.get(m+i);
                m--;
            }
            if(min > sumSubArr){
                min = sumSubArr;
            }
        }
        return min;
    }
    public static void main(String... args){
//        int min = minSubarraySum(new ArrayList<>(Arrays.asList(10,4,2,5,6,3,8,1)), 8, 3);
        int min = minSubarraySum(new ArrayList<>(Arrays.asList(1,-4,2,10,-2,3,1,0,-20)), 8, 4);
        System.out.println(min);
    }
}
