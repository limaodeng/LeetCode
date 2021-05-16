package com.leetcode.bit_manipulation;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2021/5/16 17:52
 * @Version 1.0
 */
public class SumOfTwoIntegers_371_new {

    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

    public static int getSum(int a,int b){
        // b为进位，如果进位为零则和就是a.
        if(b == 0) return a;
        // 得到无进位和
        int i1 = a ^ b;
        // 得到进位数的过程数
        int i2 = a & b;
        // 得到最终进位数
        int i3 = i2 << 1;
        // 递归
        return getSum(i1,i3);
    }

}
