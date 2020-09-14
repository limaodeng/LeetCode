package com.leetcode.binarytree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Auther: dlm
 * @Date: 2020/9/10 09:22
 * @Description:
 */
public class MinimunDepthOfBinaryTree_111 {

    /**
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along
     *
     * the shortest path from the root node down to the nearest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its minimum depth = 2.
     *
     */
    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3,node9,node20);
        System.out.println(minDepth2(node3));
    }

    //广度优先遍历
    public static int minDepth2(TreeNode root) {
        if(root == null) return 0;
        BlockingDeque<TreeNode> queue =  new LinkedBlockingDeque<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()){
            res++;
            for (int i = queue.size();i > 0;i--){
                TreeNode treeNode = queue.poll();
                if(treeNode.left == null && treeNode.right == null) return res;
                if(treeNode.left != null) queue.add(treeNode.left);
                if(treeNode.right != null) queue.add(treeNode.right);
            }
        }
        return res;
    }

    //深度优先遍历
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);
        return  1 + Math.min(minDepth(root.left),minDepth(root.right));
    }

    public static class TreeNode {
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