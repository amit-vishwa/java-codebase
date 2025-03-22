package reflection.section2.restrictedConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Restricted constructor with private access specifier can be accessed with reflection.
 * In this example, will create a class with singleton pattern having private constructor.
 * Will then access the it's instance using the reflection.
 * */
public class RestrictedConstructorDemo {

    public static void main(String[] args) {
        initConfiguration();
        new WebServer().startServer();
    }

    private static void initConfiguration(){
        try {
            Constructor<ServerConfiguration> constructor = ServerConfiguration.class
                    .getDeclaredConstructor(int.class, String.class);
            constructor.setAccessible(true);
            constructor.newInstance(8080,"Good evening");
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException
                 | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
