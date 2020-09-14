package com.leetcode.stack;

import java.util.Stack;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/9/14 22:37
 * @Version 1.0
 */
public class MinStack_155 {

    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     *
     * Example 1:
     *
     * Input
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * Output
     * [null,null,null,null,-3,null,0,-2]
     *
     * Explanation
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top();    // return 0
     * minStack.getMin(); // return -2
     *
     *
     * Constraints:
     *
     * Methods pop, top and getMin operations will always be called on non-empty stacks.
     */
    public static void main(String[] args) {
      MinStack2 obj = new MinStack2();
      obj.push(3);
      obj.push(2);
      obj.push(2);
      obj.push(1);
      obj.pop();
      obj.push(4);
      System.out.println(obj.getMin());
    }

    static class MinStack2{

        int minVal = Integer.MAX_VALUE;

        private Stack<Integer> stack1 = new Stack<>();

        public MinStack2() {

        }

        public void push(int val) {
            if(minVal >= val){
                stack1.push(minVal);
                minVal = val;
            }
            stack1.push(val);
        }

        public void pop() {
            if (stack1.pop() == minVal) minVal = stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return minVal;
        }
    }

    static class MinStack{

        private Stack<Integer> stack1 = new Stack<>();

        private Stack<Integer> stack2 = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            stack1.push(val);
            if(stack2.isEmpty() || stack2.peek() >= val)
                stack2.push(val);
        }

        public void pop() {
            int pop = stack1.pop();
            if(stack2.peek() == pop)
                stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

}
