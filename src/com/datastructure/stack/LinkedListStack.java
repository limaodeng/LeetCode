package com.datastructure.stack;

/**
 * 基于链表实现的顺序栈
 * @Auther: dlm
 * @Date: 2020/4/7 12:48
 * @Description:
 */
public class LinkedListStack<T> {

    private Node top = null;   //栈顶指针

    //入栈
    public boolean push(T value){
        Node newNode = null;
        if(top == null)
            newNode = new Node(value,null);

        newNode.next = top;
        top = newNode;
        return true;
    }

    //出栈
    public T pop(){
        if(top == null)
            return null;
        T obj = (T)top.data;
        top = top.next;
        return obj;
    }

    public class Node<T>{

        private T data;

        private Node next;

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }
    }
}