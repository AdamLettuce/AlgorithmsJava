package datastructures;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        Set<Character> characterSet = new HashSet<>();
        String input = "green apple";
        for(char character: input.toCharArray()) {
            if(characterSet.contains(character)) {
                System.out.println(character);
                break;
            } else {
                characterSet.add(character);
            }
        }
    }
}
