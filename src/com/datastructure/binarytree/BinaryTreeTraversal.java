package com.datastructure.binarytree;


import com.datastructure.queue.ArrayQueue;
import com.datastructure.stack.ArrayStack;

import java.util.*;


/**
 * @Auther: dlm
 * @Date: 2020/8/24 09:36
 * @Description:
 */
public class BinaryTreeTraversal {

    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{1, 2, 3, 0, 4, 5, 0, 0, 6, 0, 0, 7, 0, 0, 8, 0, 9, 10, 0, 0, 0};
    }

    /**
     * 创建二叉树
     *
     * @param node
     * @param i
     * @return
     */
    public static TreeNode createTree(TreeNode node, int i) {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            node.setVal(TreeValue.TREE_VALUE[i]);
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++TreeValue.index);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++TreeValue.index);

        return node;
    }

    //前序遍历（递归）
    public static void preTraversalRecursion(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.println(treeNode.value);
        preTraversalRecursion(treeNode.left);
        preTraversalRecursion(treeNode.right);
    }

    //前序遍历（迭代）
    public static void preTraversal(TreeNode treeNode) {
        ArrayStack<TreeNode> treeStack = new ArrayStack<>();
        if (treeNode == null)
            return;

        treeStack.push(treeNode);

        while (!treeStack.isEmpty()) {
            TreeNode treeNodePop = treeStack.pop();
            if (treeNodePop != null) {
                System.out.println(treeNodePop.value);
                if (treeNodePop.right != null)
                    treeStack.push(treeNodePop.right);
                if (treeNodePop.left != null)
                    treeStack.push(treeNodePop.left);
            }
        }

    }

    //中序遍历（递归）
    public static void midTraversalRecursion(TreeNode treeNode) {
        if (treeNode == null) return;
        midTraversalRecursion(treeNode.left);
        System.out.println(treeNode.value);
        midTraversalRecursion(treeNode.right);
    }

    //中序遍历（迭代）
    public static void inorderTraversal(TreeNode root) {
        ArrayStack<TreeNode> stack = new ArrayStack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value);
            cur = cur.right;
        }
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
            visitedList.add(tempNode.value);
            visitedNodeMap.put(tempNode, 1);//将节点加入已访问map
            if (tempNode.right != null) //将右结点入栈
                toBeVisitedNodes.push(tempNode.right);
        }
        return visitedList;
    }

    //后序遍历（递归）
    public static void backTraversalRecursion(TreeNode treeNode) {
        if (treeNode == null) return;
        backTraversalRecursion(treeNode.left);
        backTraversalRecursion(treeNode.right);
        System.out.println(treeNode.value);
    }

    //后序遍历（迭代）
    //一个”巧“的方法，即先采用类似先序遍历，
    // 先遍历根结点再右孩子最后左孩子（先序是先根结点再左孩子最后右孩子），
    // 最后把遍历的序列逆转即得到了后序遍历
    public static List<Integer> backTraversal(TreeNode root) {
        ArrayStack<TreeNode> stack = new ArrayStack<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.value);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(ret);
        return ret;
    }

    //后序遍历2（迭代）
    public static List<Integer> backTraversal2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null)
            return resultList;
        //已访问
        Map<TreeNode, Integer> visitedMap = new HashMap<>();
        //待访问
        Stack<TreeNode> toBeVisitedStack = new Stack<>();
        toBeVisitedStack.push(root);
        while (!toBeVisitedStack.isEmpty()) {
            TreeNode tempNode = toBeVisitedStack.peek(); //注意这里是peek而不是pop
            if (tempNode.left == null && tempNode.right == null) {
                //如果没有左右孩子则访问
                resultList.add(tempNode.value);
                visitedMap.put(tempNode, 1);
                toBeVisitedStack.pop();
                continue;
            } else if (!((tempNode.left != null && visitedMap.get(tempNode.left) == null)
                    || (tempNode.right != null && visitedMap.get(tempNode.right) == null))) {
                //如果节点的左右孩子均已被访问
                resultList.add(tempNode.value);
                toBeVisitedStack.pop();
                visitedMap.put(tempNode, 1);
                continue;
            }
            if (tempNode.left != null) {
                while (tempNode.left != null && visitedMap.get(tempNode.left) == null) {
                    //左孩子没有被访问
                    toBeVisitedStack.push(tempNode.left);
                    tempNode = tempNode.left;
                }
            }
            if (tempNode.right != null) {
                if (visitedMap.get(tempNode.right) == null) {//右孩子没有被访问
                    toBeVisitedStack.push(tempNode.right);
                }
            }
        }
        return resultList;
    }


    //广度优先遍历或层次遍历（递归）
    public static void layerTraversalRecursion(List<List<Integer>> resList, int dep, TreeNode root) {
        if (root == null) {
            return;
        }
        if (resList.size() > dep) {
            resList.get(dep).add(root.value);
        } else {
            List<Integer> r = new ArrayList<Integer>();
            r.add(root.value);
            resList.add(r);
        }

        layerTraversalRecursion(resList, dep + 1, root.left);
        layerTraversalRecursion(resList, dep + 1, root.right);
    }

    //广度优先遍历或层次遍历（迭代）
    public static void layerTraversal(TreeNode treeNode) {
        ArrayQueue<TreeNode> arrayQueue = new ArrayQueue<>();
        if (treeNode == null) {
            return;
        } else {
            arrayQueue.enqueue(treeNode);
        }

        while (!arrayQueue.isEmpty()) {
            TreeNode dequeue = arrayQueue.dequeue();
            System.out.println(dequeue.value);
            if (dequeue.left != null) {
                arrayQueue.enqueue(dequeue.left);
            }

            if (dequeue.right != null) {
                arrayQueue.enqueue(dequeue.right);
            }

        }
    }

    //深度优先遍历（递归）
    public static void depthOrderTraversalRecursive(TreeNode root) {
        depthTraversalRecursive(root);
    }

    private static void depthTraversalRecursive(TreeNode tn) {
        if (tn != null) {
            System.out.println(tn.value);
            depthTraversal(tn.left);
            depthTraversal(tn.right);
        }
    }


    //深度优先遍历（迭代）
    public static void depthTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.value);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = createTree(root, TreeValue.index);
        depthOrderTraversalRecursive(root);
    }

}
