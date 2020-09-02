package com.leetcode.math;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/26 23:52
 * @Version 1.0
 */
public class Pow_50 {

    /**
     *
     * Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
     *
     *
     * Example 1:
     *
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     * Example 2:
     *
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     * Example 3:
     *
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     */
    public static void main(String[] args) {
        System.out.println(myPow4(2,3));
    }

    public double myPow5(double x, int n) {
        double result = 1.0;
        for(int i = n;i != 0;i /= 2) {
            if((i & 1) != 0){
                result = result * x;
            }
            x *= x;
        }
        return n > 0 ? result : 1 / result;
    }

    public static double myPow4(double x, int n) {
        int m = Math.abs(n);
        double result = 1;
        while (m > 0) {
            if((m & 1) != 0){
                result = result * x;
            }
            x *= x;
            m >>= 1;
        }
        return n < 0 ? 1 / result : result;
    }

    public static double myPow3(double x, int n) {
        int m = Math.abs(n);
        double result = 1;
        while (m != 0) {
            if((m & 1) != 0){
                result = result * x;
            }
            x *= x;
            m =  m / 2;
        }
        return n < 0 ? 1 / result : result;
    }

    public static double myPow2(double x, int n) {
        if(n == 0){
            return 1;
        }

        if(n > 0){
            return x * myPow2(x,n-1);
        }else {
            return 1 / myPow2(x,-n);
        }

    }

    public static double myPow(double x, int n) {
        int m = Math.abs(n);
        double result = 1;
        for(int i = 0;i < m;i++){
            result *= x;
        }
        return n < 0 ? 1 / result : result;
    }

}
