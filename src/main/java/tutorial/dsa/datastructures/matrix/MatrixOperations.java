package tutorial.dsa.datastructures.matrix;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-matrix-or-grid-data-structure-and-algorithms-tutorial/
 *
 * Matrix or Grid is a two-dimensional array mostly used in mathematical and scientific calculations.
 * It is also considered as an array of arrays, where array at each index has the same size.
 * */
public class MatrixOperations {
    public static void main(String[] args){
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        accessElement(arr,1,2);
        traverseMatrix(arr,3,3);
        searchMatrix(arr,3,3, 9);
    }

    /**
     * 1. Access elements of Matrix Data Structure:
     * Like one-dimensional arrays, matrices can be accessed randomly by using their indices to access the
     * individual elements. A cell has two indices, one for its row number, and the other for its column number.
     * We can use arr[i][j] to access the element which is at the ith row and jth column of the matrix.
     * */
    private static void accessElement(int[][] arr, int row, int col){
        System.out.println("Element at row "+row+" and column "+col+" is " + arr[row-1][col-1]);
    }

    /**
     * 2. Traversal of a Matrix Data Structure:
     * We can traverse all the elements of a matrix or two-dimensional array by using two for-loops.
     * */
    private static void traverseMatrix(int[][] arr, int row, int col){
        for (int i = 0; i < row; i++) {
            // Traversing over all the columns of each row
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 3. Searching in a Matrix Data Structure:
     * We can search an element in a matrix by traversing all the elements of the matrix.
     *
     * Below is the implementation to search an element in a matrix:
     * */
    private static void searchMatrix(int[][] arr, int row, int col, int key){
        for (int i = 0; i < row; i++) {
            // Traversing over all the columns of each row
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == key){
                    System.out.println(key+" found at row "+(i+1)+" and column "+(j+1));
                    return;
                }
            }
        }
    }

}
