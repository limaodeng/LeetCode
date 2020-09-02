package com.leetcode.array;

/**
 * @Auther: dlm
 * @Date: 2020/2/13 20:10
 * @Description:
 */
public class MedOfTwoSortArr_4 {
    /**
     * 题目：
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     *
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays3(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int alen = nums1.length;
        int blen = nums2.length;

        if(alen > blen){    //将长度最短的数组放在前面
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            alen = nums1.length;
            blen = nums2.length;
        }

        int half = (alen + blen + 1) / 2;   //
        boolean even = ((alen + blen) % 2 == 0) ? true:false;

        int start = 0;
        int end = alen;
        int apart = 0;
        int bpart = 0;

        while (start <= end){
            apart = (start + end) / 2;
            bpart = half - apart;
            if(apart > start && nums1[apart-1] > nums2[bpart]){ //left_A不为空，能取到数据 并且 aPartLeft > bPartRight
                end = apart - 1;  //A左移
            }else if(apart < end && nums2[bpart-1] > nums1[apart]){ //right_A不为空，能取到数据 并且 bPartLeft > aPartRight
                start = apart + 1; //A右移
            }else { // 符合 aPartLeft < bPartRight 并且 bPartLeft < aPartRight
                //求leftMax
                int leftMax = 0;
                if(apart == 0){ //left_A为空
                    leftMax = nums2[bpart-1];
                }else if(bpart == 0){ //left_B为空
                    leftMax = nums1[apart-1];
                }else { //常规；left_A和left_B都不为空
                    leftMax = Math.max(nums1[apart-1],nums2[bpart-1]);
                }
                if(!even){ //如果为奇数直接返回leftMax
                    return leftMax;
                }

                //求rightMin
                int rightMin = 0;
                if(apart == alen){ //A所有数小于B的数,right_A为空,则取B数
                    rightMin = nums2[bpart];
                }else if (bpart == blen){ //B所有数小于A的数,right_B为空,则取A数
                    rightMin = nums1[apart];
                }else {//常规，right_A和right_B都不为空
                    rightMin = Math.min(nums1[apart],nums2[bpart]);
                }
                return (leftMax + rightMin) / 2.0;
            }

        }
        return 0.0;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int leftVal = (m + n + 1) / 2;
        int rightVal = (m + n + 2) / 2;
        //无论是奇数还是偶数；中位数 =  ((总长度 + 1) / 2 + (总长度 + 2) / 2) / 2.0
        return (findKth(nums1, 0, nums2, 0, leftVal) + findKth(nums1, 0, nums2, 0, rightVal)) / 2.0;
    }

    /**
     *
     * @param nums1
     * @param i nums1的起始位置
     * @param nums2
     * @param j nums2的起始位置
     * @param k 寻找两个混合数组中的第K个数字
     * @return
     */
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        //nums1所有数字已被淘汰,nums1相当于空数组,只要在nums2找即可
        if (i >= nums1.length) return nums2[j + k - 1];
        //nums2所有数字已被淘汰,nums2相当于空数组,只要在nums1找即可
        if (j >= nums2.length) return nums1[i + k - 1];
        // K=1时，只要比较 nums1 和 nums2 的起始位置i和j上的数字即可
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        // 需要使用二分法，所以需要在K/2中寻找。
        // 数组中到底存不存在第 K/2 个数字，如果存在就取出来，否则就赋值上一个整型最大值。
        // 目的是要在 nums1 或者 nums2 中先淘汰 K/2 个较小的数字，
        // 判断的依据就是看 midVal1 和 midVal2 谁更小，但如果某个数组的个数都不到 K/2 个，自然无法淘汰，
        // 所以将其对应的 midVal 值设为整型最大值，以保证其不会被淘汰
        // 若某个数组没有第 K/2 个数字，则淘汰另一个数组的前 K/2 个数字即可
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }

    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        double median;

        int[] nums3 = new int[nums1.length + nums2.length];

        for(int i = 0;i < nums1.length;i++){
            nums3[i] = nums1[i];
        }

        for(int i = 0;i < nums2.length;i++){
            nums3[nums1.length + i] = nums2[i];
        }

        for(int i = 0;i < nums3.length;i++){
            for(int j = i + 1;j < nums3.length;j++){
                if(nums3[i] > nums3[j]){
                    int temp = nums3[i];
                    nums3[i] = nums3[j];
                    nums3[j] = temp;
                }
            }
        }

        if(nums3.length % 2 == 0){
            int index1 = nums3.length / 2;
            int index2 = index1 - 1;
            median = (nums3[index1] + nums3[index2]) / 2.0;
        }else {
            int index = nums3.length / 2;
            median = nums3[index];
        }

        return median;
    }
}