package com.datastructure.queue;



/**
 * 数组实现顺序队列
 *
 * @Auther: dlm
 * @Date: 2020/4/7 19:03
 */
public class ArrayQueue<T> {

    private static final int DEFAULT_CAPACITY = 1 << 3;

    private int capacity; //队列大小

    private T[] data; //存储数据

    private int head; //队头下标

    private int tail; //队尾下标

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        this.data = (T[])new Object[capacity];
    }

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    //入队
    public boolean enqueue(T value){
        //队满
        if(tail == capacity)
            return false;
        //将元素放到队尾，之后tail向后移动一位
        data[tail++] = value;
        return true;
    }

    //出队
    public T dequeue(){
        //队空
        if(head == tail)
            return null;
        //队头元素出队，之后head向后移动一位
        T value = data[head++];
        return value;
    }

    //入队优化
    public boolean enqueue_enhance(T value){

        if(tail == capacity){
            if(head == 0)   // tail == capacity && head == 0 表示队满
                return false;

            //整体移动元素
            for(int i = head;i < tail;i++){
                data[i - head] = data[i];
            }

            //重置 head 和 tail
            tail = tail - head;
            head = 0;
        }

        //将元素放到队尾，之后tail向后移动一位
        data[tail++] = value;
        return true;
    }

    //判断是否队空
    public boolean isEmpty(){
        if(head == tail){
            return true;
        }
        return false;
    }

}
