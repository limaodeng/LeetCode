package com.leetcode.math;

/**
 * @Auther: dlm
 * @Date: 2020/9/27 09:17
 * @Description:
 */
public class MajorityElement_169 {

    /**
     * Given an array of size n, find the majority element.
     *
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and
     *
     * the majority element always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     */
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    //摩尔投票法
    public static int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                res = num;
                count++;
            }else if(res == num){
                count++;
            }else {
                count--;
            }
        }
        return res;
    }

}
