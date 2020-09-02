package com.leetcode.string;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/11 20:23
 * @Version 1.0
 */
public class ValidPalindrome_125 {

    /**
     * 题目描述：
     * Given a string, determine if it is a palindrome,
     * <p>
     * considering only alphanumeric characters and ignoring cases.
     * <p>
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     * <p>
     * Input: "race a car"
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * s consists only of printable ASCII characters.
     */

    public static void main(String[] args) {
        String str = "Bob: \"Did Anna peep?\" Anna: \"Did Bob?\"";
        boolean res = validPalindrome(str);
        System.out.println(res);
    }

    public boolean isAlphaNum(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }

    public static boolean validPalindrome(String str) {
        int min = 0;
        int max = str.length() - 1;
        while (min < max) {
            char c1 = str.charAt(min);
            char c2 = str.charAt(max);
            if (!Character.isLetterOrDigit(c1)) min++;
            else if (!Character.isLetterOrDigit(c2)) max--;
            else if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)
                    && !(((c1 == c2) && (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) ||((c1 - 32 == c2)  || (c2 - 32 == c1))&& (Character.isLetter(c1)) && (Character.isLetter(c2))))) {
                return false;
            } else {
                min++;
                max--;
            }
        }

        return true;
    }

    public static boolean validPalindrome2(String str) {
        int min = 0;
        int max = str.length() - 1;
        while (min < max) {
            char c1 = str.charAt(min);
            char c2 = str.charAt(max);
            if (!Character.isLetterOrDigit(c1)) min++;
            else if (!Character.isLetterOrDigit(c2)) max--;
            else if ((c1 + 32 - 'a') % 32 != (c2 + 32 - 'a') % 32) {
                return false;
            } else {
                min++;
                max--;
            }
        }
        return true;
    }

    public static boolean validPalindrome3(String str) {
        return new StringBuilder(str.replaceAll("[^0-9a-zA-Z]","")).reverse().toString().equalsIgnoreCase(str.replaceAll("[^0-9a-zA-Z]",""));
    }

}
