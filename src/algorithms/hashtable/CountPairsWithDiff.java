package algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

public class CountPairsWithDiff {
    public static void main(String[] args) {
        System.out.println(countPairsWithDiff(new int[]{1,7,5,9,2,12,3}, 2));
    }

    private static int countPairsWithDiff(int[] numbers, int K) {
        if(numbers == null || numbers.length < 2) {
            return 0;
        }
        int count = 0;

        Set<Integer> numbersSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersSet.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            if(numbersSet.contains(numbers[i]+K)) {
                ++count;
            }
            if(numbersSet.contains(numbers[i]-K)) {
                ++count;
            }
            numbersSet.remove(numbers[i]);
        }

        return count;
    }
}
