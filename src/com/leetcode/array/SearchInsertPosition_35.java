package com.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: dlm
 * @Date: 2020/2/24 01:07
 * @Description:
 */
public class SearchInsertPosition_35 {

    /**
     * 题目：
     * Given a sorted array and a target value,
     * return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     *
     * You may assume no duplicates in the array.
     *
     * Example 1:
     *
     * Input: [1,3,5,6], 5
     * Output: 2
     * Example 2:
     *
     * Input: [1,3,5,6], 2
     * Output: 1
     * Example 3:
     *
     * Input: [1,3,5,6], 7
     * Output: 4
     * Example 4:
     *
     * Input: [1,3,5,6], 0
     * Output: 0
     *
     */
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        int result = searchInsert(nums,target);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1]){
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (target < nums[middle]){
                right = middle;
            }else if(target > nums[middle]){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return right;
    }

    public static int searchInsert1(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

}