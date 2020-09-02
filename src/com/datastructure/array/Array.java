package com.datastructure.array;

/**
 * 1、数组的插入、删除、按下标随机访问
 * 2、数组中的数据类型是int
 * @Auther: dlm
 * @Date: 2020/4/4 16:25
 */
public class Array {

    private int[] data; //整型数组，用于保存数据

    private int n;  //数组大小

    private int count;  //数组中实际的个数

    //构造函数
    public Array(int n){
        this.data = new int[n];
        this.n = n;
        this.count = 0;  //初始化实际个数为0
    }

    //按下标随机访问
    public int find(int index){
        //判断下标是否在指定范围内
        if(index < 0 || index >= count){
            return -1;
        }
        return data[index];
    }

    //插入
    public boolean insert(int index,int value){
        if(count == n){ //数组已满
            return false;
        }

        if(index < 0 || index > count){
            System.out.printf("位置不合法！");
            return false;
        }

        /*//单独处理，要不然脚本会越界
        if(count == index && count ==0){
            data[index] = value;
            count++;
            return true;
        }*/

        //角标合法
        for(int i = count - 1;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] = value;
        count++;
        return true;
    }

    //删除
    public boolean delete(int index){
        if(index < 0 || index >= count){
            return false;
        }
        for (int i = index + 1;i < count;i++){
            data[i-1] = data[i];
        }
        count--;
        return true;
    }

    //打印
    public void printAll(){
        for(int i = 0;i < count;i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0,1);
        array.insert(0,2);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
        array.delete(3);
        array.printAll();
        System.out.println(array.find(2));
    }

}
