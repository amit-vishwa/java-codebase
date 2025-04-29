package youtube.map.enummap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * EnumMap consist of array of size same as provided enum, no hashing is performed here hence it is faster than HashMap.
 * It is memory efficient as well. Ordinal or index is used to store values for enum keys since duplicate
 * enum keys cannot be created.
 * */
public class EnumMapExample {

    public static void main(String[] args) {
        simpleEnumMapExample();
    }

    private static void simpleEnumMapExample() {
//        Map<Day,String> enumMap = new HashMap<>(); // slower for enum keys
        Map<Day,String> enumMap = new EnumMap<>(Day.class); // faster and memory efficient when keys are enum
        enumMap.put(Day.SATURDAY,"Sleep");
        enumMap.put(Day.TUESDAY,"Gym");
        enumMap.put(Day.MONDAY,"Walk");
        System.out.println(enumMap);
        System.out.println("MONDAY: " + enumMap.get(Day.MONDAY) + ", SUNDAY: " + enumMap.get(Day.SUNDAY));
    }

}

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
