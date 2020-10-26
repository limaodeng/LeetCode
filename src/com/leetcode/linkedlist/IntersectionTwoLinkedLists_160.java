package com.leetcode.linkedlist;

/**
 * @Auther: dlm
 * @Date: 2020/10/19 16:12
 * @Description:
 */
public class IntersectionTwoLinkedLists_160 {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * <p>
     * For example, the following two linked lists:
     * <p>
     * <p>
     * begin to intersect at node c1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * Output: Reference of the node with value = 8
     * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
     * <p>
     * From the head of A, it reads as [4,1,8,4,5].
     * <p>
     * From the head of B, it reads as [5,6,1,8,4,5].
     * <p>
     * There are 2 nodes before the intersected node in A;
     * <p>
     * There are 3 nodes before the intersected node in B.
     * <p>
     * <p>
     * Example 2:
     * <p>
     * <p>
     * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Reference of the node with value = 2
     * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
     * <p>
     * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4].
     * <p>
     * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     * <p>
     * <p>
     * Example 3:
     * <p>
     * <p>
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: null
     * Input Explanation: From the head of A, it reads as [2,6,4].
     * <p>
     * From the head of B, it reads as [1,5].
     * <p>
     * Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * <p>
     * Explanation: The two lists do not intersect, so return null.
     * <p>
     * <p>
     * Notes:
     * <p>
     * If the two linked lists have no intersection at all, return null.
     * <p>
     * The linked lists must retain their original structure after the function returns.
     * <p>
     * You may assume there are no cycles anywhere in the entire linked structure.
     * <p>
     * Each value on each linked list is in the range [1, 10^9].
     * <p>
     * Your code should preferably run in O(n) time and use only O(1) memory.
     */
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA,b = headB;
        while (a != b){
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        if(lenA > lenB){
            for(int i = 0;i < lenA - lenB;i++)
                headA = headA.next;
        }else {
            for(int i = 0;i < lenB - lenA;i++)
                headB = headB.next;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null) ? headA : null;
    }

    private static int getListLength(ListNode listNode){
        int len = 0;
        while (listNode != null){
            listNode = listNode.next;
            len++;
        }
        return len;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
