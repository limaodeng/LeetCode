package com.leetcode.array;

public class GasStation_134 {
    public static void main(String[] args) {

    }

    public static int gasStation(int[] gas,int[] cost){
        int start = 0;
        int sum = 0;
        for (int i = 0;i < gas.length;i++){
            sum += gas[i] - cost[i];
            if (sum < 0){
                start += 1;
                sum = 0;
            }
        }
        return sum > 0 ? sum : -1;
    }
}
