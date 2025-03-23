package reflection.section7.annotationCreation;

import reflection.section7.annotationCreation.annotation.InitializerClass;
import reflection.section7.annotationCreation.annotation.InitializerMethod;
import reflection.section7.annotationCreation.annotation.RetryOperation;
import reflection.section7.annotationCreation.annotation.ScanPackages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@ScanPackages({"reflection.section7.annotationCreation","reflection.section7.annotationCreation.config"
        ,"reflection.section7.annotationCreation.annotation","reflection.section7.annotationCreation.database"
        ,"reflection.section7.annotationCreation.http"})
public class AnnotationCreationDemo {

    public static void main(String[] args) {
        // If custom class or method annotation is not there then method won't get called
        initialize("reflection.section7.annotationCreation","reflection.section7.annotationCreation.config"
                ,"reflection.section7.annotationCreation.annotation","reflection.section7.annotationCreation.database"
                ,"reflection.section7.annotationCreation.http");
    }


    private static void initialize(String... packageNames){
//        List<Class<?>> classes = getAllClasses(packageNames);
        // Fetch packages from custom annotation
        ScanPackages scanPackages = AnnotationCreationDemo.class.getAnnotation(ScanPackages.class);
        if(scanPackages == null || scanPackages.value().length == 0){
            return;
        }
        List<Class<?>> classes = getAllClasses(scanPackages.value());
        for(Class<?> clazz : classes){
            if(!clazz.isAnnotationPresent(InitializerClass.class)){
                continue;
            }
            List<Method> methods = getAllInitializingMethods(clazz);
            Object instance = null;
            try {
                instance = clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            for(Method method : methods){
                try {
//                    method.invoke(instance);
                    callInitializingMethod(instance, method);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void callInitializingMethod(Object instance, Method method) throws Throwable {
        RetryOperation retryOperation = method.getAnnotation(RetryOperation.class);
        int numberOfRetries = retryOperation == null ? 0 : retryOperation.numberOfRetries();
        while(true){
            try {
                method.invoke(instance);
                break;
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                // retry multiple times using annotation for invocation exception
                if(numberOfRetries > 0 && Set.of(retryOperation.retryExceptions())
                        .contains(targetException.getClass())){
                    numberOfRetries--;
                    System.out.println("Retrying...");
                    Thread.sleep(retryOperation.durationBetweenRetriesMs());
                }else if(retryOperation != null){
                    throw new Exception(retryOperation.failureMessage(), targetException);
                }else {
                    throw targetException;
                }
            }
        }
    }

    private static List<Method> getAllInitializingMethods(Class<?> clazz){
        List<Method> initializingMethods = new ArrayList<>();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(InitializerMethod.class)){
                initializingMethods.add(method);
            }
        }
        return initializingMethods;
    }

    private static List<Class<?>> getAllClasses(String... packageNames){
        try {
            List<Class<?>> classes = new ArrayList<>();
            for(String packageName : packageNames){
                String packageRelativePath = packageName.replace(".","/");
//                URL url = AnnotationCreationDemo.class.getResource(packageRelativePath);
                URL url = Thread.currentThread().getContextClassLoader().getResource(packageRelativePath);
                if (url == null) {
                    System.out.println("Package not found: " + packageName);
                    continue;
                }
                URI packageUri = url.toURI();
                if(packageUri.getScheme().equals("file")){
                    Path packageFullPath = Paths.get(packageUri);
                    classes.addAll(getAllPackageClasses(packageFullPath, packageName));
                }else if(packageUri.getScheme().equals("jar")){
                    FileSystem fileSystem = FileSystems.newFileSystem(packageUri, Collections.emptyMap());
                    Path packageFullPathInJar = fileSystem.getPath(packageRelativePath);
                    classes.addAll(getAllPackageClasses(packageFullPathInJar, packageName));
                    fileSystem.close();
                }
            }
            return classes;
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Class<?>> getAllPackageClasses(Path packagePath, String packageName){
        if(!Files.exists(packagePath)){
            return Collections.emptyList();
        }
        try {
            List<Path> files = Files.list(packagePath).filter(Files::isRegularFile).toList();
            List<Class<?>> classes = new ArrayList<>();
            for (Path filePath : files){
                String fileName = filePath.getFileName().toString();
                if(fileName.endsWith(".class")){
                    String classFullName = packageName + "." + fileName.replaceFirst("\\.class$","");
                    Class<?> clazz = Class.forName(classFullName);
                    classes.add(clazz);
                }
            }
            return classes;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
