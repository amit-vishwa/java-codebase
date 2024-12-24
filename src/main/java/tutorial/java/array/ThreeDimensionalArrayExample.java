package tutorial.java.array;

public class ThreeDimensionalArrayExample {

    private static void example1(){
        // Array Created and Initialized
        int[][][] arr = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };
        // Defining the x,y,z in Multi
        // Dimensional Array
        int n = arr.length;
        int m = arr[0].length;
        int o = arr[0][0].length;
        // Printing the Array
        for (int i = 0; i < n; i++) {
            System.out.println("Array "+ (i+1));
            for (int j = 0; j < m; j++){
                for(int k=0; k < o; k++)
                    System.out.print(arr[i][j][k] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void example2(){
        int[][][] arr = new int[2][2][2];
        // Three Dimensional x,y,z dimension
        int n=arr.length;
        int m=arr[0].length;
        int o=arr[0][0].length;
        int it=1;
        // Assigning the values to array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for(int k=0; k < o; k++){
                    arr[i][j][k] = it;
                    it++;
                }
            }
        }
        // Printing the Array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                for(int k=0; k < o; k++)
                    System.out.print(arr[i][j][k] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        example1();
        example2();
    }

}
