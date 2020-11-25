package com.leetcode.array;


import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: dlm
 * @Date: 2020/11/25 09:54
 * @Description:
 */
public class ShuffleAnArray_384 {

    public static void main(String[] args) {
        int[] arr = {-6,10,184};
        Solution obj = new Solution(arr);
        System.out.println(obj.shuffle());
    }

    public static class  Solution{

        private int[] array;
        private int[] originalNums;

        public Solution(int[] array){
            this.array = array;
            this.originalNums = Arrays.copyOf(array, array.length);
        }

        public int[] reset() {
            return originalNums;
        }

        public int[] shuffle() {
            for (int i = 0; i < array.length; ++i) {
                int t = i + ((int)(Math.random()*100)+1) % (array.length - i);
                swap(array, i,t);
            }
            return array;
        }

        public int[] shuffle1() {
            Random random = new Random();
            for (int i = 0; i < array.length / 2; i++) {
                // 每次只需拿第一个元素进行交换即可
                swap(array, 0, random.nextInt(array.length));
            }
            return array;
        }

        private void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

}
