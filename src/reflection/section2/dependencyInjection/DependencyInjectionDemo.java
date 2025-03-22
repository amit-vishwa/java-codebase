package reflection.section2.dependencyInjection;

import reflection.section2.dependencyInjection.game.Game;
import reflection.section2.dependencyInjection.game.internal.TicTacToeGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DependencyInjectionDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            InvocationTargetException, ClassNotFoundException {
        // Class.forName can be used when class is not public in separate package
//        Game game = (Game) createObjectRecursively(Class.forName("reflection.section2.dependencyInjection.game.internal.TicTacToeGame"));
        Game game = (Game) createObjectRecursively(TicTacToeGame.class);
        game.startGame();
    }

    public static <T> T createObjectRecursively(Class<T> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = getFirstConstructor(clazz);

        List<Object> constructorArguments = new ArrayList<>();

        for (Class<?> argumentType : constructor.getParameterTypes()) {
            Object argumentValue = createObjectRecursively(argumentType);
            constructorArguments.add(argumentValue);
        }

        constructor.setAccessible(true);
        return (T) constructor.newInstance(constructorArguments.toArray());
    }

    private static Constructor<?> getFirstConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new IllegalStateException(String.format("No constructor has been found for class %s", clazz.getName()));
        }

        return constructors[0];
    }

}
