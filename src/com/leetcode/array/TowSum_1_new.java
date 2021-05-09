package com.leetcode.array;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2021/5/9 15:26
 * @Version 1.0
 */
public class TowSum_1_new {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     *
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     *
     *
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     *
     * Constraints:
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     */
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target = 6;
        int[] res = towSum3(arr, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }


    /**
     * 方式3：单层循环，使用map缓存辅助
     */
    public static int[] towSum3(int[] arr,int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < arr.length;i++){
            if(map.get(target - arr[i]) != null){
                res[0] = i;
                res[1] = map.get(target - arr[i]);
                break;
            }

            map.put(arr[i],i);
        }

        return res;
    }


    /**
     * 方式2：两个单层循环，使用map缓存辅助
     */
    public static int[] towSum2(int[] arr,int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //第一层循环
        // 将数组循环放入map中，key对应数组的值，value对应数组的角标
        for(int i = 0;i < arr.length;i++){
            map.put(arr[i],i);
        }

        //第二层循环
        //循环将数据中的数拿出来，与map中的数进行匹配
        for(int j = 0;j < arr.length;j++){
            //如果map中存在target - arr[j]的数，则说明找到两个目标值的下标：j和map.get(target - arr[j])
            //但是需要注意的是，map.get(target - arr[j])的值不能是j本身
            if(map.get(target - arr[j]) != null
                    && map.get(target - arr[j]) != j){
                res[0] = j;
                res[1] = map.get(target - arr[j]);
                break;
            }
        }

        return res;
    }

    /**
     * 方式1：两层遍历
     */
    public static int[] towSum1(int[] arr,int target){
        int[] res = new int[2];
        ok : for(int i = 0;i < arr.length;i++){
            for(int j = i + 1;j < arr.length;j++){
                if(arr[i] + arr[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break ok;
                }
            }
        }
        return res;
    }


}
