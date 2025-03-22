package reflection.section3.codingExercise;
import java.lang.reflect.*;

public class ObjectSizeCalculator {
    private static final long HEADER_SIZE = 12;
    private static final long REFERENCE_SIZE = 4;

    public long sizeOfObject(Object input) {
        /**
         * Complete your code here
         */
        long fieldSize = 0;
        try {
            for(Field field : input.getClass().getDeclaredFields()){
                field.setAccessible(true);
                if(field.getType().isPrimitive()){
                    fieldSize += sizeOfPrimitiveType(field.getType());
                } else if (field.getType().equals(String.class)) {
                    fieldSize += sizeOfString(field.get(input).toString());
                }
            }
        } catch(IllegalAccessException e) {
        }
        return (HEADER_SIZE + REFERENCE_SIZE + fieldSize);
    }


    /*************** Helper methods ********************************/
    private long sizeOfPrimitiveType(Class<?> primitiveType) {
        if (primitiveType.equals(int.class)) {
            return 4;
        } else if (primitiveType.equals(long.class)) {
            return 8;
        } else if (primitiveType.equals(float.class)) {
            return 4;
        } else if (primitiveType.equals(double.class)) {
            return 8;
        } else if (primitiveType.equals(byte.class)) {
            return 1;
        } else if (primitiveType.equals(short.class)) {
            return 2;
        }
        throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
    }

    private long sizeOfString(String inputString) {
        int stringBytesSize = inputString.getBytes().length;
        return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
    }
}
