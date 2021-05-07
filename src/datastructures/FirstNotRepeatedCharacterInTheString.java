package datastructures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatedCharacterInTheString {
    public static void main(String[] args) {
        String input = "A Green Apple".toLowerCase();

        Map<Character,Integer> lettersCounts = new HashMap<>();

        char[] charArray = input.toCharArray();
        for(Character ch: charArray) {
            if(!lettersCounts.containsKey(ch)) {
                lettersCounts.put(ch,1);
            } else {
                lettersCounts.put(ch,lettersCounts.get(ch)+1);
            }
        }

        for(char ch: charArray) {
            if(lettersCounts.get(ch)==1) {
                System.out.println(ch);
                break;
            }

        }

    }
}
