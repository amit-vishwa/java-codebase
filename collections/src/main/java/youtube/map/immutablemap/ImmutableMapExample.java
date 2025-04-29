package youtube.map.immutablemap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ImmutableMap cannot be modified. It is a view which can only be read.
 * We can create unmodifiable map using Collections.unmodifiableMap(), Map.of() and Map.ofEntries() methods.
 * */
public class ImmutableMapExample {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A",1);map1.put("B",2);map1.put("C",3);

        Map<String,Integer> map2 = Collections.unmodifiableMap(map1);
        map1.put("D",4);
        System.out.println(map1);
//        map2.put("D",4); // throws UnsupportedOperationException
        System.out.println(map2);

        // max limit of Map.of() is 10
        Map<String, Integer> map3 = Map.of("A",1,"B",2,"C",3,"D",4);
        // below gives duplicate key error for "D"
//        Map<String, Integer> map3 = Map.of("A",1,"B",2,"C",3,"D",4,"D",5);
//        map3.put("E",5); // throws UnsupportedOperationException
        System.out.println(map3); // order is not maintained here

        // no max limit here, no duplicate keys can be inserted and no order is maintained
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("A",1),Map.entry("B",2),
                Map.entry("C",3),Map.entry("D",4));
//        map4.put("E",5); // throws UnsupportedOperationException
        System.out.println(map4); // order is not maintained here
    }

}
