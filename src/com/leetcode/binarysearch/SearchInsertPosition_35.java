package com.leetcode.binarysearch;

/**
 * @ClassComment: 搜索插入位置
 * @Auther: dlm
 * @Date: 2020/11/4 00:33
 * @Version 1.0
 */
public class SearchInsertPosition_35 {

    /**
     *
     *  Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     *
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     * Example 4:
     *
     * Input: nums = [1,3,5,6], target = 0
     * Output: 0
     * Example 5:
     *
     * Input: nums = [1], target = 0
     * Output: 0
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     *
     */
    public static void main(String[] args) {

    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public int searchInsert1(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

}
