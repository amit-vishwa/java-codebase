package reflection.section3;

import java.lang.reflect.Array;

/**
 * Work with arrays using reflection.
 * */
public class ArrayReflection {

    public static void main(String[] args) {
        int[] oneDimensionalArray = {1, 2};
        double[][] twoDimensionalArray = {{1.5, 2.5}, {3.5, 4.5}};
        inspectArrayObject(oneDimensionalArray);
        inspectArrayObject(twoDimensionalArray);
        System.out.println();
        inspectArrayValues(oneDimensionalArray);
        System.out.println();
        inspectArrayValues(twoDimensionalArray);
    }

    public static void inspectArrayValues(Object arrayObject){
        int arrayLength = Array.getLength(arrayObject);
        System.out.print("[");
        for(int i = 0; i < arrayLength; i++){
            Object element = Array.get(arrayObject, i);
            if(element.getClass().isArray()){
                inspectArrayValues(element);
            }else {
                System.out.print(element);
            }
            if(i != arrayLength - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void inspectArrayObject(Object arrayObject){
        Class<?> clazz = arrayObject.getClass();
        System.out.println("Is array: " + clazz.isArray());
        System.out.println("This array is of type: " + clazz.componentType().getTypeName());
    }

}
