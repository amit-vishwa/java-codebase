package tutorial.java.array;

import java.util.Arrays; // Import Arrays class for toString() method

public class FinalArrayExample {

    public static void main(String[] args)
    {
        final int[] numbers = { 1, 2, 3, 4, 5 };
        // Attempting to reassign below will give compilation error
        // numbers = new int[] {6, 7, 8, 9, 10};
        // However, individual array elements can still be modified:
        numbers[0] = 10;
        System.out.println(
                "Array after modifying first element: "
                        + Arrays.toString(numbers));
    }

}