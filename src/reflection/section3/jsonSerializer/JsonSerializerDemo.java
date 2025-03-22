package reflection.section3.jsonSerializer;

import reflection.section3.jsonSerializer.data.Address;
import reflection.section3.jsonSerializer.data.Company;
import reflection.section3.jsonSerializer.data.Person;

import java.lang.reflect.Field;

public class JsonSerializerDemo {

    public static void main(String[] args) {
        Address address = new Address("Main Street", (short) 1);
        Company company = new Company("Udemy", "Mumbai", new Address("Badlapur",(short)200));
        Person person = new Person("John", true, 29, 100.556f, address, company);
//        String addressJson = objectToJson(address, 0);
        String personJson = objectToJson(person, 0);
//        System.out.println(addressJson);
        System.out.println(personJson);
    }

    // Converts object to JSON
    public static String objectToJson(Object instance, int indentSize){
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder(indent(indentSize));
        stringBuilder.append("{\n");
        for(int i = 0; i < fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            if(field.isSynthetic()){
                continue;
            }
            stringBuilder.append(indent(indentSize+1));
            stringBuilder.append(formatStringValue(field.getName()));
            stringBuilder.append(": ");
            try {
            if(field.getType().isPrimitive()){
                stringBuilder.append(formatPrimitiveValue(field, instance));
            } else if (field.getType().equals(String.class)) {
                stringBuilder.append(formatStringValue(field.get(instance).toString()));
            } else{
                // recursive call for nested objects
                stringBuilder.append(objectToJson(field.get(instance),indentSize+1));
            }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (i != fields.length - 1){
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(indent(indentSize));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    // indentation for fields and brackets
    private static String indent(int indentSize){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indentSize; i++){
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();
    }

    private static String formatPrimitiveValue(Field field, Object parentInstance){
        try {
        if(field.getType().equals(boolean.class)
                || field.getType().equals(int.class)
                || field.getType().equals(long.class)
                || field.getType().equals(short.class)){
                return field.get(parentInstance).toString();
        } else if(field.getType().equals(float.class) || field.getType().equals(double.class)){
            return String.format("%.02f",field.get(parentInstance));
        }
        throw new RuntimeException(String.format("Type: %s is unsupported", field.getType().getSimpleName()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static String formatStringValue(String value){
        return String.format("\"%s\"", value);
    }

}
