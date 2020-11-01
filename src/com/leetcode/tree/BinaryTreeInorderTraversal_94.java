package com.leetcode.tree;

import java.util.*;

/**
 * @ClassComment: 二叉树中序遍历
 * @Auther: dlm
 * @Date: 2020/11/2 00:14
 * @Version 1.0
 */
public class BinaryTreeInorderTraversal_94 {

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     * <p>
     * Example 1:
     * <p>
     * Input: root = [1,null,2,3]
     * Output: [1,3,2]
     * Example 2:
     * <p>
     * Input: root = []
     * Output: []
     * Example 3:
     * <p>
     * Input: root = [1]
     * Output: [1]
     * Example 4:
     * <p>
     * <p>
     * Input: root = [1,2]
     * Output: [2,1]
     * Example 5:
     * <p>
     * Input: root = [1,null,2]
     * Output: [1,2]
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     * <p>
     * Follow up:
     * <p>
     * Recursive solution is trivial, could you do it iteratively?
     */
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal0(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        midTraversalRecursion(treeNode,list);
        return list;
    }

    //中序遍历（递归）
    public  void midTraversalRecursion(TreeNode treeNode,List<Integer> list) {
        if (treeNode == null) return;
        midTraversalRecursion(treeNode.left,list);
        list.add(treeNode.val);
        midTraversalRecursion(treeNode.right,list);
    }

    //中序遍历（迭代）
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    //中序遍历2（迭代）
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> visitedList = new ArrayList<>();
        Map<TreeNode, Integer> visitedNodeMap = new HashMap<>();//保存已访问的节点
        Stack<TreeNode> toBeVisitedNodes = new Stack<>();//待访问的节点
        if (root == null)
            return visitedList;
        toBeVisitedNodes.push(root);
        while (!toBeVisitedNodes.isEmpty()) {
            TreeNode tempNode = toBeVisitedNodes.peek(); //注意这里是peek而不是pop
            while (tempNode.left != null) { //如果该节点的左节点还未被访问，则需先访问其左节点
                if (visitedNodeMap.get(tempNode.left) != null) //该节点已经被访问（不存在某个节点已被访问但其左节点还未被访问的情况）
                    break;
                toBeVisitedNodes.push(tempNode.left);
                tempNode = tempNode.left;
            }
            tempNode = toBeVisitedNodes.pop();//访问节点
            visitedList.add(tempNode.val);
            visitedNodeMap.put(tempNode, 1);//将节点加入已访问map
            if (tempNode.right != null) //将右结点入栈
                toBeVisitedNodes.push(tempNode.right);
        }
        return visitedList;
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
