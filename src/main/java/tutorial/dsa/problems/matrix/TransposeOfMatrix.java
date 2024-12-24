package tutorial.dsa.problems.matrix;

import java.util.Arrays;

public class TransposeOfMatrix {
    public static void main(String[] args){
        int m[][] = { { 1,1,1,1 },
                { 2,2,2,2 },
                { 3,3,3,3 },
                { 4,4,4,4 } };
        System.out.println("Given Matrix:");
        for(int i = 0; i < 4; i++)
            System.out.println(Arrays.toString(m[i]));
        transpose(m.length, m);
        System.out.println("\nTranspose of matrix:");
        for(int i = 0; i < 4; i++)
            System.out.println(Arrays.toString(m[i]));
    }
    static void transpose(int n,int a[][])
    {
        int arr[][] = new int[n][a[0].length];
        for(int i = 0; i < n; i++){
            arr[i] = Arrays.copyOf(a[i], a[i].length);
        }
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                a[j][i] = arr[i][j];
            }
        }
    }
}
