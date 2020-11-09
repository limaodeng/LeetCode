package com.leetcode.math;

/**
 * @ClassComment: 丑数
 * @Auther: dlm
 * @Date: 2020/11/4 00:56
 * @Version 1.0
 */
public class UglyNumber_263 {

    /**
     *
     * Write a program to check whether a given number is an ugly number.
     *
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     *
     * Example 1:
     *
     * Input: 6
     * Output: true
     * Explanation: 6 = 2 × 3
     * Example 2:
     *
     * Input: 8
     * Output: true
     * Explanation: 8 = 2 × 2 × 2
     * Example 3:
     *
     * Input: 14
     * Output: false
     * Explanation: 14 is not ugly since it includes another prime factor 7.
     * Note:
     *
     * 1 is typically treated as an ugly number.
     * Input is within the 32-bit signed integer range: [−231,  231 − 1].
     *
     */
    public static void main(String[] args) {

    }

    public boolean isUgly(int num) {
        while (num >= 2) {
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else return false;
        }
        return num == 1;
    }

    public boolean isUgly2(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

}