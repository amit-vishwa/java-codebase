package reflection.section2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * We can use reflection for constructors and objects.
 * */
public class ConstructorAndObjectReflection {

    public static void main(String[] args) {
        constructorDemo();
        objectDemo();
    }

    private static void constructorDemo() {
        printConstructorData(Person.class);
        System.out.println();
        printConstructorData(Address.class);
        System.out.println();
    }

    private static void objectDemo() {
        try {
            Address address = createInstanceWithArgs(Address.class, "First street", 10);
            System.out.println(address);
            Person person = createInstanceWithArgs(Person.class, address, "John", 30);
            System.out.println(person);
        }catch (Exception e){}
    }

    /**
     * Object can be created using reflection.
     * Generic factory method to create an object of any class.
     * */
    public static <T> T createInstanceWithArgs(Class<T> clazz, Object... args)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for(Constructor<?> constructor : clazz.getDeclaredConstructors()){
            if(constructor.getParameterTypes().length == args.length){
                return (T) constructor.newInstance(args);
            }
        }
        return null;
    }

    /**
     * We can use parameter and parameterless constructors.
     * We can use Class.getDeclaredConstructors() to fetch all declared ones.
     * We can use Class.getConstructors() to fetch public constructors.
     * We can also pass parameters to fetch specific parameter constructor.
     * */
    public static void printConstructorData(Class<?> clazz){
        Constructor<?> [] constructors = clazz.getDeclaredConstructors();
        System.out.println(String.format("Class %s has %d declared constructors", clazz.getSimpleName(),
                constructors.length));
        for (int i = 0; i < constructors.length; i++){
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();
            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(Class::getSimpleName)
                    .toList();
            System.out.println(parameterTypeNames);
        }
    }

    public static class Person{
        private final Address address;
        private final String name;
        private final int age;

        public Person(){
            this.name = "anonymous";
            this.age = 0;
            this.address = null;
        }

        public Person(String name){
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public Person(String name, int age){
            this.name = name;
            this.age = age;
            this.address = null;
        }

        Person(Address address, String name, int age){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Address{
        private String street;
        private int number;

        public Address(String street, int number){
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

}
