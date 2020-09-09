package com.leetcode.linkedlist;

import java.util.Stack;

/**
 * @Auther: dlm
 * @Date: 2020/9/4 10:15
 * @Description:
 */
public class PalindromeLinkedList_234 {

    /**
     * Given a singly linked list, determine if it is a palindrome.
     *
     * Example 1:
     *
     * Input: 1->2
     * Output: false
     *
     * Example 2:
     *
     * Input: 1->2->2->1
     * Output: true
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     *
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1,null);
        ListNode listNode2 = new ListNode(2,listNode1);
        ListNode listNode3 = new ListNode(2,listNode2);
        ListNode listNode = new ListNode(1,listNode3);
        System.out.println(isPalindrome5(listNode));
    }

    //链表整体翻转再比较
    public static boolean isPalindrome5(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode newHead = null;
        ListNode headTwo = head;
        while (headTwo != null) {
            ListNode temp = headTwo.next;
            headTwo.next = newHead;
            newHead = headTwo;
            headTwo = temp;
        }

        while (head != null){
            if(head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }

    //翻转后半段链表
    public static boolean isPalindrome4(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针找到中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转后半段链表
        //翻转前： 1 -> 2 -> 3 -> 4 -> 5 -> 4 -> 3 -> 2 -> 1
        //翻转后： 1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 -> 3 -> 4
        ListNode last = slow.next;
        while (last.next != null){
            ListNode temp = last.next;
            last.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
        }

        ListNode pre = head;

        while (slow.next != null){
            slow = slow.next;
            if(slow.val != pre.val) return false;
            pre = pre.next;
        }

        return true;
    }

    //快慢指针
    public static boolean isPalindrome3(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }

        if (fast.next == null)
            stack.pop();

        while (slow.next != null){
            slow = slow.next;
            Integer pop = stack.pop();
            if(slow.val != pop) return false;
        }

        return true;
    }

    private static ListNode cur;

    public static boolean isPalindrome2(ListNode head) {
        cur = head;
        return helper(head);
    }

    public static boolean  helper(ListNode node) {
        if (node == null)
            return true;
        //先将node递归到最后一个，再递归回来与cur从头到尾一个一个比较
        boolean res = helper(node.next) && (cur.val == node.val);
        cur = cur.next;
        return res;
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        while (head != null){
            Integer pop = stack.pop();
            if(pop != head.val) return false;
            head = head.next;
        }

        return true;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

}
