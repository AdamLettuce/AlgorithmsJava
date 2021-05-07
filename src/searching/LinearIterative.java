package searching;

/**
 * Created by adam on 11/02/2018.
 */
public class LinearIterative implements SearchingAlgorithm {
    @Override
    public int find(int[] data, int elementToFind) {
        for (int i = 0; i < data.length; i++) {
            if(data[i]==elementToFind){
                return i;
            }
        }
        return -1;
    }
}
