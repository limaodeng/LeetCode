package com.leetcode.bit_manipulation;

import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/20 22:38
 * @Version 1.0
 */
public class SingleNumber_136 {

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     *
     * Note:
     *
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * Example 1:
     *
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     *
     * Input: [4,1,2,1,2]
     * Output: 4
     *
     */
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int result = getSingleNum(nums);
        System.out.println(result);
    }

    public static int getSingleNum(int[] nums){
        Set<Integer> set = new TreeSet<>();
        for(int i = 0;i < nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public static int getSingleNum2(int[] nums){
        int result = 0;
        for(int i = 0;i < nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}
