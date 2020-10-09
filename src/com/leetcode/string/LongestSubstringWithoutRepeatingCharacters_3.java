package com.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Auther: dlm
 * @Date: 2020/10/9 09:17
 * @Description:
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    /**
     * Given a string s,
     * <p>
     * find the length of the longest substring without repeating characters.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * <p>
     * Example 2:
     * <p>
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * <p>
     * Example 3:
     * <p>
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring,
     * "pwke" is a subsequence and not a substring.
     * <p>
     * Example 4:
     * <p>
     * Input: s = ""
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits,
     * symbols and spaces.
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    public static int lengthOfLongestSubstring3(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<Character>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        int left = -1;
        Map<Object, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (m.containsKey(s.charAt(i)) && m.get(s.charAt(i)) > left) {
                left = m.get(s.charAt(i));
            }
            m.put(s.charAt(i), i);
            res = Math.max(res, i - left);
        }
        return res;
    }

}
