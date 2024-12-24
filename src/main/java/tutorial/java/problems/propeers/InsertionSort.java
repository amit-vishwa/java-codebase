package tutorial.java.problems.propeers;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int n , int[] arr) {
        // Write your code here.
        for(int i = 1; i < n; i++){
            int counter = i;
            while(counter > 0){
                if(arr[counter] < arr[counter-1]){
                    int temp = arr[counter];
                    arr[counter] = arr[counter-1];
                    arr[counter-1] = temp;
                }
                --counter;
            }
        }
    }

    public static void main(String[] args){
//        int arr[] = {3,1,2,2};
        int arr[] = {1,4,2};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr.length,arr);
        System.out.println(Arrays.toString(arr));
        String abc = "asdfasd%$ op";
        System.out.println(abc.replaceAll("%$",""));
    }

}
