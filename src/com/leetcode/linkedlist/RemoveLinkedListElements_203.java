package com.leetcode.linkedlist;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/11/9 20:09
 * @Version 1.0
 */
public class RemoveLinkedListElements_203 {

    /**
     * Remove all elements from a linked list of integers that have value val.
     * <p>
     * Example:
     * <p>
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     */
    public static void main(String[] args) {

    }

    //递归
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next:head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;
        while (pre.next != null){
            if(pre.next.val == val){
                ListNode temp = pre.next;
                pre.next = temp.next;
                temp.next = null;
            }else {
                pre = pre.next;
            }
        }
        return dummy.next;
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
