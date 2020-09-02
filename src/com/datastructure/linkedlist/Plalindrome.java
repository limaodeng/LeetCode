package com.datastructure.linkedlist;

/**
 * 回文判断
 * @Auther: dlm
 * @Date: 2020/4/6 11:39
 */
public class Plalindrome {

    //头结点
    private Node head = null;

    public static class Node{

        private int data;   //存储数据，整型

        private Node next;  //指向下一个元素

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    //判断回文
    public boolean plalindrome(Node p){
        //p为头结点
        if(p == null){  //空链表
            return false;
        }

        if(p.next == null){ //只有一个结点
            return true;
        }

        Node n = p;
        Node m = p;
        //寻找中间结点
        while (n.next != null && n.next.next != null){
            m = m.next;
            n = n.next.next;
        }

        Node right = null;
        Node left = null;
        if(n.next == null){ //奇数，m为中间结点
            right = m.next;
            left = reverse(p,m).next;
        }else { //偶数，m 及 m的下一个结点 为中间结点
            right = m.next;
            left = reverse(p,m);
        }

        return TFResult(right,left);
    }

    //判断左边及右边是否相等
    private boolean TFResult(Node right, Node left) {
        while (right != null && left != null){
            if(right.data != left.data){
                right = right.next;
                left = left.next;
            }else {
                return false;
            }
        }
        return true;
    }

    //链表反转
    public Node reverse(Node p, Node m){ //p为头结点，m为中间结点
        Node pre = null;
        Node curr = p;
        while (curr != m){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return curr;
    }

}
