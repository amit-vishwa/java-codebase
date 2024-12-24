package tutorial.java.problems.propeers;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int arr[], int n) {
        // Write your code here.
        for(int i = 0; i < n-1; i++){
            int min = arr[i];
            int index = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            if(min != arr[i]){
                int temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }
    }

    public static void main(String... args){
        int arr[] = {6,2,8,4,10};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
