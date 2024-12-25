package tutorial.dsa.problems.hashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Refer: https://www.geeksforgeeks.org/problems/first-repeating-element4018/1?page=1&category=Hash&sortBy=submissions
 * */
public class FirstRepeatingElement {

    public static void main(String[] args){
        int arr[] = {1, 0, 3, 4, 3, 5, 6};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("First repeated element is found at index: " + firstRepeated(arr));
    }

    public static int firstRepeated(int[] arr) {
        // Your code here
        Map<Integer, Integer> list = new LinkedHashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(list.get(arr[i]) == null){
                list.put(arr[i], i);
            }
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int n : arr){
            if(map.get(n) == null){
                map.put(n,1);
            }else{
                map.put(n,map.get(n)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>1){
                return list.get(entry.getKey())+1;
            }
        }
        return -1;
    }
}
