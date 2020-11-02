package com.leetcode.tree;

/**
 * @Auther: dlm
 * @Date: 2020/11/2 09:45
 * @Description:
 */
public class BalancedBinaryTree_110 {

    /**
     * Given a binary tree, determine if it is height-balanced.
     * <p>
     * For this problem, a height-balanced binary tree is defined as:
     * <p>
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [3,9,20,null,null,15,7]
     * Output: true
     * Example 2:
     * <p>
     * <p>
     * Input: root = [1,2,2,3,3,null,null,4,4]
     * Output: false
     * Example 3:
     * <p>
     * Input: root = []
     * Output: true
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 5000].
     * -104 <= Node.val <= 104
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(isBalanced2(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }


    public static boolean isBalanced2(TreeNode root) {
        if (checkDepth(root) == -1) return false;
        else return true;
    }

    static int checkDepth(TreeNode root) {
        if (root == null) return 0;
        int left = checkDepth(root.left);
        if (left == -1) return -1;
        int right = checkDepth(root.right);
        if (right == -1) return -1;
        int diff = Math.abs(left - right);
        if (diff > 1) return -1;
        else return 1 + Math.max(left, right);
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
