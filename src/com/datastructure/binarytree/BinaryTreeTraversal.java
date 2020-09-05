package com.datastructure.binarytree;


import com.datastructure.queue.ArrayQueue;


/**
 * @Auther: dlm
 * @Date: 2020/8/24 09:36
 * @Description:
 */
public class BinaryTreeTraversal {

    int data;    //数据

    public BinaryTreeTraversal left;     //左子树

    BinaryTreeTraversal right;    //右子树

    public BinaryTreeTraversal() {
    }

    BinaryTreeTraversal(int val) {
        this.data = val;
        left = null;
        right = null;
    }

    public void setVal(int val) {
        this.data = val;
    }

    public BinaryTreeTraversal(int data, BinaryTreeTraversal left, BinaryTreeTraversal right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};
    }

    /**
     * 创建二叉树
     * @param node
     * @param i
     * @return
     */
    public static BinaryTreeTraversal createTree(BinaryTreeTraversal node, int i) {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            node.setVal(TreeValue.TREE_VALUE[i]);
        }

        BinaryTreeTraversal leftChild = new BinaryTreeTraversal();
        node.left = createTree(leftChild, ++TreeValue.index);
        BinaryTreeTraversal rightChild = new BinaryTreeTraversal();
        node.right = createTree(rightChild, ++TreeValue.index);

        return node;
    }

    //前序遍历（递归）
    public static void preTraversal(BinaryTreeTraversal treeNode){
        if(treeNode == null) return;
        System.out.println(treeNode.data);
        preTraversal(treeNode.left);
        preTraversal(treeNode.right);
    }

    //前序遍历（迭代）

    //中序遍历（递归）
    public static void midTraversal(BinaryTreeTraversal treeNode){
        if(treeNode == null) return;
        preTraversal(treeNode.left);
        System.out.println(treeNode.data);
        preTraversal(treeNode.right);
    }
    //中序遍历（迭代）

    //后序遍历（递归）
    public static void backTraversal(BinaryTreeTraversal treeNode){
        if(treeNode == null) return;
        preTraversal(treeNode.left);
        preTraversal(treeNode.right);
        System.out.println(treeNode.data);
    }

    //后序遍历（迭代）

    //广度优先遍历或层次遍历（递归）

    //广度优先遍历或层次遍历（迭代）
    public static void layerTraversal(BinaryTreeTraversal treeNode){
        ArrayQueue<BinaryTreeTraversal> arrayQueue = new ArrayQueue<>();
        if(treeNode == null){
            return;
        }else {
            arrayQueue.enqueue(treeNode);
        }

        while (!arrayQueue.isEmpty()){
            BinaryTreeTraversal dequeue = arrayQueue.dequeue();
            System.out.println(dequeue.data);
            if (dequeue.left != null){
                arrayQueue.enqueue(dequeue.left);
            }

            if (dequeue.right != null){
                arrayQueue.enqueue(dequeue.right);
            }

        }
    }

    //深度优先遍历（递归）

    //深度优先遍历（迭代）

    public static void main(String[] args) {
        BinaryTreeTraversal root = new BinaryTreeTraversal();
        root = createTree(root, TreeValue.index);
        layerTraversal(root);
    }

}
