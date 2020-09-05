package com.leetcode.array;

public class FindCelebrity_277 {
    public static void main(String[] args) {

    }

    public static int findCelebrity(int n) {
        boolean[] arr = new boolean[n];
        for (int i = 0;i < arr.length;i++){
            arr[i] = true;
        }
        for (int i = 0;i < arr.length;i++){
            for (int j = 0;j < arr.length;j++){
                if (arr[i] && i != j){
                    if (know(i,j) || !know(j,i)){
                        arr[i] = false;
                        break;
                    }else {
                        arr[j] = false;
                    }
                }
            }
            if (arr[i])
                return i;
        }
        return -1;
    }

    public static int findCelebrity2(int n) {
        int res = 0;
        for (int i = 0;i < n;i++){
            if (know(res,i)) res = i;
        }
        for(int j = 0;j < n;j++){
            if (res != j && (know(res,j) || !know(j,res)))
                return -1;
        }
        return res;
    }

    /**
     *  判断i是否认识k
     * @param i
     * @param k
     */
    public static boolean know(int i,int k){
        return  true;
    }
}
