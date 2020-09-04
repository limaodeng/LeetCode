package com.leetcode.math;

/**
 * @Auther: dlm
 * @Date: 2020/9/4 09:22
 * @Description:
 */
public class PalindromeNumber_9 {

    /**
     *
     * Determine whether an integer is a palindrome.
     *
     * An integer is a palindrome when it reads the same backward as forward.
     *
     * Example 1:
     *
     * Input: 121
     * Output: true
     *
     * Example 2:
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121.
     * From right to left, it becomes 121-. Therefore it is not a palindrome.
     *
     * Example 3:
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     * Follow up:
     *
     * Coud you solve it without converting the integer to a string?
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome2(212));
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int div = 1;
        //为取出第一个数做准备
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            //取出第一个数
            int left = x / div;
            //取出最后个数
            int right = x % 10;
            //比较第一个数和最后个数是否相等
            if (left != right) return false;
            //去掉头和尾两个数
            x = (x % div) / 10;
            //因为去掉两个数，所以要除100
            div /= 100;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        //如果x为负数、x的最后一位为0并且x不等于0
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        //res为后一半的数
        int res = 0;
        //res大于等于x，则结束
        while (res < x){
            int temp = x % 10;
            res = res * 10 + temp;
            x = x /10;
        }
        //如果是奇数则res == x，如果是偶数则 res / 10 == x
        return res == x || res / 10 == x;
    }

}
