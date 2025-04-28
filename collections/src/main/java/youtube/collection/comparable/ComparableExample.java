package youtube.collection.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Comparable interface is implemented in the object class in order to perform natural sorting.
 * A class on which sorting is to be performed, it should implement the Comparable interface.
 * The compareTo() method is used to perform the sorting.
 *
 * Comparable is used inside the class to inform it regarding the element using which natural sorting
 * is to be performed.
 * However, Comparator interface is used when custom sorting is to be performed. It can be used directly.
 * It can be performed on multiple fields as well.
 * */
public class ComparableExample {

    public static void main(String[] args) {
        simpleComparableExample();
    }

    private static void simpleComparableExample() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Charlie",3.5));
        personList.add(new Person("Bob",3.7));
        personList.add(new Person("Alice",3.5));
        personList.add(new Person("Pony",3.9));
        personList.add(new Person("Sweetie",3.1));
        System.out.println(personList);
        personList.sort(null); // gives error comparable is not there in object to perform natural sorting
        System.out.println(personList);

        List<Integer> integers = new ArrayList<>(Arrays.asList(1,3,4,9,0));
        System.out.println(integers);
        integers.sort(null); // no error as comparable is already there in Integer object to perform natural sorting
        System.out.println(integers);
    }

}

class Person implements Comparable<Person>{
    private String name;
    private double gpa;
    public Person(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(this.gpa,o.gpa); // sorts in ascending
    }
}
