package sorting.bubble;

import sorting.SortingAlgorithm;

import java.util.Arrays;

/**
 * Created by adam on 11/02/2018.
 */
public class BubbleFromFront extends SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {
        int[] copyOfData = Arrays.copyOf(data,data.length);
        sortInternal(copyOfData);
        return copyOfData;
    }

    private void sortInternal(int[] data) {
        for (int i = data.length; i > 0; i--) {
            for (int j = 1; j < data.length; j++) {
                if (data[j - 1] > data[j]) {
                    int tmp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }

}
