package string;

import java.util.LinkedList;
import java.util.Queue;

public class IsStringRotation {
    public static void main(String[] args) {
        System.out.println(true==validate("ABCD","DABC"));
        System.out.println(true==validate("ABCD","CDAB"));
        System.out.println(false==validate("ABCD","ADBC"));
    }

    private static boolean validate(String first, String second) {
        if(first == null || second == null) {
            throw new IllegalArgumentException();
        }

        if(first.length()!=second.length()) {
            return false;
        }

        if(first.equals(second)) {
            return true;
        }

//        Queue<Character> firstHelper = getCharacters(first);
//        Queue<Character> secondHelper = getCharacters(second);
//
//        int maximumRotations = first.length();
//        int rotationCount = 0;
//
//
//        while(rotationCount < maximumRotations) {
//            firstHelper.add(firstHelper.remove());
//            if(firstHelper.toString().equals(secondHelper.toString())) {
//                return true;
//            }
//            ++rotationCount;
//        }
//
//
//        return false;

        //this solution is good only if we don't have very long strings, otherwise we should iterate
//        return first != null && second != null && first.length() == second.length() && (first+first).contains(second);

        int firstIndexOfSecondInFirst = first.indexOf(second.charAt(0));
        int i = firstIndexOfSecondInFirst;
        int j = 0;
        while(j<second.length()) {
            if(first.charAt(i)!=second.charAt(j)) {
                return false;
            }
            i=(i+1)%first.length();
            ++j;
        }

        return true;
    }

    private static Queue<Character> getCharacters(String first) {
        Queue<Character> helper = new LinkedList<>();
        for (Character ch: first.toCharArray()) {
            helper.add(ch);
        }
        return helper;
    }
}
