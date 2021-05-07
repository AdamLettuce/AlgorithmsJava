package prefix_sum;

import util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by adam on 07/03/2018.
 * You are given a non-empty, zero-indexed array A of n (1   n   100 000) integers a0, a1, . . . , an−1 (0   ai   1 000). This array represents number of mushrooms growing on the consecutive spots along a road. You are also given integers k and m (0   k, m < n).
 * A mushroom picker is at spot number k on the road and should perform m moves. In one move she moves to an adjacent spot. She collects all the mushrooms growing on spots she visits. The goal is to calculate the maximum number of mushrooms that the mushroom picker can collect in m moves.
 * For example, consider array A such that: 0123456
 * The mushroom picker starts at spot k = 4 and should perform m = 6 moves. She might move to spots 3,2,3,4,5,6 and thereby collect 1+5+7+3+9 = 25 mushrooms. This is the maximal number of mushrooms she can collect.
 */
public class MushroomPicker {
    public static void main(String[] args) {
        int A[] = new int[]{2, 3, 7, 5, 1, 3, 9};
        int k = 4;//start position
        int m = 6;//number of moves
//        System.out.println(solutionOn2(A, k, m));
        System.out.println(solutionOnm(A, k, m));
    }

    /*
    Solution O(m2):
    Note that the best strategy is to move in one direction optionally followed by some moves in the opposite direction.
    In other words, the mushroom picker should not change direction more than once.
    With this observation we can find the simplest solution.
    Make the first p = 0,1,2,...,m moves in one direction, then the next m − p moves in the opposite direction.
    This is just a simple simulation of the moves of the mushroom picker which requires O(m2) time.
    */
    private static int solutionOn2(int[] A, int k, int m) {
        Set<Integer> results = new TreeSet<>(Comparator.reverseOrder());
        for (int i = -1; i <= 1; i += 2) {
            int[] B = Arrays.copyOf(A, A.length);
            int result = 0;
            int direction = i;
            int tmpK = k;
            int tmpM = m;
            while (tmpM >= 0) {
                result += B[tmpK];
                B[tmpK] = 0;
                tmpK += direction;
                if (tmpK == B.length - 1 || tmpK == 0) {
                    direction *= -1;
                }
                --tmpM;
            }
            results.add(result);
        }
        return results.iterator().next();
    }

    /*
    Solution O(n+m): A better approach is to use prefix sums.
    If we make p moves in one direc- tion, we can calculate the maximal opposite location of the mushroom picker.
    The mushroom picker collects all mushrooms between these extremes.
    We can calculate the total number of collected mushrooms in constant time by using prefix sums.
    k - spot number
    m - number of moves
     */
    private static int solutionOnm(int[] A, int k, int m) {
        int prefixSums[] = new ArrayUtil().prefixSum(A);


        int endIndexGoRight = getEndIndexGo(A, m, k, 1);

        int beginIndexGoRight = k;
        if(endIndexGoRight==k) {
            endIndexGoRight = A.length-1;
        }
        if(endIndexGoRight<k) {
            beginIndexGoRight=endIndexGoRight;
            endIndexGoRight = A.length-1;
        }

        int endIndexGoLeft = getEndIndexGo(A, m, k, -1);
        int beginIndexGoLeft = k;
        if(beginIndexGoLeft-m<0) {
            beginIndexGoLeft =0;
        }
        if(endIndexGoLeft<k && beginIndexGoLeft-m<0) {
            endIndexGoLeft = k;
        }

        int sumGoRight = new ArrayUtil().sliceSum(A,Math.min(beginIndexGoRight,endIndexGoRight),Math.max(beginIndexGoRight,endIndexGoRight));
        int sumGoLeft = new ArrayUtil().sliceSum(A,Math.min(beginIndexGoLeft,endIndexGoLeft),Math.max(beginIndexGoLeft,endIndexGoLeft));

        return Math.max(sumGoLeft,sumGoRight);

    }

    private static int getEndIndexGo(int[] A, int tmpM, int endIndex, int direction) {
        while (tmpM > 0) {
            if (endIndex == A.length - 1 || endIndex == 0) {
                direction *= -1;
            }
            endIndex += direction;
            tmpM--;
        }
        return endIndex;
    }


}
