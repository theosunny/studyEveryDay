package com.test.Util.Comparable;

/**
 * 基于Comparable接口实现二叉树排序
 */
public class BinarayTreeTest {
    class Node{
        private Comparable data;
        private Node left;
        private Node right;

        public void addNode(Node newNode){
            //确定放左树还是右树
            if (newNode.data.compareTo(this.data)<0) {
                if (this.left == null) {
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode);
                }
            }
            if (newNode.data.compareTo(this.data)>=0){
                if (this.right==null){
                    this.right =newNode;
                }else {
                    this.right.addNode(newNode);
                }
            }
        }
        public void printNode(){  //输出时采用中序遍历
            if (this.left!=null){  //先输出左子树
                this.left.printNode();
            }
            System.err.println(this.data+"\t");//输出跟节点
            if (this.right!=null){  //先输出左子树
                this.right.printNode();
            }
        }


    }
    private Node root;
    public void add(Comparable data){
        Node newNode = new Node();
        newNode.data=data;
        if (root==null){
            root=newNode;
        }else{
            root.addNode(newNode);
        }
    }
    public void print(){
        this.root.printNode();
    }

    public static void main(String[] args){
        /**beigin* 便于理解/
        Comparable c = 2;
        System.err.println(c);
        /**end*/
        BinarayTreeTest t = new BinarayTreeTest();
        t.add(1);
        t.add(3);
        t.add(4);
        t.add(2);
        t.add(1);
        t.add(5);
        t.print();
    }
}
