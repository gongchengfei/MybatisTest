package com.gcf;

import java.util.LinkedList;
import java.util.Scanner;

public class InvertTree {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InvertTree test = new InvertTree();
        TreeNode node = null;
        TreeNode coompleteTree = test.createTree(node);
        test.printTree(coompleteTree);
        test.invertTree(coompleteTree);
        test.printTree(coompleteTree);

    }

    /**
     * 创建二叉树，依然使用了递归思想
     * @param node
     * @return
     */
    public TreeNode createTree(TreeNode node){
        String val =  scanner.next();
        if (val.equals("#"))
            return null;
        System.out.println("此节点的值为：" + val);
        //这里的node属性不再指向形参中传递的对象，所以此处的node改变后，外层依然需要用 = 进行接收
        node = new TreeNode(Integer.parseInt(val));
        //此处必须要 = 进行接收，如果按照地址引用的思维，可能认为node.left对象作为参数传递对象地址进去（引用传递），方法返回后无需重新赋值，此处这种思想是错的
        node.left = createTree(node.left);
        node.right = createTree(node.right);
        return node;
    }

    public void printTree(TreeNode node){
        if (node == null) return;
        LinkedList<TreeNode> list = new LinkedList();
        list.add(node);
        while (list.size() != 0){//存在子节点
            //LinkedList特有的移除并返回链表中第一个元素，与add：在链表末尾添加元素搭配；
            //即可实现从上到下，从左到右的顺序遍历二叉树
            TreeNode root = list.removeFirst();
            System.out.println(root.val + " ");
            if (root.left != null)
                list.add(root.left);
            if (root.right != null)
                list.add(root.right);
        }
    }

    /**
     * 翻转二叉树，递归思想，交换某个节点下的左右节点即可
     * @param node
     */
    public void invertTree(TreeNode node){
        if(node == null) return;
        TreeNode tem = node.right;
        node.right = node.left;
        node.left = tem;
        invertTree(node.left);
        invertTree(node.right);
    }

    /**
     * 二叉树对象
     */
    public class TreeNode{
        int val;//当前节点的值
        TreeNode left;//左节点
        TreeNode right;//右节点
        public TreeNode(int val){
            this.val = val;
        }
    }
}
