package com.leetcode.linkedlist;

/**
 * @Auther: dlm
 * @Date: 2021/1/24 10:58
 * @Description: 链表排序
 */
public class SortList_148 {

    public static void main(String[] args) {
        // 4->2->1->3

        ListNode listNode3 = new ListNode(3);
        ListNode listNode1 = new ListNode(1,listNode3);
        ListNode listNode2 = new ListNode(2,listNode1);
        ListNode listNode4 = new ListNode(4,listNode2);

        ListNode listNode = sortList(listNode4);

        System.out.println(listNode);

    }


    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge2(sortList2(head), sortList2(slow));
    }

    public ListNode merge2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge2(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2(l1, l2.next);
            return l2;
        }
    }


    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }


    public static class ListNode{

        public int val;   //存储数据，整型

        public ListNode next;  //指向下一个元素

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }



}
