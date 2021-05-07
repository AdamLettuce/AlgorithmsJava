/**
 * Created by adam on 12/02/2018.
 */
public class MaximumSubarray {

    Result find_Maximum_Subarray(int[] A, int low, int high) {
        if(high==low) {
            return new Result(low,high,A[low]);
        } else {
            int mid = (low+high)/2;
        }
        return null;
    }

    Result find_Max_Crossing_Subarray(int[] A,int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE;
        int max_left =0;//my addition
        int sum = 0;
        for (int i = 0; i < high; i++) {
            sum = sum + A[i];
            if(sum>left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }

        int right_sum = Integer.MIN_VALUE;
        int max_right = 0;
        sum = 0;
        for (int j = mid+1; j < high; j++) {
            sum = sum + A[j];
            if(sum>right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }

        return new Result(max_left,max_right,left_sum+right_sum);
    }
}

class Result {
    int max_left;
    int max_right;
    int left_sum_plus_right_sum;

    public Result(int max_left, int max_right, int left_sum_plus_right_sum) {
        this.max_left = max_left;
        this.max_right = max_right;
        this.left_sum_plus_right_sum = left_sum_plus_right_sum;
    }

    public int getMax_left() {
        return max_left;
    }

    public int getMax_right() {
        return max_right;
    }

    public int getLeft_sum_plus_right_sum() {
        return left_sum_plus_right_sum;
    }
}
