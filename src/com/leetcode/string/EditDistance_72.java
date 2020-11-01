package com.leetcode.string;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/11/1 20:56
 * @Version 1.0
 */
public class EditDistance_72 {

    /**
     *
     * Given two strings word1 and word2,
     *
     * return the minimum number of operations required to convert word1 to word2.
     *
     * You have the following three operations permitted on a word:
     *
     * Insert a character
     * Delete a character
     * Replace a character
     *
     *
     * Example 1:
     *
     * Input: word1 = "horse", word2 = "ros"
     * Output: 3
     * Explanation:
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     * Example 2:
     *
     * Input: word1 = "intention", word2 = "execution"
     * Output: 5
     * Explanation:
     * intention -> inention (remove 't')
     * inention -> enention (replace 'i' with 'e')
     * enention -> exention (replace 'n' with 'x')
     * exention -> exection (replace 'n' with 'c')
     * exection -> execution (insert 'u')
     *
     *
     * Constraints:
     *
     * 0 <= word1.length, word2.length <= 500
     * word1 and word2 consist of lowercase English letters.
     *
     */
    public static void main(String[] args) {

    }

    // https://blog.csdn.net/qq_38261445/article/details/87025530
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //temp[i][j] 代表最小操作数（步骤），从 word1[0..i-1]转化为 word2[0..j-1].
        int[][] temp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            temp[i][0] = i;//即第一列的值，可看作删
        }

        for(int i = 0; i <= n; i++) {
            temp[0][i] = i;//即第一行的值，可看作增
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {//如果相等
                    //则等于左上角，即等于两个子字符串之前的操作，因为当前字符相等所以不需要操作
                    temp[i][j] = temp[i - 1][j - 1];
                } else {
                    //不相等的话就取左，上，左上角最小的操作再加1
                    temp[i][j] = Math.min(temp[i - 1][j - 1], Math.min(temp[i - 1][j], temp[i][j - 1]))+1;
                }
            }
        }
        //返回最后一个数组值，几位最小操作数
        return temp[m][n];
    }

}
