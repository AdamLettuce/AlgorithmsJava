package sorting.insertion;

import sorting.SortingAlgorithm;

import java.util.Arrays;

/**
 * Created by adam on 02/02/2018.
 */
public class Insertion extends SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {
        int[] copyOfData = Arrays.copyOf(data,data.length);
        sortInternal(copyOfData);
        return copyOfData;
    }

    private void sortInternal(int[] data) {
        for (int index = 1; index < data.length; ++index) {
            int valueToSort = data[index];
            int previousIndex = index - 1;
            while (previousIndex >= 0 && valueToSort < data[previousIndex]) {
                data[previousIndex + 1] = data[previousIndex--];
            }
            data[previousIndex + 1] = valueToSort;
        }
    }
}
