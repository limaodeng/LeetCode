package com.datastructure.queue;

/**
 * 链表实现链式队列
 *
 * @Auther: dlm
 * @Date: 2020/4/7 19:44
 */
public class LinkedListQueue<T> {

    private Node head;  //队头指针

    private Node tail;  //队尾指针

    //入队
    public boolean enqueue(T value){
        Node newNode = new Node(value,null);
        if(tail == null){   //队空
            tail = newNode;
            head = newNode;
        }else {
            tail.next = newNode;
            tail = tail.next;
        }
        return true;
    }

    //出队
    public T dequeue(){
        //队空
        if(head == null)
            return null;

        T value = (T)head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return value;
    }

    public class Node<T>{

        private T data;

        private Node next;

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }

        public T getData(){
            return this.data;
        }

    }
}
