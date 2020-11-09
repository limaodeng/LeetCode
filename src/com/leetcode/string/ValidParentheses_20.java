package com.leetcode.string;

import java.util.Stack;

/**
 * @Auther: dlm
 * @Date: 2020/11/9 09:22
 * @Description: 验证括号有效性
 */
public class ValidParentheses_20 {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     *
     * determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     * Example 4:
     *
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     *
     * Input: s = "{[]}"
     * Output: true
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     *
     */
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }


    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if(stack.empty()) return false;
                if(s.charAt(i) == ')' && stack.peek() != '(') return false;
                if(s.charAt(i) == ']' && stack.peek() != '[') return false;
                if(s.charAt(i) == '}' && stack.peek() != '{') return false;
                stack.pop();
            }

        }

        return stack.empty();
    }

}
