package com.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: dlm
 * @Date: 2020/2/24 00:13
 * @Description:
 */
public class FindFirstLastPosition_34 {
    /**
     * 题目：
     * Given an array of integers nums sorted in ascending order,
     *
     * find the starting and ending position of a given target value.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * If the target is not found in the array, return [-1, -1].
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     *
     */
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(nums,target);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] searchRange(int[] nums, int target) {
        int result[] = {-1,-1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){  //寻找第一个等于target的数
            int middle = left + (right - left) / 2;
            if(target > nums[middle]){
                left = middle + 1;
            }else if(target < nums[middle]){
                right = middle - 1;
            }else { //等于的时候
                //如果当前为第一个元素或者当前元素的前一个元素不等于target
                //则当前元素第一个等于target的数
                //否则继续往前找
                if(middle == 0 || nums[middle-1] != target){
                    result[0] = middle;
                    break;
                }else{
                    right = middle - 1;
                }
            }
        }

        right = nums.length - 1;
        while (left <= right){  //寻找最后个等于target的数
            int middle = left + (right - left) / 2;
            if(target > nums[middle]){
                left = middle + 1;
            }else if(target < nums[middle]){
                right = middle - 1;
            }else { //等于的时候
                //如果当前为最后一个元素或者当前元素的后一个元素不等于target
                //则当前元素最后一个等于target的数
                //否则继续往后找
                if (middle == nums.length - 1 || nums[middle + 1] != target){
                    result[1] = middle;
                    break;
                }else {
                    left = middle + 1;
                }
            }
        }
        return result;
    }

}