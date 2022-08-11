package dynamic;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber_leetcode_198 {

    public static void main(String[] args) {
        HouseRobber_leetcode_198 h = new HouseRobber_leetcode_198();
        System.out.println(9 == h.rob(new int[]{9}));
        h = new HouseRobber_leetcode_198();
        System.out.println(9 == h.rob(new int[]{2, 9}));
        h = new HouseRobber_leetcode_198();
        System.out.println(4 == h.rob(new int[]{1, 2, 3, 1}));
        h = new HouseRobber_leetcode_198();
        System.out.println(12==h.rob(new int[]{2, 7, 9, 3, 1}));
        h = new HouseRobber_leetcode_198();
        System.out.println(20==h.rob(new int[]{2, 17, 9, 3, 1}));
    }

    private final HashMap<Integer, Integer> memo = new HashMap<>();
    private int[] nums;

    private int dp(int i) {
        // Base cases
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if (!memo.containsKey(i)) {
            memo.put(i, Math.max(dp(i - 1), dp(i - 2) + nums[i])); // Recurrence relation
        }
        return memo.get(i);
    }

    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length - 1);
    }

//    public static int rob(int[] a) {
//        int result = 0;
//        if (a.length == 1) {
//            return a[0];
//        }
//        if (a.length == 2) {
//            return Integer.max(a[0], a[1]);
//        }
//        if (a.length == 3) {
//            return Integer.max(a[0] + a[2], a[1]);
//        }
//        if (a.length == 4) {
//            return Integer.max(Integer.max(a[0] + a[2], a[1] + a[3]), a[0] + a[3]);
//        }
//        if (a.length == 5) {
//            return Integer.max(Integer.max(Integer.max(Integer.max(a[0] + a[2] + a[4], a[1] + a[3]), a[0] + a[3]), a[1] + a[4]), a[0] + a[4]);
//        }
//        return result;
//    }

    //Wont work for this case: [2,1,1,2]
    //result should be 4, not 3
    public int rob_wont_work(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Integer.max(nums[0], nums[1]);
        }

        int result = 0;

        int max1 = 0;
        for (int i = 0; i < nums.length; i += 2) {
            max1 += nums[i];
        }

        int max2 = 0;
        for (int i = 1; i < nums.length; i += 2) {
            max2 += nums[i];
        }

        return Integer.max(max1, max2);
    }

}
