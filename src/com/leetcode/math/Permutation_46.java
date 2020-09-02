package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/27 23:38
 * @Version 1.0
 */
public class Permutation_46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        permute.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, nums, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, int j) {
        if (j == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(res, nums, j+1);
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

}
