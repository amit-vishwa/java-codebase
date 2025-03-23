package reflection.section4.setArrays.codingExercise;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        ArrayFlattening arrayFlattening = new ArrayFlattening();
        Integer[] result1 =  arrayFlattening.concat(Integer.class, 1, 2, 3, 4, 5);
        System.out.println(Arrays.toString(result1));
        int[] result2 =  arrayFlattening.concat(int.class, 1, 2, 3, new int[] {4, 5, 6}, 7);
        System.out.println(Arrays.toString(result2));
        String[] result3 =  arrayFlattening.concat(String.class, new String[]{"a", "b"}, "c", new String[] {"d", "e"});
        System.out.println(Arrays.toString(result3));
    }

}
