package string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String text = "a green apple";
        System.out.println(find(text));
    }

    private static char find(String text) {
        char[] characters = text.toCharArray();
        Map<Character, Integer> charactersCount = new LinkedHashMap<>();
        for (char character: characters) {
            if(character==' ') {
                continue;
            }
            charactersCount.putIfAbsent(character,0);
            charactersCount.put(character, charactersCount.get(character)+1);
        }
        for(Map.Entry<Character,Integer> entry: charactersCount.entrySet()) {
            if(entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
