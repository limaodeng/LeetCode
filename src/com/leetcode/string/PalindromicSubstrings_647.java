package com.leetcode.string;

/**
 * @Auther: dlm
 * @Date: 2020/9/3 09:25
 * @Description:
 */
public class PalindromicSubstrings_647 {
    /**
     * Given a string, your task is to count how many palindromic substrings in this string.
     *
     * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
     *
     * Example 1:
     *
     * Input: "abc"
     * Output: 3
     * Explanation: Three palindromic strings: "a", "b", "c".
     *
     *
     * Example 2:
     *
     * Input: "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     *
     *
     * Note:
     *
     * The input string length won't exceed 1000.
     */
    public static void main(String[] args) {
        String str = "aaa";
        int res = countSubstrings(str);
        System.out.println(res);
    }

    public static int countSubstrings(String str) {
        int res = 0;
        for(int i = 0;i < str.length();i++){
            //计算字符串中以第i个字符为中心的回文子串个数
            //计算字符串中以第i个字符为左中心的回文子串个数
            res = res + count(str,i,i);
            res = res + count(str,i,i+1);
        }
        return res;
    }

    public static int count(String str,int i,int j){
        int res = 0;
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
            res++;
        }
        return res;
    }

}
