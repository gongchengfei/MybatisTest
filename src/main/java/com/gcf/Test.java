package com.gcf;

public class Test {

    public Node recursion(Node node){
        //递归
        if (node == null || node.next == null)
            return node;
        Node tmp = node.next;
        Node newHead = recursion(tmp);
        tmp.next = node;//每次递归的主要事情，确定下一个节点
        node.next = null;//在最后一个节点处起作用

        return newHead;
    }


    public Node reverse(Node node){
        //三指针法
        Node pre = null;
        Node next;
        while(node.next != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


    public class Node{
        String value;
        Node next;

        public Node(String value){
            this.value = value;
        }
    }
}
