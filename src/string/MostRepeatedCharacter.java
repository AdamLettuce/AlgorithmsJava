package string;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MostRepeatedCharacter {
    public static void main(String[] args) {
        System.out.println(find("Hellooo!!"));
    }

    private static String find(String s) {
        if(s==null) {
            throw new IllegalArgumentException();
        }
        Map<Character,Integer> characterCount = new TreeMap<>(Comparator.reverseOrder());
        for(Character ch: s.toCharArray()) {
            if(!characterCount.containsKey(ch)) {
                characterCount.put(ch,1);
            } else {
                characterCount.put(ch, characterCount.get(ch) + 1);
            }
        }

        return characterCount.keySet().iterator().next().toString();
    }
}
