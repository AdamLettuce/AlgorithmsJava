package collectionsTests;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"1");
        hashMap.put(2,"2");
        hashMap.put(100,"100");
        hashMap.put(3,"3");
        for(Map.Entry<Integer,String> me: hashMap.entrySet()) {
            System.out.println(me.getKey());
        }
    }
}
