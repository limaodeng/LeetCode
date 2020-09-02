package com.datastructure.linkedlist;

/**
 * @Auther: dlm
 * @Date: 2020/4/5 00:02
 * @Description: 单链表的各种基本操作
 */
public class SingleLinkedList {

    //头结点
    private Node head = null;

    public static class Node{

        private int data;   //存储数据，整型

        private Node next;  //指向下一个元素

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    //通过值查找元素
    public Node findByValue(int data){
        Node p = head;
        while (p != null && p.data != data){
            p = p.next;
        }
        return p;
    }

    //通过下标查找元素
    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while(p != null && pos != index){
            p = p.next;
            pos++;
        }
        return p;
    }

    //无头结点
    //表头插入
    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    //表头插入
    public void insertToHead(Node newNode){
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    //表尾插入
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        insertTail(newNode);
    }

    //表尾插入
    public void insertTail(Node newNode){
        if(head == null){
           head = newNode;
        }else{
            Node p = head;
            while (p.next != null){
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    //在某一结点后插入
    public void insertAfter(Node node,int value){
        Node newNode = new Node(value,null);
        insertAfter(node,newNode);
    }

    //在某一结点后面插入
    public void insertAfter(Node p,Node newNode){
        if(p == null){
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    //在某一结点前面插入
    public void insertBefore(Node p,int value){
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    //在某一个结点前面插入
    public void insertBefore(Node p,Node newNode){
        if(p == null){
            return;
        }

        if(p == head){
            insertToHead(newNode);
            return;
        }

        Node q = head;

        while (q != null && q.next != p){
            q = q.next;
        }

        if(q == null)
            return;

        newNode.next = p;
        q.next = newNode;

    }

    //删除某个结点
    public void deleteByNode(Node p){
        if(p == null || head == null)
            return;

        if(p == head){
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }

        if(q == null)
            return;

        q.next = q.next.next;

    }

    //通过值删除结点（只删除第一个值等于value的结点）
    public void deleteByFirstValue(int value){
        if(head == null)   return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value){
            q = p;
            p = p.next;
        }
        if(p == null)   return;

        //第一次 p != null && p.data == value时，即头结点的值等于value
        if(q == null){
            head = head.next;
        }else {
            p.next = p.next.next;
        }
    }

    //删除所有值等于value的结点
    public void deleteAllNodeByValue(int value){
        //前几个结点都等于value时，while循环全删掉
        while (head != null && head.data == value){
            head = head.next;
        }

        Node p = head;

        while (p != null){
            if(p.next.data == value){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }

    }

    //打印所有结点的值
    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
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
    public Node reverse(Node p,Node m){ //p为头结点，m为中间结点
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
