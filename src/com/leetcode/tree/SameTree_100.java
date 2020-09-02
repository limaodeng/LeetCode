package com.leetcode.tree;

import com.datastructure.binarytree.TreeNode;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/20 22:57
 * @Version 1.0
 */
public class SameTree_100 {

    /**
     * Given two binary trees, write a function to check if they are the same or not.
     *
     * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
     *
     * Example 1:
     *
     * Input:     1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * Output: true
     * Example 2:
     *
     * Input:     1         1
     *           /           \
     *          2             2
     *
     *         [1,2],     [1,null,2]
     *
     * Output: false
     * Example 3:
     *
     * Input:     1         1
     *           / \       / \
     *          2   1     1   2
     *
     *         [1,2,1],   [1,1,2]
     *
     * Output: false
     *
     */
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(2,null,null);
        TreeNode p2 = new TreeNode(1,null,null);
        TreeNode p = new TreeNode(3,p1,p2);

        TreeNode q1 = new TreeNode(2,null,null);
        TreeNode q2 = new TreeNode(1,null,null);
        TreeNode q = new TreeNode(3,q1,q2);

        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;
        if(p.value != q.value) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p.value != q.value) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
