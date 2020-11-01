package com.leetcode.dynamic_program;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/11/1 22:33
 * @Version 1.0
 */
public class ClimbingStairs_70 {

    /**
     * You are climbing a stair case.
     *
     * It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps.
     *
     * In how many distinct ways can you climb to the top?
     *
     * Example 1:
     *
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     *
     * Constraints:
     *
     * 1 <= n <= 45
     */
    public static void main(String[] args) {

    }

    // 动态规划
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 2;
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    //斐波那契数列通项公式
    public int climbStairs1(int n) {
        double root5 = Math.sqrt(5); //根号5
        double res =  (1 / root5) * (Math.pow((1 + root5) / 2, n + 1) - Math.pow((1 - root5) / 2, n + 1));
        return (int)res;
    }

}
