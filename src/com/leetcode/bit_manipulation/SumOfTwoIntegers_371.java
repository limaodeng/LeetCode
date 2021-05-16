package com.leetcode.bit_manipulation;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/14 00:13
 * @Version 1.0
 */
public class SumOfTwoIntegers_371 {

    /**
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     *
     * Example 1:
     *
     * Input: a = 1, b = 2
     * Output: 3
     * Example 2:
     *
     * Input: a = -2, b = 3
     * Output: 1
     *
     */

    //答案：https://www.cnblogs.com/dyzhao-blog/p/5662891.html
    //https://segmentfault.com/a/1190000021210551
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int sum = getSum(a,b);
        System.out.println(sum);
    }

    public static int getSum(int a, int b) {
        if(b == 0) return  a;
        int i1 = a ^ b; //异或运算获取的是两个数的无进位和
        int i2 = a & b; //与运算 求 进位
        int i3 = i2 << 1;   //左移1位就是最终结果的进位数
        return getSum(i1, i3);
    }

}
