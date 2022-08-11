package leetcode;

public class MergeArray {

    public static void main(String[] args) {
        new MergeArray().merge(new int[]{0,0,0,0,0},0,new int[]{1,2,3,4,5},5);
        new MergeArray().mergeSimplified(new int[]{0,0,0,0,0},0,new int[]{1,2,3,4,5},5);
    }

    public void mergeSimplified(int[] nums1, int m, int[] nums2, int n) {

        int i = nums1.length-1;
        int i1 = m-1;
        int i2 = n-1;

        while(i1>=0 && i2>=0) {
            if(nums1[i1]>nums2[i2]) {
                nums1[i--] = nums1[i1--];
            } else {
                nums1[i--] = nums2[i2--];
            }
        }

        while(i>=0 && i2>=0) {
            nums1[i--] = nums2[i2--];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = nums1.length - 1;
        int i1 = m - 1;
        int i2 = n - 1;
        for (; i >= 0; --i) {
            if (i1 >= 0 && i2 >= 0) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[i] = nums1[i1--];
                } else {
                    nums1[i] = nums2[i2--];
                }
            } else {
                break;
            }
        }

        for (; i >= 0; --i) {
            if (i2 >= 0) {
                nums1[i] = nums2[i2--];
            }
        }
    }

}
