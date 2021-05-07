package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElementInArrayOfIntegers {
    public static void main(String[] args) {
        System.out.println(mostFrequent(new Integer[]{1,2,2,3,3,3,4}));
    }

    static Integer mostFrequent(Integer[] numbers) {
        if(numbers == null || numbers.length == 0) {
            return null;
        }
        if(numbers.length == 1) {
            return numbers[0];
        }

        Integer result = 0;
        Integer maxCount = 0;
        for(Map.Entry<Integer,Integer> entry: numbersCounts(numbers).entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    private static Map<Integer,Integer> numbersCounts(Integer[] numbers) {
        Map<Integer,Integer> numbersCount = new HashMap<>();
        for (Integer number: numbers) {
            if(!numbersCount.containsKey(number)) {
                numbersCount.put(number,1);
            } else {
                numbersCount.put(number,numbersCount.get(number)+1);
            }
        }
        return numbersCount;
    }
}
