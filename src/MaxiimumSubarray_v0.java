import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adam on 11/02/2018.
 */
public class MaxiimumSubarray_v0 {
    public static void main(String[] args) {
        int[] stockPrice = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int[] stockPriceDifference = calculateStockPriceDifferences(stockPrice);
        System.out.println(Arrays.toString(stockPriceDifference));
        System.out.println(findMaximumSubarrayOn2(stockPriceDifference));
    }

    private static Result findMaximumSubarrayOn2(int[] stockPriceDifference) {
        int resultI = 0;
        int resultJ = 0;
        int resultSum = -1;
        int sum = 0;
        for (int i = 0; i < stockPriceDifference.length; ++i) {
            sum = 0;
            for (int j = i; j < stockPriceDifference.length; j++) {
                sum += stockPriceDifference[j];
                if (sum > resultSum) {
                    resultI = i;
                    resultJ = j;
                    resultSum = sum;
                }
            }
        }

        return new Result(resultI, resultJ, resultSum);
    }

    private static Result findMaximumSubarrayOn3(int[] stockPriceDifference) {
        List<Result> results = new LinkedList<>();
        for (int subArrayLength = 2; subArrayLength <= stockPriceDifference.length; ++subArrayLength) {
            for (int i = 0; i < stockPriceDifference.length - subArrayLength; i++) {
                int sum = 0;
                int j = 0;
                for (j = i; j < i + subArrayLength; j++) {
                    sum += stockPriceDifference[j];
                }
                results.add(new Result(i, j - 1, sum));
            }
        }

        Result max = results.get(0);
        for (int i = 1; i < results.size(); i++) {
            if (results.get(i).getSum() > max.getSum()) {
                max = results.get(i);
            }
        }
        return max;
    }

    private static int[] calculateStockPriceDifferences(int[] stockPrice) {
        int[] stockPriceDifference = new int[stockPrice.length - 1];
        for (int i = 1; i < stockPrice.length; i++) {
            stockPriceDifference[i - 1] = stockPrice[i] - stockPrice[i - 1];
        }
        return stockPriceDifference;
    }

    private static final class Result {
        int beginIndex;
        int endIndex;
        int sum;

        public Result(int beginIndex, int endIndex, int sum) {
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
            this.sum = sum;
        }

        public int getBeginIndex() {
            return beginIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public int getSum() {
            return sum;
        }

        @Override
        public String toString() {
            return "{(" +
                    "beginIndex=" + beginIndex +
                    ", endIndex=" + endIndex +
                    "), sum=" + sum +
                    '}';
        }
    }
}
