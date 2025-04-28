package youtube.map.identityhashmap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {

    public static void main(String[] args) {
        hashmapVsIdentity();
    }

    private static void hashmapVsIdentity() {
        // simple hashmap
        String key1 = new String("key");
        String key2 = new String("key");
        // hashmap uses hashcode and equals (i.e. checks contents) to insert element at index
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put(key1,1); // key, 1
        hashMap.put(key2,2); // key, 2
        System.out.println("Key1 equals Key2 ? " + (key1.hashCode()==key2.hashCode())); // true since hashcode is same
        System.out.println("HashMap: " + hashMap);

        // identity hashmap uses identity hashcode and equality (i.e. == checks memory references) to insert element at index
        Map<String,Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(key1,1);
        identityHashMap.put(key2,2);
        System.out.println("Key1 equals Key2 ? " + (System.identityHashCode(key1)==System.identityHashCode(key2)));
        // identity hashmap uses hashcode of Object class i.e. using memory address, so it is always unique for objects
        System.out.println("IdentityHashMap: " + identityHashMap);
    }

}
