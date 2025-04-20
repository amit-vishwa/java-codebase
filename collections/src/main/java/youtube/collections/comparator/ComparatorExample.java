package youtube.collections.comparator;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Comparator is an interface which is used for custom sorting the list.
 * The sort() is used to sort in ascending/natural order when null argument is passed.
 * */
public class ComparatorExample {

    public static void main(String[] args) {
//        simpleComparator();
//        customComparator();
//        sortInDescending();
        sortObject();
    }

    private static void simpleComparator(){
        List<Integer> integers = new ArrayList<>(Arrays.asList(2,1,4,3));
        System.out.println(integers);
        integers.sort(null); // this is Comparator
        System.out.println(integers);

        List<String> strings = new ArrayList<>(Arrays.asList("date","apple","orange","banana"));
        System.out.println(strings);
//        Collections.sort(strings);// this works with Comparable
        strings.sort(null);
        System.out.println(strings);
    }

    private static void customComparator() {
        List<String> strings = new ArrayList<>(Arrays.asList("dave","apple","orange","banana","date"));
        System.out.println(strings);
//        strings.sort((str1,str2)->str1.compareTo(str2)); // compareTo() sorts lexicographically
//        strings.sort((str1,str2)->str1.length()-str2.length()); // this sorts based on string length
        strings.sort((str1,str2)->{
            int sortResult = str1.length()-str2.length();
            if(sortResult == 0){ // when string length is equal
                return str1.compareTo(str2); // sort lexicographically
            }
            return sortResult; // else sort based on string length
        });
        System.out.println(strings);
    }

    private static void sortInDescending() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,6,3,8,9,0));
        System.out.println(integers);
        // Collection.sort() works with Comparable, however in parameters we can pass custom Comparators
//        Collections.sort(integers,(i1,i2)->i2-i1); // sorts in descending
//        Collections.sort(integers,Collections.reverseOrder()); // sorts in descending
        // sorts in ascending as Collections.reverseOrder() already reversed the list
//        Collections.sort(integers,Collections.reverseOrder((i1,i2)->i2-i1));
        integers.sort((i1,i2)->i2-i1); // sort in descending order
        System.out.println(integers);

    }

    private static void sortObject() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex",3.2));
        students.add(new Student("Anna",3.9));
        students.add(new Student("Rosy",3.1));
        students.add(new Student("Lily",3.8));
        students.add(new Student("Annie",3.9));
        System.out.println("Students: " + students);

//        students.sort(null); // since Student don't implement Comparable, this will throw ClassCastException
        /*students.sort((s1,s2)-> {
            double sortResult = s1.getGpa() - s2.getGpa();
            return sortResult > 0 ? 1 : (sortResult < 0 ? -1 : 0); // ascending
            // sort by Gpa, if both equal then again sort by Name
//            return sortResult > 0 ? 1 : (sortResult < 0 ? -1 : s1.getName().compareTo(s2.getName()));
//            return sortResult < 0 ? 1 : (sortResult > 0 ? -1 : 0); // descending
        });*/

        // We can use Java 8 features and modern Java to reduce lines of code
        Comparator<Student> studentGpaComparator = Comparator.comparing(Student::getGpa).reversed();
        students.sort(studentGpaComparator);
        System.out.println("Students reverse sort by Gpa: " + students);

        Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName).reversed();
        students.sort(studentNameComparator);
        System.out.println("Students reverse sort by Name: " + students);

        // here, thenComparing() will only be done on two equal objects
        Comparator<Student> studentComparator = studentGpaComparator.thenComparing(studentNameComparator);
        students.sort(studentComparator);
        System.out.println("Students reverse sort by Gpa and then Name: " + students);
    }

}
