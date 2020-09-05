package com.leetcode.array;

public class RDFSA_80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3};
        int res = removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i<res;i++){
            System.out.println(nums[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int low = 0;
        int high = 1;
        int count = 1;
        while (high < nums.length){
            if (nums[low] == nums[high] && count == 0){
                high++;
            }else {
                if (nums[low] == nums[high]){
                    count--;
                }else {
                    count = 1;
                }
                nums[++low] = nums[high++];
            }
        }
        return low + 1;
    }
}
