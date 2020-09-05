package com.leetcode.array;


public class FirstMissPositive_41 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int res = firstMissPositive(nums);
        System.out.println(res);
    }

    public static int firstMissPositive(int[] nums){
        int size = nums.length;
        for (int i = 0;i < size;i++){
            while (nums[i] > 0 && nums[i] <= size && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] -1 ,i);
            }
        }

        for (int i = 0;i < size;i++){
            if (nums[i] != i + 1)
                return nums[i];
        }
        return size + 1;
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
