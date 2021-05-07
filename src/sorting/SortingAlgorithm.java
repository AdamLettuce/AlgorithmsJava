package sorting;

import util.ArrayUtil;

import java.util.List;

/**
 * Created by adam on 11/02/2018.
 */
public abstract class SortingAlgorithm {

    private ArrayUtil arrayUtil = new ArrayUtil();

    public List<Integer> sort(List<Integer> data) {
        return arrayUtil.toList(sort(arrayUtil.toArray(data)));
    }

    public int[] sort(int[] data) {
        List<Integer> i = arrayUtil.toList(data);
        return arrayUtil.toArray(sort(i));
    }

}