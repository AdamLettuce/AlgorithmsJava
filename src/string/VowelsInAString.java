package string;

import java.util.HashSet;
import java.util.Set;

public class VowelsInAString {
    public static void main(String[] args) {
        String input = "hello";
        System.out.println(find(input));
    }

    private static int find(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }
        int reslut = 0;
        String trimmed = input.trim();
        if(trimmed.length()<1) {
            return reslut;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        char[] lowerCase = trimmed.toLowerCase().toCharArray();
        for (int i = 0; i < lowerCase.length; i++) {
            if(vowels.contains(lowerCase[i])) {
                ++reslut;
            }
        }
        return reslut;
    }
}
