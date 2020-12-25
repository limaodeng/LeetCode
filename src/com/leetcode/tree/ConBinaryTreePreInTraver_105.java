package com.leetcode.tree;

/**
 * @Auther: dlm
 * @Date: 2020/12/25 09:11
 * @Description: 前序遍历和中序遍历构建二叉树
 */
public class ConBinaryTreePreInTraver_105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) return null;
        int i = 0;
        for (i = iLeft; i <= iRight; ++i) {
            if (preorder[pLeft] == inorder[i]) break;
        }
        TreeNode cur = new TreeNode(preorder[pLeft]);
        cur.left = helper(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
        cur.right = helper(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
        return cur;
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
