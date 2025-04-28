package youtube.map.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * When key in WeakHashMap is weakly referenced then only JVM clears it.
 * When string object is created using strong reference or string literals, JVM won't clear it.
 * Also, we can ask JVM for garbage collection through code or else it will do this later when it wants.
 * */
public class WeakHashMapExample {

    public static void main(String[] args) {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        loadCache(imageCache);
        System.out.println(imageCache);
        System.gc(); // since key's scope is weakly referenced in this method, it will be cleared
        System.out.println("Cache after running (some entries may be cleared): " + imageCache);
    }

    private static void loadCache(Map<String, Image> imageCache) {
        // creating strong references for keys
        String key1 = new String("img1");
        String key2 = new String("img2");
        // here key is strong reference and value is weak
        imageCache.put(key1, new Image("Image 1"));
        imageCache.put(key2, new Image("Image 2"));
    }

}

class Image{

    private String name;

    public Image(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}