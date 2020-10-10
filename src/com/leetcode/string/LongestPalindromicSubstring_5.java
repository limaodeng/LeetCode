package com.leetcode.string;

/**
 * @Auther: dlm
 * @Date: 2020/10/10 09:22
 * @Description:
 */
public class LongestPalindromicSubstring_5 {

    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     * Example 3:
     *
     * Input: s = "a"
     * Output: "a"
     * Example 4:
     *
     * Input: s = "ac"
     * Output: "a"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters (lower-case and/or upper-case),
     *
     */
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    // 动态规划
    // https://blog.csdn.net/weixin_42762089/article/details/90402511
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1){
            return s;
        }
        boolean[][] flag =  new boolean[len][len];
        int start = 0;    //回文串起始位置
        int maxLen = 0;   //回文串最大长度
        // 子串长度为1和为2的初始化
        for(int i = 0; i < len; i++){
            flag[i][i] = true;
            if(i < len-1 && s.charAt(i) == s.charAt(i+1)){
                flag[i][i+1] = true;
                start = i;
                maxLen = 2 ;
            }
        }
        //m代表回文子串长度，从3开始
        for(int m = 3; m <= len; m++){
            for(int i = 0; i <= len-m; i++){
                int j = i+m-1;    // 子串结束的位置
                if(flag[i+1][j-1] && s.charAt(i)== s.charAt(j)){
                    flag[i][j] = true;
                    start = i;
                    maxLen = m;
                }
            }
        }
        if(start == 0 && maxLen == 0)
            return String.valueOf(s.charAt(0));
        return s.substring(start, start + maxLen);
    }

    // 中心扩展算法
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
