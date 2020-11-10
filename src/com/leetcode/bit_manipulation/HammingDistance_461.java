package com.leetcode.bit_manipulation;

/**
 * @ClassComment: 汉明距离
 * @Auther: dlm
 * @Date: 2020/11/10 23:45
 * @Version 1.0
 */
public class HammingDistance_461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance1(1,4));
    }

    public static int hammingDistance1(int x, int y) {
        int res = 0, exc = x ^ y;
        for (int i = 0; i < 32; ++i) {
            res += (exc >> i) & 1;
        }
        return res;
    }

}
