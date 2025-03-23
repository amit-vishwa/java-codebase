package reflection.section4.setFields;

import reflection.section2.dependencyInjection.game.Game;
import reflection.section4.setFields.data.GameConfig;
import reflection.section4.setFields.data.UserInterfaceConfig;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Scanner;

public class SetFieldsUsingReflection {

    private static final Path GAME_CONFIG_PATH = Path.of("java-codebase/src/reflection/section4/setFields/config/game-properties.cfg");
    private static final Path UI_CONFIG_PATH = Path.of("java-codebase/src/reflection/section4/setFields/config/user-interface.cfg");

    public static void main(String[] args) {
        GameConfig game = createConfigObject(GameConfig.class, GAME_CONFIG_PATH);
        System.out.println(game);
        UserInterfaceConfig ui = createConfigObject(UserInterfaceConfig.class, UI_CONFIG_PATH);
        System.out.println(ui);
    }

    private static <T> T createConfigObject(Class<T> clazz, Path filePath){
        try {
            Scanner scanner = new Scanner(filePath);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T configInstance = (T) constructor.newInstance();
            while (scanner.hasNextLine()){
                String configLine = scanner.nextLine();
                String[] nameValuePair = configLine.split("=");
                String propertyName = nameValuePair[0];
                String propertyValue = nameValuePair[1];
                Field field;
                try {
                    field = clazz.getDeclaredField(propertyName);
                } catch (NoSuchFieldException e) {
                    System.out.println("Property name: " + propertyName + " is unsupported");
                    continue;
                }
                field.setAccessible(true);
                Object parsedValue = parseValue(field.getType(), propertyValue);
                field.set(configInstance, parsedValue);
            }
            return configInstance;
        } catch (IOException | NoSuchMethodException | InstantiationException | InvocationTargetException
                 | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object parseValue(Class<?> type, String value){
        if(type.equals(int.class)){
            return Integer.parseInt(value);
        }else if(type.equals(short.class)){
            return Short.parseShort(value);
        }if(type.equals(long.class)){
            return Long.parseLong(value);
        }if(type.equals(float.class)){
            return Float.parseFloat(value);
        }if(type.equals(double.class)){
            return Double.parseDouble(value);
        }if(type.equals(String.class)){
            return value;
        }
        throw new RuntimeException("Type: " + type.getTypeName() + " is not supported");
    }

}
