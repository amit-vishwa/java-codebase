package tutorial.java.array;

import java.util.Arrays;
import java.util.Comparator;

// Program to demonstrate Arrays methods
public class ArraysClassExample {

    // Arrays.asList()
    static void asList(){
        int intArr[] = { 10, 20, 15, 22, 35 };
        // To convert the elements as List
        System.out.println("Integer Array as List: "
                    + Arrays.asList(intArr));
    }

    // Arrays.binarySearch() and Arrays.sort()
    static void binarySearch(){
        int intArr[] = { 10, 20, 15, 22, 35 };
        Arrays.sort(intArr);
        int intKey = 22;
        // Print the key and corresponding index
        System.out.println(
                intKey + " found at index = "
                        + Arrays.binarySearch(intArr, intKey));
    }

    // Arrays.binarySearch() for specified range
    static void binarySearchForRange(){
        int intArr[] = { 10, 20, 15, 22, 35 };
        Arrays.sort(intArr);
        int intKey = 22;
        System.out.println(
                intKey
                        + " found at index = "
                        + Arrays
                        .binarySearch(intArr, 1, 3, intKey));
    }

    // Arrays.compare()
    static void compare(){
        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };
        // Get the second Array
        int intArr1[] = { 10, 15, 22 };
        // To compare both arrays
        System.out.println("Integer Arrays on comparison: "
                + Arrays.compare(intArr, intArr1));
    }

    // Arrays.compareUnsigned()
    static void compareUnsigned(){
        // Get the Arrays
        int intArr[] = { 10, 20, 15, 22, 35 };
        // Get the second Arrays
        int intArr1[] = { 10, 15, 22 };
        // To compare both arrays
        System.out.println("Integer Arrays on comparison: "
                + Arrays.compareUnsigned(intArr, intArr1));
    }

    // Arrays.copyOf()
    static void copyOf(){
        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };
        // To print the elements in one line
        System.out.println("Integer Array: "
                + Arrays.toString(intArr));
        System.out.println("\nNew Arrays by copyOf:\n");
        System.out.println("Integer Array: "
                + Arrays.toString(
                Arrays.copyOf(intArr, 10)));
    }

    // Arrays.copyOfRange()
    static void copyOfRange(){
        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };
        // To print the elements in one line
        System.out.println("Integer Array: "
                + Arrays.toString(intArr));
        System.out.println("\nNew Arrays by copyOfRange:\n");
        // To copy the array into an array of new length
        System.out.println("Integer Array: "
                + Arrays.toString(
                Arrays.copyOfRange(intArr, 1, 3)));
    }

    // Arrays.deepEquals()
    static void deepEquals(){
        // Get the Arrays
        int intArr[][] = { { 10, 20, 15, 22, 35 } };
        // Get the second Arrays
        int intArr1[][] = { { 10, 15, 22 } };
        // To compare both arrays
        System.out.println("Integer Arrays on comparison: "
                + Arrays.deepEquals(intArr, intArr1));
    }

    // Arrays.deepHashCode()
    static void deepHashCode(){
        // Get the Array
        int intArr[][] = { { 10, 20, 15, 22, 35 } };
        // To get the dep hashCode of the arrays
        System.out.println("Integer Array: "
                + Arrays.deepHashCode(intArr));
    }

    // Arrays.deepToString()
    static void deepToString(){
        // Get the Array
        int intArr[][] = { { 10, 20, 15, 22, 35 } };
        // To get the deep string of the arrays
        System.out.println("Integer Array: "
                + Arrays.deepToString(intArr));
    }

    // Arrays.equals()
    static void equals(){
        // Get the Arrays
        int intArr[] = { 10, 20, 15, 22, 35 };
        // Get the second Arrays
        int intArr1[] = { 10, 15, 22 };
        // To compare both arrays
        System.out.println("Integer Arrays on comparison: "
                + Arrays.equals(intArr, intArr1));
    }

    // Arrays.fill()
    static void fill(){
        // Get the Arrays
        int intArr[] = { 10, 20, 15, 22, 35 };
        int intKey = 22;
        Arrays.fill(intArr, intKey);
        // To fill the arrays
        System.out.println("Integer Array on filling: "
                + Arrays.toString(intArr));
    }

    // Arrays.hashCode()
    static void hashCodes(){
        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };
        // To get the hashCode of the arrays
        System.out.println("Integer Array: "
                + Arrays.hashCode(intArr));
    }

    // Arrays.mismatch()
    static void mismatch(){
        // Get the Arrays
        int intArr[] = { 10, 20, 15, 22, 35 };
        // Get the second Arrays
        int intArr1[] = { 10, 15, 22 };
        // To compare both arrays
        System.out.println("The element mismatched at index: "
                + Arrays.mismatch(intArr, intArr1));
    }

    // Arrays.parallelSort() and Arrays.toString()
    static void parallelSort(){
        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };
        // To sort the array using parallelSort
        Arrays.parallelSort(intArr);
        System.out.println("Integer Array: "
                + Arrays.toString(intArr));
    }

    // Arrays.sort() using comparator
    static void sortUsingComparator(){
        // A class to represent a student.
        class Student {
            int rollno;
            String name, address;
            // Constructor
            public Student(int rollno, String name,
                           String address)
            {
                this.rollno = rollno;
                this.name = name;
                this.address = address;
            }
            // Used to print student details in main()
            public String toString()
            {
                return this.rollno + " "
                        + this.name + " "
                        + this.address;
            }
        }

        class Sortbyroll implements Comparator<Student> {
            // Used for sorting in ascending order of
            // roll number
            public int compare(Student a, Student b)
            {
                return a.rollno - b.rollno;
            }
        }

        Student[] arr = { new Student(111, "bbbb", "london"),
                new Student(131, "aaaa", "nyc"),
                new Student(121, "cccc", "jaipur") };
        System.out.println("Unsorted");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        Arrays.sort(arr, new Sortbyroll());
        System.out.println("\nSorted by rollno");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }




    public static void main(String[] args)
    {
        asList();
        binarySearch();
        binarySearchForRange();
        compare();
        compareUnsigned();
        copyOf();
        copyOfRange();
        deepEquals();
        deepHashCode();
        deepToString();
        equals();
        fill();
        hashCodes();
        mismatch();
        parallelSort();
        sortUsingComparator();
    }

}
