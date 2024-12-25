package tutorial.java.problems.codingninjas;

import java.util.Arrays;

/**
 *
 * Problem statement
 * You are given a square matrix of non-negative integers of size 'N x N'. Your task is to rotate that array by 90 degrees in an anti-clockwise direction without using any extra space.
 *
 * For example:
 *
 * For given 2D array :
 *
 *     [    [ 1,  2,  3 ],
 *          [ 4,  5,  6 ],
 *          [ 7,  8,  9 ]  ]
 *
 * After 90 degree rotation in anti clockwise direction, it will become:
 *
 *     [   [ 3,  6,  9 ],
 *         [ 2,  5,  8 ],
 *         [ 1,  4,  7 ]   ]
 *
 * */
public class InplaceMatrixRotate {

    public static void inplaceRotate(int[][] arr, int n) {
        // Write your code here.
        int[][] newArr = new int[n][n];
        for(int i = 0; i < n; i++){
            newArr[i] = Arrays.copyOf(arr[i],arr[i].length);
        }
        int col = n-1;
        for(int i = 0; i < n; i++){
            int row = 0;
            for(int j = 0; j < n; j++){
                arr[i][j] = newArr[row][col];
                row++;
            }
            col--;
        }
    }

    public static void main(String args[]){
        int arr[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(arr));
        inplaceRotate(arr, arr.length);
        System.out.println(Arrays.deepToString(arr));
    }
}