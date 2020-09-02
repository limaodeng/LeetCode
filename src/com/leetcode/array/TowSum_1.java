package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: dlm
 * @Date: 2020/2/13 16:22
 * @Description:
 */
public class TowSum_1 {

    /**
     * 题目：
     *
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     */

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int [] result = twoSum3(nums,target);
        System.out.println(result[0]+"---"+result[1]);
    }

    public static int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.get(target - nums[i]) != null && map.get(target - nums[i]) != i ){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i = 0;i < nums.length;i++){
            if(map.get(target - nums[i]) != null && map.get(target - nums[i]) != i ){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }
        return result;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        loop:
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++ ){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break loop;
                }
            }
        }
        return result;
    }

}