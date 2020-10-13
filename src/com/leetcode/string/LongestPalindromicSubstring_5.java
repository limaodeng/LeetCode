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
        String s = "ecabacd";
        System.out.println(longestPalindrome3(s));
    }

    //暴力求解法


    // 马拉车算法
    // https://blog.csdn.net/weixin_43836046/article/details/95784075
    // https://www.cxyxiaowu.com/2665.html#:~:text=%E9%A9%AC%E6%8B%89%E8%BD%A6%E7%AE%97%E6%B3%95%EF%BC%88%20Manacher,%E5%A4%8D%E6%9D%82%E5%BA%A6%E6%8F%90%E5%8D%87%E5%88%B0%E4%BA%86%20%E7%BA%BF%E6%80%A7%20%E3%80%82
    public static String longestPalindrome3(String s) {
        // 先预处理字符串
        String str = preHandleString(s);
        // 处理后的字串长度
        int len = str.length();
        // 右边界
        int rightSide = 0;
        // 右边界对应的回文串中心
        int rightSideCenter = 0;
        // 保存以每个字符为中心的回文长度一半（向下取整）
        int[] halfLenArr = new int[len];
        // 记录回文中心
        int center = 0;
        // 记录最长回文长度
        int longestHalf = 0;
        for(int i = 0; i < len; i++) {
            // 是否需要中心扩展
            boolean needCalc = true;
            // 如果在右边界的覆盖之内
            if(rightSide > i) {
                // 根据对称性，计算相对rightSideCenter的对称位置
                int leftCenter = 2 * rightSideCenter - i;
                // 根据对称性，得到这两个的回文半径是一样的
                halfLenArr[i] = halfLenArr[leftCenter];
                //如果超过或等于右边界，即i + halfLenArr[i] >= rightside都要进行中心扩展
                if(i + halfLenArr[i] >= rightSide) {
                    halfLenArr[i] = rightSide - i;
                    //先让它暂且等于右边界内的长度，对于这个长度之外部分(上图的黄色部分)再进行扩展
                }
                // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
                if(i + halfLenArr[leftCenter] < rightSide) {
                    // 直接推出结论
                    needCalc = false;
                }
            }
            // 中心扩展
            if(needCalc) {
                while(i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
                    if(str.charAt(i + 1 + halfLenArr[i]) == str.charAt(i - 1 - halfLenArr[i])) {
                        halfLenArr[i]++;
                    } else {
                        break;
                    }
                }
                // 更新右边界及中心
                rightSide = i + halfLenArr[i];
                rightSideCenter = i;
                // 记录最长回文串
                if(halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }
            }
        }
        // 去掉之前添加的#
        StringBuffer sb = new StringBuffer();
        for(int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // 预处理字符串，在两个字符之间加上#
    private static String preHandleString(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        sb.append('#');
        for(int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return sb.toString();
    }

    // 动态规划
    // https://blog.csdn.net/zhou_209/article/details/90547718
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if(len == 0 || len == 1)
            return s;
        int[][] dp = new int[len][len]; //定义二位数组存储值，dp值为1表示true，为0表示false
        int start = 0;  //回文串的开始位置
        int max = 1;   //回文串的最大长度
        for(int i = 0; i < len; i++){  //初始化状态
            dp[i][i] = 1;
            if(i < len - 1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }

        for(int l = 3; l <= len; l++){  //l表示检索的子串长度，等于3表示先检索长度为3的子串
            for (int i = 0; i+l-1 < len; i++){ //检索所有长度为l的子串
                int j = l+i-1;  //终止字符位置
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){  //状态转移
                    dp[i][j] = 1;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start,start + max);   //获取最长回文子串
    }

    // 动态规划2
    // https://blog.csdn.net/weixin_43836046/article/details/95784075
    public static String longestPalindrome22(String s) {
        int len = s.length();
        if(len <= 1) return s;
        //字符串为空或者长度等于1，直接返回
        boolean[][] dp = new boolean[len][len];
        //记录每一个子串的状态，dp[i][j]=true表明，以i为起点，j为终点的子串是回文
        int max = 0;
        //最大回文长度
        String ret = s.substring(0, 1);
        //存放回文，初始化为s的第一个字符，假如该字符串没有回文，那就直接返回字符串的第一个字符
        for(int r = 1; r < len; r++){
            for(int l = 0; l <  r; l++){
                //这两个循环很关键，
                if(s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(max < r - l + 1) {
                        max = r - l + 1;
                        //max值更新
                        ret = new String(s.substring(l, r + 1));
                        //存放新的回文
                    }
                }
            }
        }
        return ret;
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
