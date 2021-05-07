package algo;

public class OddArray {

    public static void main(String[] args) {
        System.out.println(new OddArray().solution(new int[]{9,3,9,3,9,7,9}));
    }

    public int solution(int[] A) {
        long data[] = new long[1000001];
        for (int i = 0; i < A.length; i++) {
            data[A[i]]+=1;
        }
        for (int i = 0; i < data.length; i++) {
            if(data[i]==1) {
                return i;
            }
        }
        return 0;
    }
}
