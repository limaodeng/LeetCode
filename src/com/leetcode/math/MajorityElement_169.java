package com.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println(majorityElement2(nums));
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

    //位运算
    public static int majorityElement2(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) break;
                if ((num & (1 << i)) != 0) {
                    ++ones;
                }else{
                    ++zeros;
                }
            }
            if (ones > zeros) {
                res |= (1 << i);
            }
        }
        return res;
    }

    //排序取中间的数
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //HashMap
    public static int majorityElement4(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num) > nums.length / 2){
                return num;
            }
        }
        return -1;
    }

}
