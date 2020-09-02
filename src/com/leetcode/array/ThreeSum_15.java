package com.leetcode.array;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @Auther: dlm
 * @Date: 2020/2/16 14:28
 * @Description:
 */
public class ThreeSum_15 {
    /**
     * 题目：
     * Given an array nums of n integers, are there elements a, b, c in nums such that
     * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     *
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     *
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum2(nums);
        lists.forEach(s -> {
            s.forEach(k -> System.out.print(k + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);  //先对数组进行排序
        for(int i = 0;i < nums.length - 2;i++){  //只循环到倒数第三个数即可
            if(nums[i] > 0) break;  //如果nums[i]大于零，说明后面没有数跟它相加起来等于零了
            if(nums.length == 0) break; //空数组则直接返回
            if(i > 0 && nums[i] == nums[i-1]) continue; //如果第i个的前一个与它相等，则跳过，避免重复数据
            int target = 0 - nums[i];   //将第i个数变成正数
            int start = i + 1;  //start从第i+1开始往后移
            int end = nums.length - 1; //end从第nums.length - 1开始往前移
            while (start < end){
                if(nums[start] + nums[end] == target){ //num[i] + nums[start] + nums[end] = 0
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    lists.add(list);
                    while (start < end && nums[start] == nums[start + 1]) //第start+1的数与第start相等则跳过，继续往后找
                        start++;
                    while (start < end && nums[end] == nums[end - 1]) //第end - 1的数与第end相等则跳过，继续往前找
                        end--;

                    start++;
                    end--;
                }else if(nums[start] + nums[end] < target){ //nums[start] + nums[end] < target 则start继续往后找
                    start++;
                }else { //nums[start] + nums[end] > target 则end继续往前找
                    end--;
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);  //先进行排序，后面方便查重
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                for(int k = j + 1;k < nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        //判断lists里面是否包含有元素一模一样的list，如果有则不添加，如果没有则添加
                        AtomicBoolean b = new AtomicBoolean(false);
                        lists.forEach(li -> {
                            if(li.get(0)==list.get(0)&&
                                    li.get(1)==list.get(1)&&
                                    li.get(2)==list.get(2)){
                                b.set(true);
                            }
                        });
                        if(!b.get()){
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }
}