package reflection.section4.setArrays;

import reflection.section4.setArrays.data.GameConfig;
import reflection.section4.setArrays.data.UserInterfaceConfig;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Config Parser - Part 2
 * https://www.udemy.com/course/java-reflection-master-class
 */
public class SetArraysUsingReflection {

    private static final Path GAME_CONFIG_PATH = Path.of("java-codebase/src/reflection/section4/setArrays/config/game-properties.cfg");
    private static final Path UI_CONFIG_PATH = Path.of("java-codebase/src/reflection/section4/setArrays/config/user-interface.cfg");

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        GameConfig gameConfig = createConfigObject(GameConfig.class, GAME_CONFIG_PATH);
        UserInterfaceConfig uiConfig = createConfigObject(UserInterfaceConfig.class, UI_CONFIG_PATH);

        System.out.println(gameConfig);
        System.out.println(uiConfig);
    }

    public static <T> T createConfigObject(Class<T> clazz, Path filePath) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Scanner scanner = new Scanner(filePath);

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        T configInstance = (T) constructor.newInstance();

        while (scanner.hasNextLine()) {
            String configLine = scanner.nextLine();

            String[] nameValuePair = configLine.split("=");

            if (nameValuePair.length != 2) {
                continue;
            }

            String propertyName = nameValuePair[0];
            String propertyValue = nameValuePair[1];

            Field field;
            try {
                field = clazz.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                System.out.println(String.format("Property name : %s is unsupported", propertyName));
                continue;
            }

            field.setAccessible(true);

            Object parsedValue;

            if (field.getType().isArray()) {
                parsedValue = parseArray(field.getType().getComponentType(), propertyValue);
            } else {
                parsedValue = parseValue(field.getType(), propertyValue);
            }

            field.set(configInstance, parsedValue);
        }

        return configInstance;
    }

    private static Object parseArray(Class<?> arrayElementType, String value) {
        String[] elementValues = value.split(",");

        Object arrayObject = Array.newInstance(arrayElementType, elementValues.length);

        for (int i = 0; i < elementValues.length; i++) {
            Array.set(arrayObject, i, parseValue(arrayElementType, elementValues[i]));
        }
        return arrayObject;
    }

    private static Object parseValue(Class<?> type, String value) {
        if (type.equals(int.class)) {
            return Integer.parseInt(value);
        } else if (type.equals(short.class)) {
            return Short.parseShort(value);
        } else if (type.equals(long.class)) {
            return Long.parseLong(value);
        } else if (type.equals(double.class)) {
            return Double.parseDouble(value);
        } else if (type.equals(float.class)) {
            return Float.parseFloat(value);
        } else if (type.equals(String.class)) {
            return value;
        }
        throw new RuntimeException(String.format("Type : %s unsupported", type.getTypeName()));
    }
}
