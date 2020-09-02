package com.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: dlm
 * @Date: 2020/2/17 23:11
 * @Description:
 */
public class ThreeSumClosest_16 {

    /**
     * 题目：
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     *
     * Example:
     *
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     *
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest2(nums,target);
        System.out.println(result);
    }

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0;i < nums.length - 2;i++){ //循环到倒数第三个
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(closest > Math.abs(target - (sum))){
                    closest = Math.abs(target - (sum)); //三数和跟给定值之间的差的绝对值最小
                    result = sum;
                }

                if(sum == target){
                    return result;
                }else if(sum < target){
                    start++;
                }else {
                    end--;
                }
            }
        }
        return result;
    }

    public static int threeSumClosest1(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0;i < nums.length - 2;i++){
            for(int j = i + 1;j < nums.length - 1;j++){
                for(int k = j + 1;k < nums.length;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(closest > Math.abs(target - (sum))){
                        closest = Math.abs(target - (sum));
                        result = sum;
                    }
                }
            }
        }
        return result;
    }



}