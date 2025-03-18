package reflection.section1;

import java.util.*;

/**
 * Reflection example to get class information.
 * With the help of reflection API, we can fetch information of objects, classes,
 * interfaces, enums, arrays, anonymous classes, etc.
 * */
public class ReflectionAPIGateway {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Map<String, Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();
        Class<?> squareClass = Class.forName("reflection.section1.ReflectionAPIGateway$Square");
        Class<?> drawableInterface = Class.forName("reflection.section1.ReflectionAPIGateway$Drawable");
        Class<?> colorEnum = Class.forName("reflection.section1.ReflectionAPIGateway$Color");
        printClassInfo(stringClass,hashMapClass,squareClass,drawableInterface,colorEnum);
        Drawable annonymousClass = new Drawable() {
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };
        printClassInfo(Collection.class, boolean.class, int [][].class, Color.class, annonymousClass.getClass());
    }

    private static void printClassInfo(Class<?> ... classes){
        for(Class<?> clazz : classes){
            System.out.println("Class Name: " + clazz.getName());
            System.out.println("Simple Name: " + clazz.getSimpleName());
            System.out.println("Package Name: " + clazz.getPackageName());
            System.out.println("Canonical Name: " + clazz.getCanonicalName());
            System.out.println("Type Name: " + clazz.getTypeName());
            System.out.println("Generic Superclass: " + clazz.getGenericSuperclass());
            System.out.println("Generic Interfaces: " + Arrays.toString(clazz.getGenericInterfaces()));
            System.out.println("Modifiers: " + clazz.getModifiers());
            System.out.println("Package: " + clazz.getPackage());
            System.out.println("Is Interface: " + clazz.isInterface());
            System.out.println("Is Enum: " + clazz.isEnum());
            System.out.println("Is Annotation: " + clazz.isAnnotation());
            System.out.println("Is Primitive: " + clazz.isPrimitive());
            System.out.println("Is Array: " + clazz.isArray());
            System.out.println("Is Anonymous Class: " + clazz.isAnonymousClass());
            System.out.println("Is Local Class: " + clazz.isLocalClass());
            System.out.println("Is Member Class: " + clazz.isMemberClass());
            System.out.println("Is Synthetic: " + clazz.isSynthetic());
            System.out.println("Is Annotation Present: " + clazz.isAnnotationPresent(Deprecated.class));
            System.out.println("Is Enum Constant: " + Arrays.toString(clazz.getEnumConstants()));

            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> implementedInterface : interfaces){
                System.out.println("Simple Class Name: " + clazz.getSimpleName());
                System.out.println("Simple Interface Name: " + implementedInterface.getSimpleName());
            }

            System.out.println();
        }
    }

    private static class Square implements Drawable{
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable{
        int getNumberOfCorners();
    }

    private enum Color{
        GREEN,
        BLUE,
        RED
    }

}
