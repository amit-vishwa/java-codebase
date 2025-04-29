package youtube.map.sortedmap;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * SortedMap is an interface that extends Map and guarantees that the entries are sorted based on the keys,
 * either in their natural ordering or by a specified comparator.
 * SortedMap can be used when sub-map, first key, last key, head map or tail maps are required.
 *
 * Map interface can be used as reference when simply insertion, removal or access operations are required.
 * Also, when contains key or value is needed then simple Map can be used.
 *
 * NavigableMap interface can be used when other neighbour entries related to current entry or key is required.
 * It also provides a method to simple reverse the map in descending order.
 *
 * TreeMap class is used for sorting the map in natural order if Comparable is provided in key object.
 * If key is custom object which does not implement Comparable interface then the custom Comparator should be
 * provided in TreeMap constructor which creating TreeMap object.
 * */
public class SortedMapExample {

    public static void main(String[] args) {
//        sortedMapExample();
        navigableMapExample();
    }

    /**
     * TreeMap uses the self-balancing binary search tree which is Red Black tree.
     * While inserting the key, it always checks where the new key can be inserted so that sorting
     * logic is maintained.
     *
     * Time complexity is always O(log(n)) for insertion, deletion and accessing a key. For values, it will be n.
     * */
    private static void sortedMapExample() {
        // here key implements Comparable, if it didn't then Comparator must be provided in TreeMap
        SortedMap<String,Integer> sortedTreeMap = new TreeMap<>();
        // here custom comparator handles null pointer exception, so multiple null keys can be provided
        /*SortedMap<String,Integer> sortedTreeMap = new TreeMap<>((a,b)->{
            if(a != null && b != null){
                return b.compareTo(a);
            }
            if(a == null){
                return 1;
            }
            if(b == null){
                return -1;
            }
            return 0;
        });*/
        // we can also use Map but SortedMap provides extra useful methods
        sortedTreeMap.put("alex",90);
        sortedTreeMap.put("Bob",80);
        sortedTreeMap.put("Clara",95);
        sortedTreeMap.put("Rosy",90);
        sortedTreeMap.put("don",100);
//        sortedTreeMap.put(null,100); // gives null pointer exception due to sorting logic
//        sortedTreeMap.put(null,90); // gives null pointer exception due to sorting logic
        System.out.println(sortedTreeMap); // sorts lexicographically

        // methods in SortedMap
        System.out.println(sortedTreeMap.headMap("Rosy")); // excludes provided key
        System.out.println(sortedTreeMap.tailMap("Rosy")); // includes provided key
        System.out.println("First key: " + sortedTreeMap.firstKey() + ", Last key: " + sortedTreeMap.lastKey());
//        System.out.println(sortedTreeMap.subMap("Clara",null)); // includes fromKey, excludes toKey
        System.out.println(sortedTreeMap.subMap("Clara","alex")); // includes fromKey, excludes toKey

    }

    /**
     * NavigableMap extends SortedMap, providing more powerful navigation options such as finding the closest
     * matching key or retrieving the map in reverse order.
     * */
    private static void navigableMapExample() {
        NavigableMap<Integer,String> navigableTreeMap = new TreeMap<>();
        navigableTreeMap.put(1,"One");
        navigableTreeMap.put(5,"Five");
        navigableTreeMap.put(8,"Eight");
        navigableTreeMap.put(2,"Two");
        navigableTreeMap.put(0,"Zero");
        System.out.println(navigableTreeMap);

        // methods in NavigableMap
        System.out.println("Lower entry before 8: " + navigableTreeMap.lowerEntry(8));
        System.out.println("Lower key before 3: " + navigableTreeMap.lowerKey(3));
        System.out.println("Higher entry after 8: " + navigableTreeMap.higherEntry(8)); // null if not found
        System.out.println("Higher key after 3: " + navigableTreeMap.higherKey(3));
        System.out.println("Ceiling entry equals or after 6: " + navigableTreeMap.ceilingEntry(6));
        System.out.println("Ceiling key equals or after 9: " + navigableTreeMap.ceilingKey(9));
    }

}
