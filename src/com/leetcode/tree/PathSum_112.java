package com.leetcode.tree;

import java.util.Stack;

/**
 * @Auther: dlm
 * @Date: 2020/11/30 11:11
 * @Description: 二叉树的路径和
 */
public class PathSum_112 {

    public static void main(String[] args) {

    }

    //迭代
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();

            if(treeNode.left == null && treeNode.right == null && treeNode.val == sum)
                return true;

            if(treeNode.left != null){
                treeNode.left.val += treeNode.val;
                stack.push(treeNode.left);
            }

            if(treeNode.right != null){
                treeNode.right.val += treeNode.val;
                stack.push(treeNode.right);
            }

        }

        return false;
    }

    // 递归
    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
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
