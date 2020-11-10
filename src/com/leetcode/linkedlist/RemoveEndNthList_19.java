package com.leetcode.linkedlist;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/11/10 22:03
 * @Version 1.0
 */
public class RemoveEndNthList_19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
            return null;

        ListNode pre = head;
        ListNode cur = head;

        for(int i = 0;i < n;i++){
            cur = cur.next;
        }

        if(cur == null){
            return head.next;
        }

        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
