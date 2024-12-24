package tutorial.java.oops;

/**
 *
 * Ways to Create an Object of a Class
 * There are four ways to create objects in Java. Strictly speaking, there is only one way(by using a new keyword), and the rest internally use a new keyword.
 *
 * 1. Using new keyword
 * 2. Using Class.forName(String className) method
 * 3. Using clone() method
 * 4. Deserialization
 *
 * */

class Dog {
    // Instance Variables
    String name;
    String breed;
    int age;
    String color;

    // Constructor Declaration of Class
    public Dog(String name, String breed, int age,
               String color)
    {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    // method 1
    public String getName() { return name; }

    // method 2
    public String getBreed() { return breed; }

    // method 3
    public int getAge() { return age; }

    // method 4
    public String getColor() { return color; }

    @Override public String toString()
    {
        return ("Hi my name is " + this.getName()
                + ".\nMy breed,age and color are "
                + this.getBreed() + "," + this.getAge()
                + "," + this.getColor());
    }
}
public class ObjectCreationExample {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // i.using new keyword
        Dog tuffy
                = new Dog("tuffy", "papillon", 5, "white");
        System.out.println(tuffy.toString());

        // ii.using new instance (below giving error maybe due to deprecation)
//        Dog puppy
//                = (Dog)Class.forName("tutorial.java.oops.Dog").newInstance();
//        System.out.println(puppy.toString());

        // iii.using clone
        Dog tuff
                = new Dog("tuff", "papillon", 3, "black");
        System.out.println(tuff.toString());

        // iv.using deserialization
        // De-serialization is a technique of reading an object from the saved state in a file.
//        FileInputStream file = new FileInputStream(filename);
//        ObjectInputStream in = new ObjectInputStream(file);
//        Object obj = in.readObject();

    }
}