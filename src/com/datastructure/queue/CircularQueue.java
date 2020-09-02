package com.datastructure.queue;

/**
 * 循环队列
 *
 * @Auther: dlm
 * @Date: 2020/4/7 20:54
 */
public class CircularQueue<T>{
    //默认容量
    private static final int DEFAULT_CAPACITY = 1 << 3;
    //自定义容量
    private int capacity;
    //存储数据
    private T[] data;
    //队头下标
    private int head;
    //队尾下标
    private int tail;

    public CircularQueue(int capacity){
        this.capacity = capacity;
        this.data = (T[])new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public CircularQueue(){
        this(DEFAULT_CAPACITY);
    }

    //入队
    public boolean enqueue(T value){
        //队满
        if((tail + 1) % capacity == head )
            return false;

        data[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    //出队
    public T dequeue(){
        //队空
        if(head == tail)
            return null;

        T value = data[head];
        head = (head + 1) % capacity;
        return value;
    }

}
