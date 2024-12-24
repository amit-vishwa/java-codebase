package tutorial.java.problems.codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * Problem statement
 * You have been given an array/list of integers 'ARR' of size 'N'. Your task is to find two things-
 *
 * 1. The number of elements that are occurring an Odd number of times.
 *
 * 2. The number of elements that are occurring Even a number of times.
 *
 * For Example:
 * ARR = [2, 1, 2, 1, 5, 5, 2]
 * Output: 1 2
 *
 * 2 occurs three(odd) times.
 * 1 occurs two(even) times.
 * 5 occurs two(even) times.
 *
 * So, the total 1 element is occurring an odd number of times and 2 elements are occurring an even number of times.
 * 
 *
 * Sample Input 1:
 * 2
 * 5
 * 4 5 1 2 1
 * 4
 * 2 1 2 1
 * Sample Output 1:
 * 3 1
 * 0 2
 * Explanation for Sample 1:
 * In the first test case, three integers(4, 5 and 2) occur odd times and the only integer 1 occurs even times.
 *
 * In the second test case, no integer occurs odd times and two integers(1 and 2) occurs even times.
 * */
public class CountEvenOdd {
    public static int[] countEvenOdd(int[] arr, int n) {
        // Write your code here.
        ArrayList<Integer> arrCopy = new ArrayList<>();
        for(int num : arr){
            arrCopy.add(num);
        }
        Map<Integer, Long> map = arrCopy.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        ArrayList<Integer> evenOccurrence = new ArrayList<>();
        ArrayList<Integer> oddOccurrence = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : map.entrySet()){
            if(entry.getValue()%2==0){
                evenOccurrence.add(entry.getKey());
            }else{
                oddOccurrence.add(entry.getKey());
            }
        }
//        System.out.println(map);
        return new int[]{oddOccurrence.size(),evenOccurrence.size()};
    }

    public static void main(String args[]){
        int arr[] = new int[]{2, 1, 2, 1, 5, 5, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(countEvenOdd(arr,arr.length)));
//        System.out.println(Arrays.toString(countEvenOdd(new int[]{2, 1, 2, 1, 5, 5, 2},7)));

        arr = new int[]{4, 5, 1, 2, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(countEvenOdd(arr,arr.length)));
//        System.out.println(Arrays.toString(countEvenOdd(new int[]{4,5,1,2,1},5)));

        arr = new int[]{2, 1, 2, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(countEvenOdd(arr,arr.length)));
//        System.out.println(Arrays.toString(countEvenOdd(new int[]{2,1,2,1},4)));
    }
}
