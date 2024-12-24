package tutorial.dsa.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/types-of-arrays/
 *
 * There are majorly 4 types of arrays
 * 1. Fixed Size Array
 * 2. Dynamic Sized Array
 * 3. 1-Dimensional Array
 * 4. Multi-Dimensional Array
 *
 * Classification of Types of Arrays
 * However, these array types can be broadly classified in two ways:
 * On the basis of Size
 * On the basis of Dimensions
 * */
public class ArrayTypes {
    public static void main(String[] args){
        /**
         * 1. Fixed Sized Arrays:
         * We cannot alter or update the size of this array. Here only a fixed size
         * (i,e. the size that is mentioned in square brackets []) of memory will be allocated for storage.
         * In case, we don’t know the size of the array then if we declare a larger size and store a
         * lesser number of elements will result in a wastage of memory or we declare a lesser size than
         * the number of elements then we won’t get enough memory to store all the elements. In such cases,
         * static memory allocation is not preferred.
         * */
        int[] fixedSizeArray = {1,2,3,4,5};
        System.out.println("Fixed size array: "+Arrays.toString(fixedSizeArray));

        /**
         * 2. Dynamic Sized Arrays:
         * The size of the array changes as per user requirements during execution of code so the coders
         * do not have to worry about sizes. They can add and removed the elements as per the need.
         * The memory is mostly dynamically allocated and de-allocated in these arrays.
         * */
        ArrayList<Integer> dynamicSizeArray = new ArrayList<>();
        dynamicSizeArray.add(1);
        dynamicSizeArray.add(2);
        dynamicSizeArray.add(3);
        dynamicSizeArray.add(4);
        dynamicSizeArray.add(5);
        System.out.println("Dynamic size array: "+Arrays.toString(fixedSizeArray));

        /**
         * 3. One-dimensional array (1-D arrays):
         * You can imagine a 1d array as a row, where elements are stored one after another.
         * */
        int[] oneDimensionalArray = {1,2,3,4,5};
        System.out.println("One dimensional array: "+Arrays.toString(oneDimensionalArray));

        /**
         * 4. Multidimensional array (N-D arrays):
         * Multidimensional arrays can be considered as an array of arrays or as a matrix consisting
         * of rows and columns.
         * */
        int[][][] multiDimensionalArray = {{{1,2},{3,4}},{{5,6},{7,8}}};
        System.out.println("Multi dimensional array: "+Arrays.deepToString(multiDimensionalArray));

    }
}
