package tutorial.dsa.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class EqualArrays {
    public static boolean check(int[] arr1, int[] arr2) {
        // Your code here
        if(arr1.length != arr2.length){
            return false;
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int n : arr1){
            if(map1.get(n)==null){
                map1.put(n,1);
            }else{
                map1.put(n,map1.get(n)+1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int n : arr2){
            if(map2.get(n)==null){
                map2.put(n,1);
            }else{
                map2.put(n,map2.get(n)+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            if(map1.get(entry.getKey())!=map2.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }
}
