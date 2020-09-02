package com.leetcode.linkedlist;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/21 00:13
 * @Version 1.0
 */
public class ReverseLinkedList_206 {

    /**
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     *
     * A linked list can be reversed either iteratively or recursively.
     *
     * Could you implement both?
     *
     */
    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        Node node = reverseList2(node1);
        System.out.println(node);
    }

    public static Node reverseList(Node head) {
        Node newHead = null;
        while (head != null){
            Node t = head.next;
            head.next = newHead;
            newHead = head;
            head = t;
        }

        return newHead;

    }

    public static Node reverseList2(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static class Node{

        public int data;   //存储数据，整型

        public Node next;  //指向下一个元素

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }
}
