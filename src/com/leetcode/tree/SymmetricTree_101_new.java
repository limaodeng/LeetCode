package com.leetcode.tree;

import scala.collection.immutable.Nil;

import java.util.Stack;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2021/5/13 23:40
 * @Version 1.0
 */
public class SymmetricTree_101_new {

    /**
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
     */
    public static void main(String[] args) {

        TreeNode treeNodeLeft3 = new TreeNode(3,null,null);
        TreeNode treeNodeLeft4 = new TreeNode(4,null,null);

        TreeNode treeNodeRight3 = new TreeNode(3,null,null);
        TreeNode treeNodeRight4 = new TreeNode(4,null,null);

        TreeNode treeNodeLeft2 = new TreeNode(2,treeNodeLeft3,treeNodeLeft4);
        TreeNode treeNodeRight2 = new TreeNode(2,treeNodeRight4,treeNodeRight3);

        TreeNode treeNodeRight1 = new TreeNode(1,treeNodeLeft2,treeNodeRight2);

        System.out.println(isSymmetricTree2(treeNodeRight1));

    }

    /**
     * 方式1：递归
     */
    public static boolean isSymmetricTree(TreeNode root){
        return root != null && helper(root.left,root.right);
    }

    public static boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if((left != null && right == null) || (left == null && right != null)){
            return false;
        }
        if(left.value != right.value){
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }

    /**
     * 方式2：栈
     */
    public static boolean isSymmetricTree2(TreeNode root){
        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        if(root.left != null){
            if(root.right != null){
                stack.push(root.left);
                stack.push(root.right);
            }else {
                return false;
            }
        }else if(root.right != null){
            return false;
        }

        while (!stack.isEmpty()){
            if(stack.size() % 2 != 0){
                return false;
            }

            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if(left.value != right.value){
                return false;
            }

            if(left.left != null){
                if(right.right != null){
                    stack.push(left.left);
                    stack.push(right.right);
                }else {
                    return false;
                }
            }else if(right.right != null){
                return false;
            }

            if(left.right != null){
                if(right.left != null){
                    stack.push(left.right);
                    stack.push(right.left);
                }else {
                    return false;
                }
            }else if(right.left != null){
                return false;
            }

        }

        return true;
    }

    public static class TreeNode{

        private int value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(){

        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


}
