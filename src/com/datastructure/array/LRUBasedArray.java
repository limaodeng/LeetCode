package com.datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 *
 * @Auther: dlm
 * @Date: 2020/4/6 17:31
 */
public class LRUBasedArray<T> {
    //默认容量  2的3次方
    private static final int DEFALUT_CAPACITY = (1 << 3);
    //用户自定义容量
    private int capacity;
    //现有元素个数
    private int count;
    //存储元素的数组
    private T[] value;
    //存储元素及其位置的对应关系
    private Map<T,Integer> holder;

    public LRUBasedArray(int capacity){
        this.capacity = capacity;
        this.count = 0;
        this.value = (T[])new Object[capacity];
        holder = new HashMap<>(capacity);
    }

    public LRUBasedArray(){
        this(DEFALUT_CAPACITY);
    }

    //访问某元素
    public void offer(T value){

        if(value == null){
            throw new IllegalArgumentException("暂不支持null！");
        }

        Integer index = holder.get(value);
        if(index == null){  //缓存中不存在该元素
            if(isFull()){   //缓存已满
                removeAndCache(value);
            }else{  //缓存未满
                cache(value,count);
            }

        }else { //缓存存在该元素
            update(value,index);
        }
    }

    private void removeAndCache(T e) {
        T last = value[--count];
        holder.remove(last);
        cache(e,count);
    }

    private void update(T e, Integer index) {
        rightShift(index);
        value[0] = e;
        holder.put(e,0);
    }

    private void cache(T e,int end) {
        rightShift(end);
        value[0] = e;
        holder.put(e,0);
        count++;
    }

    //将count之前的元素都向右移动
    private void rightShift(int end) {
        for(int i = end - 1;i >= 0 ;i--){
            value[i+1] = value[i];
            holder.put(value[i],i + 1);
        }
    }

    private boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < count;i++){
            stringBuilder.append(value[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    static class TestLRUBasedArray{
        public static void main(String[] args) {
            testDefalutCapacity();
            //testSpecificCapacity(4);
            //testException();
        }

        public static void testDefalutCapacity(){
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecificCapacity(int capacity){
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }

        public static void testException(){
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

    }

}
