package tutorial.java.oops;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Reflection is an API that is used to examine or modify the behavior of methods, classes,
 * and interfaces at runtime. The required classes for reflection are provided under java.lang.reflect
 * package which is essential in order to understand reflection.
 *
 * Reflection gives us information about the class to which an object belongs and also the methods
 * of that class that can be executed by using the object.
 * Through reflection, we can invoke methods at runtime irrespective of the access specifier used with them.
 * */

public class ReflectionClassExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("tutorial.java.oops.Emp");

//        Constructor array
        Constructor[] constructors = c.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            System.out.println("Name of Constructor : "+constructor);
            System.out.println("Count of constructor parameter : "+constructor.getParameterCount());
            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter : parameters) {
                System.out.println("Constructor's parameter : "+parameter);
            }
            System.out.println();
        }
        System.out.println();

//          Method Array
        Method[] methods = c.getDeclaredMethods();
        System.out.println("Length of method : "+methods.length);
        for(Method method : methods){
            System.out.println("Method name: \t"+method);
            System.out.println("Method return type : \t"+method.getReturnType());
            System.out.println("Method parameter count: \t"+method.getParameterCount());
            System.out.println();
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters) {
                System.out.println("Method's Parameter : "+parameter);
            }
            System.out.println();
        }
        System.out.println();

//        Classes and Enums
        Class[] classes = c.getDeclaredClasses();
        for(Class class1 : classes) {
            System.out.println("class: "+class1);
            System.out.println("Name of class: "+class1.getName());
        }

//        Annotations
        Annotation[] anno = c.getDeclaredAnnotations();
        for(Annotation annotation : anno) {
            System.out.println("Annotation: "+annotation);
        }

    }
}




class Emp{
    private int eid;
    private double esal;
    private String ename;

    enum Week{
        SUN,TUE,WED;
    }

    @interface MyAnno{}

    public int getEid(){
        return eid;
    }
    public void setEid(int eid,int num, char ch){
        this.eid = eid;
    }

    public double getEsal(){
        return esal;
    }
    public void setEsal(double esal,float data, String name){
        this.esal = esal;
    }

    public String getEname(){
        return ename;
    }
    public void setEname(String ename){
        this.ename = ename;
    }

    // constructor
    public Emp(int eid, double esal, String ename){
        super();
        this.eid = eid;
        this.esal = esal;
        this.ename = ename;
    }
    Emp(){
    }
    class A{
    }
    class B{
    }
}
