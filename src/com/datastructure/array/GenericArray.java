package com.datastructure.array;

/**
 * 泛型数组
 * @Auther: dlm
 * @Date: 2020/4/4 18:09
 */
public class GenericArray<T> {

    private T[] data;   //保存数据

    private int size;   //数组中实际数据个数

    //构造方法
    public GenericArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    //无参构造，默认容量是10
    public GenericArray(){
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //获取数组当前元素个数
    public int count(){
        return this.size;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }

    //校验 index 角标是否合法
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("失败！要求：index >= 0 并且 index < size!");
        }
    }

    //修改 index 位置的元素
    public void set(int index,T e){
        checkIndex(index);  //检查角标是否合法
        data[index] = e;
    }

    //获取 index 位置的元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    //判断是否包含某元素
    public boolean contains(T e){
        for(int i = 0;i < size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //获取对应元素的角标，不存在则返回-1
    public int find(T e){
        for (int i = 0;i < size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //在某位置添加元素时，校验角标
    private void checkIndexForAdd(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("添加失败！要求：index >= 0 并且 index <= size!");
        }
    }

    //扩容
    private void resize(int capacity){
        T[] newData = (T[])new Object[capacity];
        for(int i = 0;i < size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean add(int index,T e){
        checkIndexForAdd(index);
        //如果当前数据已满，则扩容为原来的两倍
        if(size == data.length){
            resize(data.length * 2);
        }

        for(int i = size - 1;i <= index;i--){
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

        return true;
    }

    //向数组头插入元素
    public boolean addFirst(T e){
        add(0,e);
        return true;
    }

    //向数组尾插入元素
    public boolean addLast(T e){
        add(size,e);
        return true;
    }

    //删除 index 位置的元素
    public boolean delete(int index){
        checkIndex(index);

        for(int i = index + 1; i < size;i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        //缩容
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return true;
    }

    //删除第一个元素
    public boolean deleteFirst(){
        delete(0);
        return true;
    }

    //删除最后一个元素
    public boolean deleteLast(){
        delete(size-1);
        return true;
    }

    //从元素中删除指定元素
    public boolean deleteElement(T e){
        int i = find(e);
        if (i != -1){
            delete(i);
        }
        return true;
    }

    //重写toString方法
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
