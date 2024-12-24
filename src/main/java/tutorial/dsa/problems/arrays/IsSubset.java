package tutorial.dsa.problems.arrays;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/problems/array-subset-of-another-array2317/1?page=1&category=Arrays,Strings&difficulty=Basic&sortBy=submissions
 * */
public class IsSubset {
    public static void main(String args[]){
//        int a[] = {11, 7, 1, 13, 21, 3, 7, 3}, b[] = {11, 3, 7, 1, 7};
//        int a[] = {1, 2, 3, 4, 4, 5, 6}, b[] = {1, 2, 4};
//        int a[] = {10, 5, 2, 23, 19}, b[] = {19, 5, 3};
        int a[] = {474, 9, 25}, b[] = {285, 848, 529, 95, 48};
        int counter = 0;
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < a.length; j++){
                if(b[i] == a[j]){
                    a[j] = -1;
                    counter++;
                    break;
                }
            }
        }
        System.out.println(counter==b.length);

        // Another most efficient approach with O(m+n) complexity
        // Refer: https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
//        Set<Integer> set = new HashSet<>();
//        for(int element : a){
//            set.add(element);
//        }
//        for(int element : b){
//            if(!set.contains(element)){
//                return false;
//            }
//        }
//        return true;
    }
}
