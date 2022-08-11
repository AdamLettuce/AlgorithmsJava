package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pascals_Triangle_II_113_Solution {

    static Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

    public static void main(String[] args) {
        int rowIndex = 34;
        for (int i = 0; i <= rowIndex; i++) {
            getRow(i);
        }
        System.out.println(getRow(rowIndex));
    }


    static public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            result.add(row(rowIndex, i));
        }
        return result;
    }

    private int rowWithoutCache(int rowIndex, int columnIndex) {
        if (rowIndex == 0 || columnIndex == 0 || columnIndex == rowIndex) {
            return 1;
        }
        return row(rowIndex - 1, columnIndex - 1) + row(rowIndex - 1, columnIndex);
    }

    private static int row(int rowIndex, int columnIndex) {
        if (!cache.containsKey(rowIndex)) {
            cache.put(rowIndex, new HashMap<>());
        }

        if (columnIndex == 0 || columnIndex == rowIndex) {
            cache.get(rowIndex).put(columnIndex, 1);
        }
        if (columnIndex > 0 && columnIndex < rowIndex) {
            int a = cache.get(rowIndex - 1).get(columnIndex - 1);
            int b = cache.get(rowIndex - 1).get(columnIndex);
            cache.get(rowIndex).put(columnIndex, a + b);
        }
        return cache.get(rowIndex).get(columnIndex);
    }
}