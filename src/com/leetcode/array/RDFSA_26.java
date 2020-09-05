package com.leetcode.array;

public class RDFSA_26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates2(nums);
        System.out.println(res);
        for (int i = 0; i<res;i++){
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int low = 0;
        int fast = 0;
        while (fast < nums.length){
            if(nums[low] == nums[fast]){
                fast++;
            }else {
                nums[++low] = nums[fast++];
            }
        }
        return low + 1;
    }

    public static int removeDuplicates2(int[] nums){
        if (nums.length==0){
            return 0;
        }
        int low = 0;
        for (int fast = 0;fast < nums.length;fast++){
            if (nums[low] == nums[fast]){
                fast++;
            }else {
                nums[++low] = nums[fast++];
            }
        }
        return low + 1;
    }
}
