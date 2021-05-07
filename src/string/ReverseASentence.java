package string;

import java.util.Stack;

public class ReverseASentence {
    public static void main(String[] args) {
        System.out.println(reverse("Trees are beautiful"));
    }

    private static String reverse(String sentence) {
        if(sentence==null) {
            throw new IllegalArgumentException();
        }
        String[] words = sentence.split(" ");
        Stack<String> helper = new Stack<>();
        for(String word: words) {
            helper.push(word);
        }

        StringBuilder result = new StringBuilder();
        while(!helper.isEmpty()) {
            result.append(helper.pop()).append(" ");
        }
        return result.toString().trim();
    }
}
