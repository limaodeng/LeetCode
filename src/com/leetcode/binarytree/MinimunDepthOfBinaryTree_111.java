package com.leetcode.binarytree;

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
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3,node9,null);
        System.out.println(minDepth(node3));
    }

    //深度优先遍历
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);
        return  1 + Math.min(minDepth(root.left),minDepth(root.right));
    }

    //广度优先遍历


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