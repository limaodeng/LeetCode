package com.datastructure.stack;

/**
 * 基于数组实现的顺序栈
 *
 * @Auther: dlm
 * @Date: 2020/4/7 12:33
 * @Description:
 */
public class ArrayStack<T> {

    private static final int DEFAULT_CAPACITY = 1 << 3;  //栈默认大小

    private int capacity;  //栈的大小

    private T[] data;   //存储元素

    private int count;  //栈中元素的个数

    public ArrayStack(int capacity){
        this.capacity = capacity;
        this.data = (T[])new Object[capacity];
        this.count = 0;
    }

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    //入栈
    public boolean push(T value){
        //栈满
        if(count == capacity)
            return false;

        data[count] = value;
        count++;
        return true;
    }

    // 出栈
    public T pop(){
        //栈空
        if(count == 0)
            return null;

        T obj = data[count-1];
        --count;
        return obj;
    }

    //判断栈是否为空
    public boolean empty(){
        return count == 0;
    }

    //获取栈中元素个数
    public int size(){
        return count;
    }
}
