package com.gcf;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 题目描述：输入一个二叉树，输出其镜像。
 * */
public class Solution {
    Scanner scanner = new Scanner(System.in);

    // 建立二叉树
    public TreeNode createTree(TreeNode root) {
        String val;
        val = scanner.next(); // next方法每次取到一个间隔符前面的数据
        if(val.equals("#")) {
            return null;
        }
        root = new TreeNode(Integer.parseInt(val));  System.out.println("输入的数据为：" + val);
        root.left = createTree(root.left);
        root.right = createTree(root.right);
        return root;
    }
    // 得到二叉树的镜像  —— 递归的方式
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if((root.left == null) && (root.right == null)) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
    // 得到二叉树的镜像 —— 不使用递归
    public void MirrorNotRecursive(TreeNode root) {
        java.util.LinkedList stack = new java.util.LinkedList();
        TreeNode temp = null;
        if(root == null) {
            return;
        }
        stack.add(root);
        while(stack.size() != 0) {
            TreeNode node = (TreeNode) stack.removeFirst();
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }
    }

    // 层次遍历二叉树
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList list = new LinkedList();
        list.add(root);
        while (list.size() != 0) {
            TreeNode node = (TreeNode) list.removeFirst(); // list.removeFirst() 该方法LinkedList才有
            System.out.print(node.val + " ");
            if(node.left != null) {
                list.add(node.left);
            }
            if(node.right != null) {
                list.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = null;
        root = solution.createTree(root);
        System.out.println("原二叉树的层次遍历");
        solution.levelTraverse(root);
        solution.Mirror(root);
        System.out.println("\n输出该二叉树的镜像");
        solution.levelTraverse(root);
        solution.MirrorNotRecursive(root);
        System.out.println("\n输出该二叉树的镜像（非递归方式）");
        solution.levelTraverse(root);
    }

    public class TreeNode{
        int val;//当前节点的值
        TreeNode left;//左节点
        TreeNode right;//右节点
        public TreeNode(int val){
            this.val = val;
        }
    }
}
