package com.leetcode.array;

/**
 * @Auther: dlm
 * @Date: 2020/2/19 00:30
 * @Description:
 */
public class SearchRotatedArray_33 {
    /**
     * 题目：
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */
    public static void main(String[] args) {
        int[] nums = {7,0,1,2,4,5,6};
        int target = 7;
        int result = search(nums,target);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2 ;

            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < nums[right]){   //中间的数小于右边的数，右边有序，左边无序
                if(target > nums[middle] && target <= nums[right]){
                    left = middle + 1;
                }else {
                    right = middle - 1;
                }
            }else { //中间的数大于右边的数，左边有序，右边无序
                if(target < nums[middle] && target >= nums[left]){
                    right = middle - 1;
                }else {
                    left = left + 1;
                }
            }
        }
        return -1;
    }

}