package searching;

/**
 * Created by adam on 11/02/2018.
 */
public class LinearRecursive implements SearchingAlgorithm {

    @Override
    public int find(int[] data, int elementToFind) {
        return findInternal(data, elementToFind, 0);
    }

    public int findInternal(int[] data, int elementToFind, int index) {
        if (data[index] == elementToFind) {
            return index;
        } else if (index < data.length - 1) {
            return findInternal(data, elementToFind, index + 1);
        } else {
            return -1;
        }
    }
}
