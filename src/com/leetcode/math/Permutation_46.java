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
        List<List<Integer>> permute = permute2(nums);
        permute.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length<1) {
            return lists;
        }
        if(nums.length==1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        huisu("","",nums,lists);
        return lists;
    }

    public static void huisu(String s1,String s2,int[] nums,List<List<Integer>> lists) {
        String[] ss = s1.split(",");
        if(ss.length==nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<ss.length;i++) {
                list.add(Integer.valueOf(ss[i]));
            }
            lists.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++) {
            boolean flag = true;
            String[] ss2 = s2.split(",");
            for(int j=0;j<ss2.length;j++) {
                if(ss2[j].equals(i+"")) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                huisu(s1+nums[i]+",",s2+i+",",nums,lists);
            }
        }
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
