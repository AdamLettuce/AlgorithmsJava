package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main(String[] args) {
//        System.out.println(validateUsingSorting("abcda","aadbc"));
        System.out.println(validateUsingHistogram("abcd","adbc"));
    }

    private static boolean validateUsingSorting(String first, String second) {
        if(first==null || second == null) {
            return false;
        }
        if(first.length()!=second.length()) {
            return false;
        }

        char[] firstSorted = first.toCharArray();
        Arrays.sort(firstSorted);

        char[] secondSorted = second.toCharArray();
        Arrays.sort(secondSorted);

        int i=0;
        while (i<first.length()) {
            if(firstSorted[i]!=secondSorted[i++]) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateUsingHistogram(String first, String second) {
        if(first==null || second == null) {
            return false;
        }
        if(first.length()!=second.length()) {
            return false;
        }

        Map<Character,Integer> firstHistogram = buildHistogram(first);
        Map<Character,Integer> secondHistogram = buildHistogram(second);
        return !firstHistogram.entrySet().stream().anyMatch(e->e.getValue()!=secondHistogram.get(e.getKey()));
    }

    private static Map<Character,Integer> buildHistogram(String first) {
        Map<Character,Integer> histogram = new HashMap<>();
        for (Character ch: first.toCharArray()) {
            if(!histogram.containsKey(ch)) {
                histogram.put(ch,1);
            } else {
                histogram.put(ch,histogram.get(ch)+1);
            }
        }
        return histogram;
    }
}
