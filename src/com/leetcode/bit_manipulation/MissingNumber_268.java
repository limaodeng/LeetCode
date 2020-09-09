package com.leetcode.bit_manipulation;

import java.util.Arrays;

/**
 * @Auther: dlm
 * @Date: 2020/9/9 09:03
 * @Description:
 */
public class MissingNumber_268 {

    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
     *
     * find the one that is missing from the array.
     *
     * Example 1:
     *
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     *
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     *
     * Note:
     * Your algorithm should run in linear runtime complexity.
     *
     * Could you implement it using only constant extra space complexity?
     *
     */
    public static void main(String[] args) {
        int[] nums = {0,2,4,5,1};
        System.out.println(missingNumber3(nums));
    }

    //二分查找
    public static int missingNumber3(int[] nums) {
        //排序
        Arrays.sort(nums);
        //二分查找
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(mid < nums[mid]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }

    //位运算：异或
    public static int missingNumber2(int[] nums) {
        //因为res为0，所以从i+1开始
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            res ^= (i+1) ^ nums[i];
        }
        return res;
    }

    //求和公式
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        return new Double(0.5 * n * (1 + n) - sum).intValue();
    }

}
