package com.leetcode.array;

/**
 * @Auther: dlm
 * @Date: 2020/2/16 10:42
 * @Description:
 */
public class ContainerMostWater_11 {
    /**
     * 题目：
     *
     * Given n non-negative integers a1, a2, ..., an ,
     * where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container,
     * such that the container contains the most water.
     *
     */
    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        int result = maxArea2(array);
        System.out.println(result);
    }

    public static int maxArea1(int[] array) {
        int maxArea = 0;
        for(int i = 0;i < array.length;i++){
            for(int j = i+1;j < array.length;j++){
                int currentArea = (j - i) * Math.min(array[i],array[j]);
                if(currentArea > maxArea){
                    maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int maxArea = 0;
        while (i < j){
            maxArea = Math.max(maxArea,(j - i) * Math.min(array[i],array[j]));

            if(array[i] < array[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }

    public static int maxArea3(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int maxArea = 0;
        while (i < j){
            int h = Math.min(array[i],array[j]);
            maxArea = Math.max(maxArea,(j - i) * h);

            while (i < j && array[i] == h) i++;
            while (i < j && array[j] == h) j--;
        }
        return maxArea;
    }

}