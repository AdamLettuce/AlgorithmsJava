package sorting.quick;

import sorting.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by adam on 23/03/2018.
 */
public class Quick_v1 extends SortingAlgorithm {

    @Override
    public List<Integer> sort(List<Integer> data) {
        if (data.size() < 2) {
            return data;
        }
        if (data.size() == 2) {
            if (data.get(0) > data.get(1)) {
                int tmp = data.get(0);
                data.set(0,data.get(1));
                data.set(1,tmp);
            }
            return data;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> pivot = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
//        int pivotIndex = data.size() / 2;
        int pivotIndex = new Random().nextInt(data.size());
        int pivotValue = data.get(pivotIndex);

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) < pivotValue) {
                left.add(data.get(i));
            }
            if (data.get(i) == pivotValue) {
                pivot.add(data.get(i));
            }
            if (data.get(i) > pivotValue) {
                right.add(data.get(i));
            }
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(sort(left));
        tmp.addAll(pivot);
        tmp.addAll(sort(right));
        return tmp;
    }




}
