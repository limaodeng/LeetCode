package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/11/1 23:01
 * @Version 1.0
 */
public class BinaryTreeLevelOrderTraversalII_107 {

    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * return its bottom-up level order traversal as:
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     */
    public static void main(String[] args) {

    }

    //广度优先遍历或层次遍历（递归）
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        helper(resList,0,root);
        return resList;
    }

    public void helper(List<List<Integer>> resList, int dep, TreeNode root){
        if (root == null) {
            return;
        }
        if (resList.size() <= dep) {
            // 倒插
            resList.add(0,new ArrayList<Integer>());
        }

        helper(resList, dep + 1, root.left);
        helper(resList, dep + 1, root.right);
        resList.get(resList.size()-dep-1).add(root.val);
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return resList;
        } else {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(treeNode.left != null)
                    queue.add(treeNode.left);//先把左节点加入队列
                if(treeNode.right != null)
                    queue.add(treeNode.right);//再加入右节点
            }
            //倒插
            resList.add(0,list);
        }
        return resList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
