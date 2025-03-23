package reflection.section5.polymorphism;

import reflection.section5.polymorphism.database.DatabaseClient;
import reflection.section5.polymorphism.http.HttpClient;
import reflection.section5.polymorphism.logging.FileLogger;
import reflection.section5.polymorphism.udp.UdpClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Polymorphism
 * https://www.udemy.com/course/java-reflection-master-class
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        DatabaseClient databaseClient = new DatabaseClient();
        HttpClient httpClient1 = new HttpClient("123.456.789.0");
        HttpClient httpClient2 = new HttpClient("11.33.55.0");
        FileLogger fileLogger = new FileLogger();
        UdpClient udpClient = new UdpClient();

        String requestBody = "request data";

        List<Class<?>> methodParameterTypes = Arrays.asList(new Class<?>[]{String.class});

        // LinkedHashMap used to maintain order of execution
        LinkedHashMap<Object, Method> requestExecutors =
                groupExecutors(Arrays.asList(databaseClient, httpClient1, httpClient2, fileLogger, udpClient),
                        methodParameterTypes);

        executeAll(requestExecutors, requestBody);
    }

    public static void executeAll(Map<Object, Method> requestExecutors, Object... arguments) throws Throwable {
        try {
            for (Map.Entry<Object, Method> requestExecutorEntry : requestExecutors.entrySet()) {

                Object requestExecutor = requestExecutorEntry.getKey();
                Method method = requestExecutorEntry.getValue();

                Boolean result = (Boolean) method.invoke(requestExecutor, arguments);

                if (result != null && result.equals(Boolean.FALSE)) {
                    System.out.println("Received negative result. Aborting ...");
                    return;
                }
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    public static LinkedHashMap<Object, Method> groupExecutors(List<Object> requestExecutors, List<Class<?>> methodParameterTypes) {
        LinkedHashMap<Object, Method> instanceToMethod = new LinkedHashMap<>();

        for (Object requestExecutor : requestExecutors) {
            Method[] allMethods = requestExecutor.getClass().getDeclaredMethods();

            for (Method method : allMethods) {
                if (Arrays.asList(method.getParameterTypes()).equals(methodParameterTypes)) {
                    instanceToMethod.put(requestExecutor, method);
                }
            }
        }
        return instanceToMethod;
    }
}
