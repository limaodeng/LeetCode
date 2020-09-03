package com.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/11 23:04
 * @Version 1.0
 */
public class TwoSum1 {
    /**
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
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = towSum(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] towSum(int[] nums,int target){
        int[] res = new int[2];
        for(int i = 0; i < nums.length;i++){
            for(int j = i + 1; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static int[] towSum2(int[] nums,int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length;i++){
            if(map.get(target - nums[i]) != null && map.get(target - nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
        }
        return res;
    }

    public static int[] towSum3(int[] nums,int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.get(target - nums[i]) != null){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }

}
