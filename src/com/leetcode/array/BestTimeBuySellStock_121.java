package com.leetcode.array;

/**
 * @Auther: dlm
 * @Date: 2020/11/9 10:07
 * @Description: 买卖股票的最佳时间
 */
public class BestTimeBuySellStock_121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = Integer.MAX_VALUE;
        for(int price : prices){
            buy = Math.min(buy,price);
            res = Math.max(res,price - buy);
        }

        return res;
    }

}
