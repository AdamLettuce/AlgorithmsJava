package sorting.merge;

import sorting.SortingAlgorithm;

import java.util.Arrays;

/**
 * Created by adam on 10/02/2018.
 */
public class MergeSortWithSentinels extends SortingAlgorithm {
//not complete
    @Override
    public int[] sort(int[] data) {
        int[] copyOfData = Arrays.copyOf(data, data.length);
        sort(copyOfData, 0, copyOfData.length - 1);
        return copyOfData;
    }

    static void sort(int[] dataToSort, int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int middleIndex = (int) Math.floor(((double) beginIndex + (double) endIndex) / 2.0);
            sort(dataToSort, beginIndex, middleIndex);
            sort(dataToSort, middleIndex + 1, endIndex);
            merge(dataToSort, beginIndex, middleIndex, endIndex);
        }
    }

    private static void merge(int[] dataToSort, int beginIndex, int middleIndex, int endIndex) {
        int letfArraySize = middleIndex - beginIndex + 1;
        int rightArraySize = endIndex - middleIndex;
        int[] leftArray = new int[letfArraySize + 1];
        int[] rightArray = new int[rightArraySize + 1];
        int i;
        for (i = 0; i < letfArraySize; ++i) {
            leftArray[i] = dataToSort[beginIndex + i];
        }
        int j;
        for (j = 0; j < rightArraySize; ++j) {
            rightArray[j] = dataToSort[middleIndex + j + 1];
        }
        i = 0;
        j = 0;
        leftArray[letfArraySize] = Integer.MAX_VALUE;
        rightArray[rightArraySize] = Integer.MAX_VALUE;
        for (int k = beginIndex; k <= endIndex; ++k) {
            if (leftArray[i] <= rightArray[j]) {
                dataToSort[k] = leftArray[i];
                i++;
            } else {
                dataToSort[k] = rightArray[j];
                j++;
            }
        }
    }

}