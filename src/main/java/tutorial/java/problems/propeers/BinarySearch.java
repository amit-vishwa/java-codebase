package tutorial.java.problems.propeers;

public class BinarySearch {

    public static int search(int []nums, int target) {
        // Write your code here.
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            // update mid index with new start and end values
            int mid = (start + end) / 2;
            // if target found, return index
            if(target == nums[mid]){
                return mid;
            }
            // if target less than mid index, reduce end
            if(target < nums[mid]){
                end = mid-1;
            }
            // if target greater than mid index, increase start
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String... args){
        int index = search(new int[]{1,3,7,9,11,12,45},3);
        int index1 = search(new int[]{1,2,3,4,5,6,7},9);
        int index2 = search(new int[]{3,12,18,28,29,30,35,36,40,45},3);
        int index3 = search(new int[]{6,12,13,14,16,18,20,28,35,42,44,47},40);
        System.out.println(index);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
    }
}
