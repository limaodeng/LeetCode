package com.leetcode.array;

import java.util.Arrays;

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        String printNums = Arrays.toString(nums);
        System.out.println(printNums);
        rotate3(nums,k);
        //reverse(nums,4,7);
        printNums = Arrays.toString(nums);
        System.out.println(printNums);
    }

    public static void rotate(int[] nums, int k) {
        int[] temp = nums.clone();
        for (int i = 0;i < nums.length;i++){
            int index = (k+i) % nums.length;
            nums[index] = temp[i];
        }
    }

    public static void rotate2(int[] nums,int k){
        int start = 0;
        int idx = 0;
        int pre = 0;
        int cur = nums[0];
        int size = nums.length;
        int a = (k %= size);
        if(size == 0 || (k %= size) == 0){
            return;
        }
        for(int i = 0;i < size;i++){
            pre = cur;
            idx = (idx + k) % size;
            cur = nums[idx];
            nums[idx] = pre;
            if (start == idx ){
                idx = ++start;
                cur = nums[idx];
            }
        }
    }

    public static void rotate3(int[] nums,int k){
        int size = nums.length;
        if(size == 0 || (k %= size) == 0){
            return;
        }
        reverse(nums,0,size - k);
        reverse(nums,size - k,size);
        reverse(nums,0,size);
    }

    public static void reverse(int[] nums,int start,int end){
        for(int i = start,k = end-1;i < k; i++,k--){
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

}
