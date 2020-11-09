package com.leetcode.string;

import java.util.Stack;

/**
 * @Auther: dlm
 * @Date: 2020/11/9 09:22
 * @Description: 验证括号有效性
 */
public class ValidParentheses_20 {

    /**
     *
     *
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
