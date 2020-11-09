package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Auther: dlm
 * @Date: 2020/11/9 10:27
 * @Description: 翻转二叉树
 */
public class InvertBinaryTree_226 {

    /**
     * Invert a binary tree.
     *
     * Example:
     *
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * Output:
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     *
     * Google: 90% of our engineers use the software you wrote (Homebrew),
     * but you can’t invert a binary tree on a whiteboard so f*** off.
     *
     */
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root6 = new TreeNode(6);
        TreeNode root9 = new TreeNode(9);
        TreeNode root2 = new TreeNode(2,root1,root3);
        TreeNode root7 = new TreeNode(7,root6,root9);
        TreeNode root = new TreeNode(4,root2,root7);
        System.out.println(invertTree(root));
    }

    //非递归
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);
        }
        return root;
    }

    //递归
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
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
