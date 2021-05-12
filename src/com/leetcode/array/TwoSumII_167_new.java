package com.leetcode.array;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2021/5/12 21:34
 * @Version 1.0
 */
public class TwoSumII_167_new {

    /**
     * Given an array of integers numbers that is already sorted in ascending order,
     *
     * find two numbers such that they add up to a specific target number.
     *
     * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
     *
     * where 1 <= answer[0] < answer[1] <= numbers.length.
     *
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     *
     *
     * Example 1:
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     *
     *
     * Example 2:
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     *
     *
     * Example 3:
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
     *
     *
     * Constraints:
     *
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers is sorted in increasing order.
     * -1000 <= target <= 1000
     * Only one valid answer exists.
     *
     */
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] answer = towSumII(numbers,target);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    /**
     *  方式1：二分查找
     *  先循环确定一个数；
     *  另一个数在剩余的数中用二分查找出来。
     */
    public static int[] towSumII(int[] arr,int target){
     int[] answer = new int[2];

     ok : for(int i = 0;i < arr.length;i++){
         int left = i + 1;
         int right = arr.length - 1;

         while (left <= right){
             int mid = left + (right - left) / 2;
             if(arr[mid] + arr[i] > target){
                 right = mid - 1;
             }else if(arr[mid] + arr[i] < target){
                 left = mid + 1;
             }else if(arr[mid] + arr[i] == target){
                 answer[0] = i + 1;
                 answer[1] = mid + 1;
                 break ok;
             }
         }

     }

     return answer;
    }




}
