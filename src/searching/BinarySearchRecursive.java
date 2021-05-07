package searching;


public class BinarySearchRecursive implements SearchingAlgorithm {

    @Override
    public int find(int[] data, int elementToFind) {

        if (data == null || data.length == 0) {
            return -1;
        }

        return find(data, elementToFind, 0, data.length - 1);
    }

    private int find(int[] data, int elementToFind, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return -1;
        }
        int m = (beginIndex + endIndex) / 2;
        if (elementToFind < data[m]) {
            return find(data, elementToFind, beginIndex, m - 1);
        }
        if (data[m] == elementToFind) {
            return m;
        }
        if (elementToFind > data[m]) {
            return find(data, elementToFind, m + 1, endIndex);
        }
        return -1;
    }

}
