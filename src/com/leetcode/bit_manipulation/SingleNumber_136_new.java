package com.leetcode.bit_manipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2021/5/16 19:12
 * @Version 1.0
 */
public class SingleNumber_136_new {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber2(nums));
    }

    //方式2：位运算
    public static int singleNumber2(int[] nums){
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }


    //方式1：使用set解决
    public static int singleNumber(int[] nums){
        Set<Integer> set = new TreeSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }
        return ((TreeSet<Integer>) set).first();
    }


}
