package com.datastructure.binarytree;

/**
 * @ClassComment:
 * @Auther: dlm
 * @Date: 2020/8/13 00:17
 * @Version 1.0
 */
public class TreeNode {

    public int value;  //值

    public TreeNode left;  //左节点

    public TreeNode right; //右节点

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
