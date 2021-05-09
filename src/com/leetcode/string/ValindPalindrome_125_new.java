package com.leetcode.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2021/5/9 10:11
 * @Version 1.0
 */
public class ValindPalindrome_125_new {

    /**
     * 题目描述：
     *
     * Given a string s, determine if it is a palindrome,
     *
     * considering only alphanumeric characters and ignoring cases.
     *
     * Example 1:
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     *
     *
     * Example 2:
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     *
     *
     * Constraints:
     * 1 <= s.length <= 2 * 105
     * s consists only of printable ASCII characters.
     *
     *
     */
    public static void main(String[] args) {
        System.out.println(valindPalindrome3("0P"));
    }


    /**
     * 方式4：双指针(代码优化)
     * 首指针从头向尾遍历，尾指针从尾向头遍历。
     * 遍历的过程逐个比较。
     */
    public static boolean valindPalindrome4(String str){
        //初始化头指针和尾指针
        int head = 0;
        int tail = str.length() - 1;
        //循环遍历比较
        while (head < tail){
            //取出首指针对应的值
            char cHead = str.charAt(head);
            //取出尾指针对应的值
            char cTail = str.charAt(tail);
            //如果c1不是字母或数字，则p++之后进入下一轮循环
            if(!Character.isLetterOrDigit(cHead)){
                head++;
            }else if(!Character.isLetterOrDigit(cTail)){
                //如果c2不是字母或数字，则p++之后进入下一轮循环
                tail--;
            }else if(!String.valueOf(cHead).equalsIgnoreCase(String.valueOf(cTail))){
                //如果c1和c2都是字母或者数字，则忽略大小写之后进行比较，如果不相等则不是回文字符串
                return false;
            }else {
                //如果c1和c2都是字母或数字，并且c1等于c2,则p1++;p2--;之后进行下一轮循环
                head++;
                tail--;
            }
        }
        //跳出循环这说明肯定是回文字符串
        return true;
    }

    /**
     * 方式3：双指针
     * 首指针从头向尾遍历，尾指针从尾向头遍历。
     * 遍历的过程逐个比较。
     */
    public static boolean valindPalindrome3(String str){
        //初始化头指针和尾指针
        int p1 = 0;
        int p2 = str.length() - 1;
        //循环遍历比较
        while (p1 < p2){
            //取出首指针对应的值
            char c1 = str.charAt(p1);
            //如果不是字母和数字则跳过，取下一个值
            while (!isDigital(c1) && !isLetter(c1) && p1 < p2){
                p1++;
                c1 = str.charAt(p1);
            }

            //取出尾指针对应的值
            char c2 = str.charAt(p2);
            //如果不是字母和数字则跳过，取下一个值
            while (!isDigital(c2) && !isLetter(c2) && p1 < p2){
                p2--;
                c2 = str.charAt(p2);
            }

            //忽略大小写之后比较首指针和尾指针对应的值
            //如果不相等则说明不是回文字符串
            //如果相等则p1++， p2--之后，进行下一轮比较
            if(!String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))){
                return false;
            }else {
                p1++;
                p2--;
            }
        }
        //跳出循环这说明肯定是回文字符串
        return true;
    }

    /**
     * 判断是否为数字
     */
    public static boolean isDigital(char c){
        return c >= '0' && c <= '9';
    }

    /**
     * 判断是否为字母
     */
    public static boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /**
     * 方式2：翻转字符串(一行代码)
     */
    public static boolean valindPalindrome2(String str){
        return str.replaceAll("[^a-zA-Z0-9]","")
                .equalsIgnoreCase(
                        new StringBuilder(str.replaceAll("[^a-zA-Z0-9]","")).reverse().toString()
                );
    }

    /**
     * 方式1：翻转字符串
     */
    public static boolean valindPalindrome(String str){
        //去掉非字母和数字的字符
        String str1 = str.replaceAll("[^a-zA-Z0-9]", "");
        //字母全转为小写
        String str2 = str1.toLowerCase();
        //翻转字符串
        String str3 = new StringBuilder(str2).reverse().toString();
        //对比翻转前与翻转后的字符是否相等
        return str2.equals(str3);
    }

}
