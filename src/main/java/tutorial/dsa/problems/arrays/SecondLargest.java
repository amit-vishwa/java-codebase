package tutorial.dsa.problems.arrays;

// Refer: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/second-largest3735

public class SecondLargest {

    public static void main(String... args){
        System.out.println(getSecondLargest(new int[]{12, 35, 1, 10, 34, 1}));
        System.out.println(getSecondLargest(new int[]{10, 5, 10}));
        System.out.println(getSecondLargest(new int[]{10, 10, 10}));
        System.out.println(getSecondLargest(new int[]{28078, 19451, 935, 28892, 2242, 3570, 5480, 231}));
    }

    public static int getSecondLargest(int[] arr) {
        // Code Here

        // Approach 1 with time complexity O(n*logn)
        // int n = arr.length;
        // Arrays.sort(arr);
        // int largest = arr[n-1];
        // for(int i = n-2; i>=0; i--){
        //     if(arr[i]!=largest){
        //         return arr[i];
        //     }
        // }
        // return -1;

        // Approach 2 with time complexity O(2*n)
        // int n = arr.length;
        // int largest = -1;
        // int secondLargest = -1;
        // for(int i = 0; i<n; i++){
        //     if(arr[i]>largest){
        //         largest = arr[i];
        //     }
        // }
        // for(int i = 0; i < n; i++){
        //     if(arr[i]>secondLargest && arr[i]!=largest){
        //         secondLargest = arr[i];
        //     }
        // }
        // return secondLargest;

        // Approach 3 with time complexity O(n)
        int n = arr.length;
        int largest = -1;
        int secondLargest = -1;
        for(int i = 0; i<n; i++){
            if(arr[i]>largest){
                // update second largest if largest is getting updated
                secondLargest = largest;
                largest = arr[i];
            }
            if(arr[i]>secondLargest && arr[i]<largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
