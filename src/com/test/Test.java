package com.test;


import com.datastructure.linkedlist.SingleLinkedList;

/**
 * @Auther: dlm
 * @Date: 2020/4/10 15:03
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(myPow2(2,-2));
    }

    public static double myPow2(double x,int n){
        if(n == 0) return 1;
        double half = myPow2(x,n/2);
        if(n % 2 == 0) return half * half;
        if(n > 0) return half * half * x;
        return half * half / x;
    }

    public static double myPow(double x,int n){
        double result = 1.0;
        for(int i = n;i != 0;i /= 2){
            if(i % 2 != 0){
                result *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static class Node{

        public int data;   //存储数据，整型

        public Node next;  //指向下一个元素

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

    }
}