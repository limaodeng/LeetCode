package com.leetcode.binarysearch;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {1, 1,1,1,1,2,2, 3, 4, 5, 6, 7};
        int result = firstLessBSearch(arr,2);
        System.out.println(result);
    }

    /**
     * 查找第一个等于给定值的元素
     * @param array 有序数组
     * @param target 要查找的元素
     * @return
     */
    public static int firstEqualBSearch(int[] array,int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){

            int middle = left + ((right - left) >> 1);

            if(array[middle] > target){ //大于
                right = middle - 1;
            }else if(array[middle] < target){ //小于
                left = middle + 1;
            }else { //等于
                //如果当前为第一个元素或者
                //当前元素的前一个元素不等target，则返回当前角标
                //否则继续查找
                if(middle == 0 || array[middle - 1] != target ){
                    return middle;
                }else {
                    right = middle - 1;
                }
            }
        }
        return -1; //找不到
    }

    /**
     * 查找第一个大于给定值的元素
     * @param array 有序数组
     * @param target 要查找的元素
     * @return
     */
    public static int firstGreaterBSearch(int[] array,int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){

            int middle = left + ((right - left) >> 1);

            if(array[middle] > target){ //大于
                //如果当前是第一个元素，
                //或者当前元素的前一个元素小于等于给定值，则返回
                //否则继续查找
                if (middle == 0 || array[middle-1] <= target){
                    return middle;
                }else {
                    right =  middle - 1;
                }
            }else {
                left = middle + 1;
            }
        }
        return -1; //找不到
    }

    /**
     * 查找最后一个小于给定值的元素
     * @param array 有序数组
     * @param target 要查找的元素
     * @return
     */
    public static int firstLessBSearch(int[] array,int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){

            int middle = left + ((right - left) >> 1);

            if(array[middle] < target){ //小于
                //如果当前元素的后一个元素大于等于给定值，则返回
                //否则继续查找
                if (array[middle+1] >= target){
                    return middle;
                }else {
                    left =  middle + 1;
                }
            }else {
                right = middle - 1;
            }
        }
        return -1; //找不到
    }

    /**
     * 循环版-二分查找
     * @param array 有序数组
     * @param target 要查找的元素
     * @return
     */
    public static int binarySearch(int[] array,int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int middle = left + ((right - left) >> 1);
            if(array[middle] > target){ //大于
                right = middle - 1;
            }else if(array[middle] < target){ //小于
                left = middle + 1;
            }else { //等于（此情况较少出现，所以放在后面）
                return middle;
            }
        }
        return -1; //找不到
    }

    /**
     * 递归版-二分查找
     * @param array 有序数组
     * @param left  左下标
     * @param right 右下标
     * @param target 要查找的元素
     * @return
     */
    public static int recursiveBSearch(int[] array,int left,int right,int target){
        if(left > right){
            return -1;
        }
        //计算中间角标
        int middle = left + ((right - left) >> 1);

        if(array[middle] > target){//大于
            return recursiveBSearch(array,left,middle - 1,target);
        }else if(array[middle] < target){//小于
            return recursiveBSearch(array,middle + 1,right,target);
        }else { //等于
            return middle;
        }

    }










    public static int lower_bound(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static int upper_bound(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;    //最后结果减1
    }

    public static int binary_search(int[] arr,int target,int row,int high){
        while(row <= high){
            int m = (row + high) / 2;
            if(arr[m] == target){
                return m;
            }
            if(arr[m] > target){
                high = m - 1;
            }else {
                row = m + 1;
            }
        }
        return -1;
    }

}
