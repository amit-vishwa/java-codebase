package tutorial.java.syntax;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DataTypeExample {
    public static void main(String... args){

        boolean booleanType = true;
        byte byteType = 1;
        short shortType = 2;
        char charType = 'a';
        int integerType = 3;
        long longType = 4;
        float floatType = 1.0f;
        double doubleType = 2.0;

        String stringType = "This is a string data type";
        int[] integerTypeArray = {1,2};

        System.out.println("\nData types:");

        System.out.println("\n1.Primitive data types:");

        System.out.println("\na.Numeric primitive data types:");

        System.out.println("\ni.Integer numeric primitive data types:");
        System.out.println("-> Byte:"+byteType+", with size of 8-bit");
        System.out.println("-> Short:"+shortType+", with size of 16-bit");
        System.out.println("-> Integer:"+integerType+", with size of 32-bit");
        System.out.println("-> Long:"+longType+", with size of 64-bit");

        System.out.println("\nii.Floating numeric primitive data types:");
        System.out.println("-> Float:"+floatType+", with size of 32-bit");
        System.out.println("-> Double:"+doubleType+", with size of 64-bit");

        System.out.println("\nb.Non-numeric primitive data types:");

        System.out.println("\ni.Boolean non-numeric primitive data types:");
        System.out.println("-> Boolean:"+booleanType+", with size of 1-bit");

        System.out.println("\nii.Character non-numeric primitive data types:");
        System.out.println("-> Character:"+charType+", with size of 16-bit");

        System.out.println("\n2.Non-primitive data types:");
        System.out.println("a.String object: "+stringType);
        System.out.println("b.Array of integer type: "+Arrays.toString(integerTypeArray));

    }
}
