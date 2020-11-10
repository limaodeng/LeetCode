package com.leetcode.math;

/**
 * @ClassComment: 求平方根
 * @Auther: dlm
 * @Date: 2020/11/10 22:40
 * @Version 1.0
 */
public class SqrtX_69 {

    public static void main(String[] args) {

    }

    //二分查找法
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(x / mid >= mid){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right - 1;
    }

    //牛顿迭代法
    public int mySqrt1(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int)res;
    }

}
