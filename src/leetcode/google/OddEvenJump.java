package leetcode.google;


public class OddEvenJump {

    public static void main(String[] args) {
        System.out.println(new OddEvenJump().oddEvenJumps(new int[]{10,13,12,14,15}));
        System.out.println(new OddEvenJump().oddEvenJumps(new int[]{2,3,1,1,4}));
        System.out.println(new OddEvenJump().oddEvenJumps(new int[]{5,1,3,4,2}));
    }

    //This is only for 62/64 test cases, doesn't work well on a big test data :(
    private int oddEvenJumps(int[] A) {
        int goodStartingIndices = 1;

        for(int startingIndex=0;startingIndex<A.length-1;++startingIndex) {

            int i = startingIndex;
            int jumpsCounter = 1;

            while (i<A.length-1) {
                if (jumpsCounter % 2 == 1) {
                    Integer minPair = minPair(A, i);
                    if(minPair != null) {
                        i = minPair;
                        ++jumpsCounter;
                    } else {
                        break;
                    }
                } else {
                    Integer maxPair = maxPair(A, i);
                    if(maxPair != null) {
                        i = maxPair;
                        ++jumpsCounter;
                    } else {
                        break;
                    }
                }
                if(i == A.length - 1) {
                    ++goodStartingIndices;
                    break;
                }
            }
        }
        return goodStartingIndices;
    }


    private Integer maxPair(int[] a, int i) {
        int max = -1;
        Integer result = null;
        for(int j = i +1; j < a.length; ++j) {
            if(a[i]>= a[j] && a[j]>max) {
                max = a[j];
                result = j;
            }
        }
        return result;
    }


    private Integer minPair(int[] a, int i) {
        int min = 100000;
        Integer result = null;
        for(int j = i +1; j < a.length; ++j) {
            if(a[i]<= a[j] && a[j]<min) {
                min = a[j];
                result = j;
            }
        }
        return result;
    }

}