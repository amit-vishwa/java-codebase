package tutorial.java.array;

// Single and multi dimensional array
public class ArrayClassExample {

    public static void main(String args[])
    {
        // Array is variable that stores list of data with same data type in consecutive memory location
        int intArray[] = { 1, 2, 3 };
        int cloneArray[] = intArray.clone();
        // will print false as shallow copy is created
        System.out.println(intArray == cloneArray);
        for (int i = 0; i < cloneArray.length; i++) {
            System.out.print(cloneArray[i] + " ");
        }
        intArray[0]=0;
        System.out.println();
        for (int i = 0; i < cloneArray.length; i++) {
            System.out.print(cloneArray[i] + " " + intArray[i] + " | ");
        }
        System.out.println();

        int intArrays[][] = { { 1, 2, 3 }, { 4, 5 } };
        int cloneArrays[][] = intArrays.clone();
        // will print false
        System.out.println(intArrays == cloneArrays);
        // will print true as shallow copy is created
        // i.e. sub-arrays are shared
        System.out.println(intArrays[0] == cloneArrays[0]);
        System.out.println(intArrays[1] == cloneArrays[1]);
    }


}
