package com.leetcode.array;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int res = removeElement(nums, val);
        System.out.println(res);
        for (int i = 0;i < res;i++){
            System.out.println(nums[i]);
        }
    }
    public static int removeElement(int[] nums,int val){
        int res = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != val){
                nums[res++] = nums[i];
            }
        }
        return res;
    }

}
