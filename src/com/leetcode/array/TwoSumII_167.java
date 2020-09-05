package com.leetcode.array;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/11 23:33
 * @Version 1.0
 */
public class TwoSumII_167 {
    /**
     * Given an array of integers that is already sorted in ascending order,
     *
     * find two numbers such that they add up to a specific target number.
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     *
     * where index1 must be less than index2.
     *
     * Note:
     *
     * Your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * Example:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     *
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = towSum2(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] towSum(int[] nums,int target){
        int[] res = new int[2];
        int min = 0;
        int max = nums.length - 1;
        while (min < max){
            if(nums[min] + nums[max] == target){
                res[0] = min + 1;
                res[1] = max  + 1;
                break;
            }else if(nums[min] + nums[max] < target){
                min++;
            }else if(nums[min] + nums[max] > target){
                max--;
            }
        }
        return res;
    }

    public static int[] towSum2(int[] nums,int target){
        int[] res = new int[2];
        ok : for(int i = 0;i < nums.length;i++){
            int left = i + 1;
            int right = nums.length;
            while (left < right){
                int mid = left + (right - left) / 2;
                if(nums[i] + nums[mid] == target){
                    res[0] = i + 1;
                    res[1] = mid  + 1;
                    break ok;
                }else if(nums[i] + nums[mid] < target){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

        }
        return res;
    }

}
