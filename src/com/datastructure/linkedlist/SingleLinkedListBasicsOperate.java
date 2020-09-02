package com.datastructure.linkedlist;

/**
 * 单链表的基本操作：
 * 1、单链表反转
 * 2、链表中环的检测
 * 3、两个有序链表的合并
 * 4、删除倒数第K个结点
 * 5、求链表的中间结点
 *
 * @Auther: dlm
 * @Date: 2020/4/6 10:19
 */
public class SingleLinkedListBasicsOperate {

    public static class Node{

        private int data;   //存储整型数据

        private Node next;  //指向下一个结点的指针

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return this.data;
        }

    }

    //1、单链表反转(不带头结点)
    public Node reverse(Node p){
        Node curr = p;
        Node pre = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //1、单链表反转(带头结点)
    //带头结点的反转相当于从第二个结点开始用头插法重新建立链表
    public Node reverseHead(Node p){
        Node head = new Node(-1,null);
        //p为整个链表的头结点,head指向p,指向整个链表。
        head.next = p;
        Node curr = p.next;
        p.next = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = head.next;
            head.next = curr;
            curr = next;
        }
        return head;
    }

    // 1-->2-->3-->4-->5-->3
    //2、链表中环的检测
    public boolean checkCircle(Node p){
        Node slow = p;
        Node fast = p.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    // l1: 1-->3-->5
    // l2: 2-->4-->6-->8-->10
    // 开始合并
    // 1
    // 1-->2
    // 1-->2-->3
    // 1-->2-->3-->4
    // 1-->2-->3-->4-->5
    // 1-->2-->3-->4-->5-->6-->8-->10
    //3、两个有序链表的合并
    public Node mergeSortTowLists(Node l1,Node l2){
        Node soldier = new Node(-1,null);
        Node p = soldier;

        while (l1 != null && l2 != null){
            if(l1.data < l2.data){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;

        return soldier.next;
    }

    // 第一种情况： 1-->2-->3-->4-->5
    // 第二种情况： 1-->2
    // 第三种情况： 1
    // k = 2
    //4、删除倒数第K个结点
    public Node deleteLastKth(Node p,int k){
        Node fast = p;
        for(int i = 1;i < k && fast != null; i++){
            fast = fast.next;
        }

        if(fast == null) return p;

        Node pre = null;
        Node slow = p;

        while (fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if(pre == null){
            p = p.next;
        }else {
            pre.next = pre.next.next;
        }

        return p;
    }

    // 1-->2-->3-->4-->5
    // 1-->2-->3-->4-->5-->6
    //5、求链表的中间结点
    public Node findMiddleNode(Node p){
        if(p == null) return  p;

        Node fast = p;
        Node slow = p;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow= slow.next;
        }

        return p;
    }

}
