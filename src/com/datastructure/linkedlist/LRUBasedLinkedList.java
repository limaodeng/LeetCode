package com.datastructure.linkedlist;

import java.util.Scanner;

/**
 * 基于链表实现的LRU缓存算法
 *
 * @Auther: dlm
 * @Date: 2020/4/7 00:29
 */
public class LRUBasedLinkedList<T> {
    /**
     * 默认容量，2的3次方
     */
    private static final int DEFAULT_CAPACITY = 1 << 3;
    /**
     * 用户自定义容量
     */
    private int capacity;
    /**
     * 头结点
     */
    private Node<T> headNode;
    /**
     * 链表中实际的元素个数
     */
    private int count;

    public LRUBasedLinkedList(int capacity){
        this.capacity = capacity;
        this.headNode = new Node<>();
        this.count = 0;
    }

    public LRUBasedLinkedList(){
        this(DEFAULT_CAPACITY);
    }

    public void offer(T data){
        if(data == null){
            throw new IllegalArgumentException("不支持null!");
        }

        Node pre = findPreNode(data);

        if(pre == null){    //缓存中不存在该元素
            if(this.count >= this.capacity ){   //链表已满，删除链尾元素
                removeLastNode();
            }
            //在链头插入新元素
            addNodeInFirst(data);
        }else { //缓存中存在该元素
            //删除该元素
            removeTheNode(pre);
            //在表头插入该元素
            addNodeInFirst(data);
        }
    }

    //删除指定元素
    private void removeTheNode(Node pre) {
        pre.next = pre.next.next;
        count--;
    }

    //在链表头部插入结点
    private void addNodeInFirst(T data) {
        Node p = headNode;
        Node newNode = new Node(data,p.next);
        p.next = newNode;
        count++;
    }

    //删除最后一个结点
    private void removeLastNode() {
        Node p = headNode;

        if(p.next == null){
            return;
        }
        //倒数第二个结点
        while (p.next.next != null){
            p = p.next;
        }

        p.next = null;
        count--;
    }

    //寻找该元素的前一个结点
    private Node findPreNode(T data) {
        Node pre = headNode;
        while (pre.next != null){
            if(data.equals(pre.next.data)){
                return pre;
            }
        }
        return null;
    }

    public void printAll() {
        Node p = headNode.next;
        while (p != null){
            System.out.print(p.data + "  ");
            p = p.next;
        }
        System.out.println();
    }

    public class Node<T>{

        private T data; //存储数据

        private Node next;  //指向下一个结点

        public Node(){
            this.next = null;
        }

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }

        public T getData(){
            return this.data;
        }

    }

    public static void main(String[] args) {
        LRUBasedLinkedList list = new LRUBasedLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.offer(sc.nextInt());
            list.printAll();
        }
    }

}
