package string;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("Hellooo!!!"));
    }

    private static String removeDuplicates(String input) {
        Set<Character> uniqueCharacters = new LinkedHashSet<>();
        for (Character ch : input.toCharArray()) {
            uniqueCharacters.add(ch);
        }
        return uniqueCharacters.stream().map(Object::toString).collect(Collectors.joining());
    }
}
