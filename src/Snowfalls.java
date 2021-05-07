import java.util.Arrays;

/**
 * Created by adam on 01/05/2018.
 */
public class Snowfalls {
    public static void main(String[] args) {
        /**
         *
         * 9
         *                 ____
         *                |    |
         *      ____      |    |
         *     |    |  *  |    |           ____
         *     |    |  *  |    |  *   _*__|    |
         *     |    |  *  |    |  *  |    |    |      ____
         * ____|____|__*__|____|__*__|____|____|__*__|____|____
         *   0    1    2     3    4    5     6    7     8    9
         */
        System.out.println(getSum(new int[]{0, 4, 0, 6, 0, 2, 3, 0, 1, 0}));//9 --> example above
        System.out.println(getSum(new int[]{0, 1}));//0
        System.out.println(getSum(new int[]{0, 1, 0}));//0
        System.out.println(getSum(new int[]{1, 0, 1}));//1
        System.out.println(getSum(new int[]{6, 5, 6}));//1
        System.out.println(getSum(new int[]{1, 0, 1, 0, 1, 0, 1}));//3
        System.out.println(getSum(new int[]{2, 0, 2, 0, 2, 0, 2}));//6
        System.out.println(getSum(new int[]{2, 0, 4, 0, 4, 0, 2}));//8
    }

    private static int getSum(int[] data) {
        int[] snowfalls = new int[data.length];
        //go from left
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            snowfalls[i - 1] = max - data[i - 1];
            if (data[i] > max) {
                max = data[i];
            }
        }
        //go from right
        max = data[data.length - 1];
        for (int i = data.length - 2; i > 0; i--) {
            snowfalls[i+1] = Math.min(snowfalls[i+1], max - data[i+1]);
            if (data[i] > max) {
                max = data[i];
            }
        }
        //sum
        int sum = 0;
        for (int i = 0; i < snowfalls.length; i++) {
            sum += snowfalls[i];
        }
        return sum;
    }
}
