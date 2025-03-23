package reflection.section5.methods.test;

import reflection.section5.methods.api.ClothingProduct;
import reflection.section5.methods.api.Product;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ProductTest {

    public static void main(String[] args) {
        testGetters(Product.class);
        testSetters(Product.class);
        testGetters(ClothingProduct.class);
        testSetters(ClothingProduct.class);
    }

    public static void testGetters(Class<?> dataClass){
//        Field[] fields = dataClass.getDeclaredFields();
        List<Field> fields = getAllFields(dataClass);
        Map<String, Method> methodNameToMethod = mapMethodNameToMethod(dataClass);
        for(Field field : fields){
            String getterName = "get" + capitalizeFirstLetter(field.getName());
            if(!methodNameToMethod.containsKey(getterName)){
                throw new IllegalStateException("Field: " + field.getName() + " doesn't have a getter method");
            }
            Method getter = methodNameToMethod.get(getterName);
            if(!getter.getReturnType().equals(field.getType())){
                throw new IllegalStateException(String.format("Getter method: %s() has return type %s but expected %s",
                        getter.getName(), getter.getReturnType().getTypeName(), field.getType().getTypeName()));
            }
            if(getter.getParameterCount() > 0){
                throw new IllegalStateException(String.format("Getter: %s() has %d arguments but expected 0", getterName, getter.getParameterCount()));
            }
        }
    }

    private static String capitalizeFirstLetter(String name) {
        return name.substring(0,1).toUpperCase().concat(name.substring(1));
    }

    private static Map<String, Method> mapMethodNameToMethod(Class<?> dataClass){
        Method[] allMethods = dataClass.getMethods(); // fetch public methods
        Map<String, Method> nameToMethod = new HashMap<>();
        for (Method method : allMethods){
            nameToMethod.put(method.getName(), method);
        }
        return nameToMethod;
    }

    public static void testSetters(Class<?> dataClass){
//        Field[] fields = dataClass.getDeclaredFields();
        List<Field> fields = getAllFields(dataClass);
        for (Field field : fields){
            String setterName = "set" + capitalizeFirstLetter(field.getName());
            Method setterMethod = null;
            try {
                setterMethod = dataClass.getMethod(setterName, field.getType());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(String.format("Setter: %s() not found", setterName));
            }
            if(!setterMethod.getReturnType().equals(void.class)){
                throw new IllegalStateException(String.format("Setter method: %s() has to return void",
                        setterName));
            }
        }
    }

    // Get all fields of a class including super classes fields
    private static List<Field> getAllFields(Class<?> clazz){
        if(clazz == null || clazz.equals(Object.class)){
            return Collections.emptyList();
        }
        Field[] currentClassFields = clazz.getDeclaredFields();
        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());
        List<Field> allFields = new ArrayList<>();
        allFields.addAll(Arrays.asList(currentClassFields));
        allFields.addAll(inheritedFields);
        return allFields;
    }

}
