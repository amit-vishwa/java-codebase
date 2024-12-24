package tutorial.dsa.datastructures.matrix;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/row-wise-sorting-2d-array/
 * */
public class SortMatrixRowWise {
    public static void main(String args[])
    {
        int m[][] = { { 9, 8, 7, 1 },
                { 7, 3, 0, 2 },
                { 9, 5, 3, 2 },
                { 6, 3, 1, 2 } };
        System.out.println("Given Matrix:");
        for(int i = 0; i < 4; i++)
            System.out.println(Arrays.toString(m[i]));
        System.out.println("\nSorted matrix row-wise using bubble sort:");
        sortUsingBubbleSort(m);
        System.out.println("\nSorted matrix row-wise using library function:");
        sortUsingLibraryFunction(m);
    }

    /**
     * Method 1 (Using Bubble Sort): Start iterating through each row of the given 2D array,
     * and sort elements of each row using an efficient sorting algorithm
     *
     * Time Complexity: O(r*c*max(r,c))
     * Auxiliary Space: O(1), since no extra space has been taken.
     * */
    static void sortUsingBubbleSort(int m[][])
    {
        // loop for rows of matrix
        for (int i = 0; i < m.length; i++) {
            // loop for column of matrix
            for (int j = 0; j < m[i].length; j++) {
                // loop for comparison and swapping
                for (int k = 0; k < m[i].length - j - 1; k++) {
                    if (m[i][k] > m[i][k + 1]) {
                        // swapping of elements
                        int t = m[i][k];
                        m[i][k] = m[i][k + 1];
                        m[i][k + 1] = t;
                    }
                }
            }
        }

        // printing the sorted matrix
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }

    /**
     * Method 2 (Using Library Function): The idea is to use Arrays.sort() for every row of the matrix.
     *
     * Time Complexity: O(r*c*log(c))
     * Auxiliary Space: O(1)
     * */
    static void sortUsingLibraryFunction(int m[][])
    {
        // One by one sort individual rows.
        for (int i = 0; i < m.length; i++)
            Arrays.sort(m[i]);
        // printing the sorted matrix
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }
}
