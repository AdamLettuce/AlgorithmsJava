package searching;


public class BinarySearchIterative implements SearchingAlgorithm {

    @Override
    public int find(int[] data, int elementToFind) {

        if (data == null || data.length == 0) {
            return -1;
        }

        return find(data, elementToFind, 0, data.length - 1);
    }

    private int find(int[] data, int elementToFind, int beginIndex, int endIndex) {
        while (beginIndex <= endIndex) {
            int m = (beginIndex + endIndex) / 2;
            if (elementToFind < data[m]) {
                endIndex = m - 1;
            }
            if (data[m] == elementToFind) {
                return m;
            }
            if (elementToFind > data[m]) {
                beginIndex = m + 1;
            }
        }
        return -1;
    }

}
