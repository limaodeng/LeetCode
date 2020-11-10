package com.leetcode.dynamic_program;

/**
 * @Auther: dlm
 * @Date: 2020/11/10 09:24
 * @Description:最短路径
 */
public class MinimumPathSum_64 {

    /**
     *
     * Given a m x n grid filled with non-negative numbers,
     *
     * find a path from top left to bottom right,
     *
     * which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * Example 2:
     *
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     *
     */
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int dp[][] = new int[maxRow][maxCol];

        dp[0][0] = grid[0][0];

        //第一行
        for(int i = 1;i <maxRow;i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }


        //第一列
        for(int i = 1;i < maxCol;i++){
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for(int i = 1;i < maxRow; i++){
            for(int j = 1;j < maxCol;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[maxRow-1][maxCol-1];
    }

}
