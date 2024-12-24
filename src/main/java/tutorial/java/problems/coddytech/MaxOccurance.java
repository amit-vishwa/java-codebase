package tutorial.java.problems.coddytech;

import java.util.ArrayList;

// Medium level problem
public class MaxOccurance {

    public static int occurMax(int[] a) {
        // Write code here
        ArrayList<Integer> arrElList = new ArrayList<>();
        ArrayList<Integer> arrElCntList = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            if(!arrElList.contains(a[i])){
                arrElList.add(a[i]);
                arrElCntList.add(1);
            }else{
                int index = arrElList.indexOf(a[i]);
                arrElCntList.set(index,arrElCntList.get(index)+1);
            }
        }
        int maxCount = arrElCntList.stream().max(Integer::compare).get();
        return arrElList.get(arrElCntList.indexOf(maxCount));
    }

    public static void main(String[] args){
        System.out.println(occurMax(new int[]{1,2,1}));
        System.out.println(occurMax(new int[]{3, 4, 5, 6}));
        System.out.println(occurMax(new int[]{4, 2, 1, 2, 5, 2, 1, 6, 34, 1}));
        System.out.println(occurMax(new int[]{43, 12, 54, 12, 5}));
        System.out.println(occurMax(new int[]{}));
    }

}
