package tutorial.java.problems.coddytech;

import java.util.Arrays;

public class NumToArray {

    public static int[] convert(int n) {
        // Write code here
        String str = "" + n;
        int arr[] = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return arr;
    }

    public static void main(String... args){
        System.out.println(Arrays.toString(convert(123)));
        System.out.println(Arrays.toString(convert(6)));
        System.out.println(Arrays.toString(convert(21381)));
    }

}
