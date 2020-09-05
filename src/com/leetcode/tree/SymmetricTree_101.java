package com.leetcode.tree;


import com.datastructure.binarytree.TreeNode;
import com.datastructure.stack.ArrayStack;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/12 22:56
 * @Version 1.0
 */
public class SymmetricTree_101 {

    /**
     *题目描述：
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     *
     * But the following [1,2,2,null,3,null,3] is not:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode6;
        treeNode2.right = treeNode5;
        System.out.println(isSymmetric2(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left,root.right);
    }

    public static boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return left == right;
        if(left.value != right.value)
            return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        ArrayStack<TreeNode> stack = new ArrayStack<TreeNode>();
        TreeNode left,right;
        if(root == null) return true;
        if(root.left != null){
            if(root.right == null){
                return false;
            }
            stack.push(root.left);
            stack.push(root.right);
        }else if(root.right != null){
            return false;
        }

        while (!stack.isEmpty()){
            if(stack.size() % 2 != 0) return false;

            left = stack.pop();
            right = stack.pop();

            if(left.value != right.value) return false;

            if(left.left != null){
                if(right.right == null){
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            }else if(right.right != null){
                return false;
            }

            if(left.right != null){
                if(right.left == null){
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            }else if(right.left != null){
                return false;
            }

        }

        return true;
    }

}
