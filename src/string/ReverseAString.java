package string;

import java.util.Stack;

public class ReverseAString {
    public static void main(String[] args) {
//        System.out.println(reverseUsingStack("hello"));
//        System.out.println(reverseUsingRecurrence("hello"));
        System.out.println(reverseUsingIteration("hello"));
    }

    private static String reverseUsingIteration(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }
        if(input.length() < 2) {
            return input;
        }

        StringBuilder result = new StringBuilder();

        int idx = input.length() - 1;
        while (idx>=0) {
            result.append(input.charAt(idx));
            --idx;
        }

        return result.toString();
    }

    private static String reverseUsingRecurrence(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }
        if(input.length() < 2) {
            return input;
        }

        return reverseUsingRecurrence(input,0);
    }

    private static String reverseUsingRecurrence(String input, int cnt) {
        if(cnt<input.length()) {
            return reverseUsingRecurrence(input,cnt+1) + input.charAt(cnt);
        }
        return "";
    }

    private static String reverseUsingStack(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }
        if(input.length() < 2) {
            return input;
        }

        StringBuilder result = new StringBuilder();

        Stack<Character> helper = new Stack<>();
        for (char ch : input.toCharArray()) {
            helper.push(ch);
        }

        while (!helper.isEmpty()) {
            result.append(helper.pop());
        }

        return result.toString();
    }
}
