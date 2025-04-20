package youtube.map.hashmap;

import java.util.HashMap;

/**
 * HashMap works on hashcode, whereas for custom object the hashcode is always unique as it is generated using memory.
 * So, here the hashcode() must be overridden along with equals() while creating the class.
 * */
public class HashingCustomObject {

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice",1);
        Person p2 = new Person("Bob",2);
        Person p3 = new Person("Alice",1);
        Person p4 = new Person("Alex",1);
        Person p5 = new Person("Alex",2);
        Person p6 = new Person("Bob",2);

        map.put(p1,"Engineer"); // hashcode1 --> index1
        map.put(p2,"Designer"); // hashcode2 --> index2
        map.put(p3,"Manager"); // hashcode1 --> index1 --> equals --> replace
        map.put(p4,"Doctor"); // hashcode3 --> index3
        map.put(p5,"Builder"); // hashcode4 --> index4
        map.put(p6,"Officer"); // hashcode2 --> index2 --> equals --> replace

        // when hashcode and equals are not overridden and updated, the size won't get updated
        System.out.println("Size: " + map.size());
        System.out.println("Map: " + map);
        System.out.println("P1: " + map.get(p1) + ", P3: " + map.get(p3));
        System.out.println("P2: " + map.get(p2) + ", P6: " + map.get(p6));
    }

}
