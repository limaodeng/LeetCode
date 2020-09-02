package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: dlm
 * @Date: 2020/2/26 00:48
 * @Description:
 */
public class CombinationSum_39 {

    /**
     * 题目：
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
     *
     * find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * The same repeated number may be chosen from candidates unlimited number of times.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *
     */
    public static void main(String[] args) {
        int[] candidates = {3,2,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<candidates.length; i++){
            if(candidates[i]<=target){
                ArrayList<Integer> curRes = new ArrayList<>();
                curRes.add(candidates[i]);
                res = dfs(candidates, i, target-candidates[i], res, curRes);
            }
            else break;
        }
        return res;
    }

    public static List<List<Integer>> dfs(int[] candidates,int index, int target, List<List<Integer>> res, ArrayList<Integer> curRes){
        if(target==0){
            ArrayList<Integer> curResCopy = new ArrayList<>();
            curResCopy.addAll(curRes);
            res.add(curResCopy);
            return res;
        }else{
            for(int i=index; i<candidates.length; i++){
                if(candidates[i]<=target){
                    curRes.add(candidates[i]);
                    res = dfs(candidates, i, target-candidates[i], res, curRes);
                    curRes.remove(curRes.size()-1);
                }else {
                    break;
                }
            }
        }
        return res;
    }

}