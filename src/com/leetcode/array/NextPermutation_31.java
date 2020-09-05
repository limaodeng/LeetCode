package com.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: dlm
 * @Date: 2020/2/18 01:05
 * @Description:
 */
public class NextPermutation_31 {

    /**
     * 题目：
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     */
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nums = nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static int[] nextPermutation(int[] nums) {
        // 找到 a[i] < a[i+1] >= a[i+2] >= a[i+3]... >= a[i+n]
        // 例如 1,2,3,5,4 中的 5 符合
        int k = 0;
        for(int i = nums.length - 1;i > 0;i-- ){
            if(nums[i] > nums[i-1]){
                k = i;  //将i的位置记下来。 5 的位置记下来
                break;
            }
        }

        if(k == 0){ //如果不存在，例如 5,4,3,2,1 则直接倒置
            Arrays.sort(nums);
        }else { //存在

            //找到k后面大于k-1位置且是最小的数的位置
            int l = k;
            for(int j = k+1 ;j < nums.length;j++){
                if(nums[j] > nums[k-1]){
                    l = j;
                }
            }

            //将k后面大于k-1位置且是最小的数与k-1位置的数交换
            //如果上面的循环不走。如 1,2。则将1,2交换位置
            int tem = nums[k-1];
            nums[k-1] = nums[l];
            nums[l] = tem;

            Arrays.sort(nums,k,nums.length);
        }

        return nums;
    }

}


