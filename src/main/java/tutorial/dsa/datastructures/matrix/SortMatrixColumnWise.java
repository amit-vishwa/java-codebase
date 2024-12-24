package tutorial.dsa.datastructures.matrix;

import java.util.Arrays;

/**
 *
 * Refer: https://www.geeksforgeeks.org/sort-the-matrix-column-wise/
 *
 * Time Complexity: O(N * M)
 * Auxiliary Space: O(N * M)
 *
 * */
public class SortMatrixColumnWise {
    public static void main(String[] args)
    {
        // Input
        int[][] mat = { { 1, 6, 10 },
                { 8, 5, 9 },
                { 9, 4, 15 },
                { 7, 3, 60 } };
        int N = mat.length;
        int M = mat[0].length;
        System.out.println("Given Matrix:");
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(mat[i]));
        System.out.println("\nSorted matrix column-wise:");
        // Function call to print the matrix in column wise sorted manner
        sortCol(mat, N, M);
    }

    // Function to find the transpose of the matrix mat[]
    static int[][] transpose(int[][] mat, int row,
                             int col)
    {
        // Stores the transpose of matrix mat[][]
        int[][] tr = new int[col][row];
        // Traverse each row of the matrix
        for(int i = 0; i < row; i++)
        {
            // Traverse each column of the matrix
            for(int j = 0; j < col; j++)
            {
                // Transpose matrix elements
                tr[j][i] = mat[i][j];
            }
        }
        return tr;
    }

    // Function to sort the given matrix in row wise manner
    static void RowWiseSort(int[][] B)
    {
        // Traverse the row
        for(int i = 0; i < B.length; i++)
        {
            // Row - Wise Sorting
            Arrays.sort(B[i]);
        }
    }

    // Function to print the matrix in column wise sorted manner
    static void sortCol(int[][] mat, int N, int M)
    {
        // Function call to find transpose of the matrix mat[][]
        int[][] B = transpose(mat, N, M);
        System.out.println("1.Transpose of given matrix:");
        for(int i = 0; i < M; i++)
            System.out.println(Arrays.toString(B[i]));
        // Sorting the matrix row-wise
        RowWiseSort(B);
        System.out.println("\n2.Row wise sort of transpose matrix:");
        for(int i = 0; i < M; i++)
            System.out.println(Arrays.toString(B[i]));
        // Calculate transpose of B[][]
        mat = transpose(B, M, N);
        System.out.println("\n3.Column wise sorted matrix:");
        // Print the matrix mat[][]
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
