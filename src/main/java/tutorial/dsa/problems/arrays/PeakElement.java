package tutorial.dsa.problems.arrays;

/**
 * Refer: https://www.geeksforgeeks.org/problems/peak-element/1?page=1&difficulty=Basic&sortBy=submissions
 * */
public class PeakElement {
    public static void main(String... args){
        StringBuilder sb = new StringBuilder();
        sb.reverse();

        System.out.println(peakElement(new int[]{1, 2, 4, 5, 7, 8, 3}));
    }

    public static int peakElement(int[] arr) {
        // code here
        int n = arr.length;
        if(n < 2){
            return 0;
        }
        for(int i = 0; i < n; i++){
            if(i == 0 && arr[i]>arr[i+1]){
                return i;
            }else if(i == n-1 && arr[i]>arr[i-1]){
                return i;
            }else if(i > 0 && i < n-1 && arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                return i;
            }
        }
        return -1;
    }
}
