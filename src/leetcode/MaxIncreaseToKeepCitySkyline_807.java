package leetcode;
import java.util.Arrays;

import static java.lang.Math.*;

public class MaxIncreaseToKeepCitySkyline_807 {

    public static void main(String[] args) {
        int [][] data = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        new MaxIncreaseToKeepCitySkyline_807().maxIncreaseKeepingSkyline(data);
    }


        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int[] leftRightMax = new int[grid.length];
            int[] topBottomMax = new int[grid.length];

            leftRightMax[0] = grid[0][0];
            topBottomMax[0] = grid[0][0];
            for(int i=0;i<grid.length;++i) {
                for(int j=0;j<grid.length;++j) {
                    if(grid[i][j]>leftRightMax[i]) {
                        leftRightMax[i] = grid[i][j];
                    }
                    if(grid[j][i]>topBottomMax[i]) {
                        topBottomMax[i] = grid[j][i];
                    }
                }
            }

            System.out.println(Arrays.toString(leftRightMax));
            System.out.println(Arrays.toString(topBottomMax));

            int result = 0;
            for(int i=0;i<grid.length;++i) {
                for(int j=0;j<grid.length;++j) {
                    result += abs(min(leftRightMax[i], topBottomMax[j])-grid[i][j]);
                }
            }

            return result;
        }

}
