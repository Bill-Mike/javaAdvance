package com.wmr.javaAdvance.binarytree;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.Arrays;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Person> tree = new BinaryTree<>();
        tree.add(new Person("aa", 10));
        tree.add(new Person("bb", 15));
        tree.add(new Person("cc", 1));
        tree.add(new Person("dd", 3));
        tree.add(new Person("ee", 28));
        tree.add(new Person("ff", 30));
        tree.add(new Person("gg", 64));
        tree.add(new Person("kk", 80));
        tree.add(new Person("ll", 99));
        tree.remove(new Person("cc", 1));
        System.out.println(Arrays.toString(tree.toArray()));
    }
}


class BinaryTree<T extends Comparable<T>>{
    private class Node{
        private Comparable<T> data; //存放comparable,可以比较大小
        private Node parent;    //存放父节点
        private Node left;  //保存左子树
        private Node right; //保存右子树
        public Node(Comparable<T> data){    //构造方法直接分则尽心数据存储
            this.data = data;
        }

        /**
         * 实现节点数据的适当位置的存储
         * @param node 节点型数据
         */
        public void addNode(Node node){
            if(node.data.compareTo((T)this.data) <= 0){ //比较当前节点数据
                if(this.left == null){  //如果没有左子树
                    this.left = node;   //设置node为当前左子树
                    node.parent = this; //node的节点设置为当前节点
                }else {
                    this.left.addNode(node);
                }
            }else{  //比现有接待你数据更大
                if(this.left == null){  //当前节点的右子树为空
                    this.right = node;
                    node.parent = this;
                }else {
                    this.right.addNode(node);
                }
            }
        }

        /**
         * 实现所有数据的获取处理，并按照中序遍历形式来完成
         */
        public void toArrayNode(){
            if(this.left != null){  //有左子树
                this.left.toArrayNode();    //递归调用
            }
            BinaryTree.this.returnData[BinaryTree.this.foot ++] = this.data;
            if(this.right != null){
                this.right.toArrayNode();
            }
        }

        public boolean containsNode(Comparable<T> data){
            if(data.compareTo((T)this.data) == 0){
                return true; //找到了
            }
            else if(data.compareTo((T)this.data) < 0){
                if(this.left !=null){
                    return this.left.containsNode(data);
                }else {
                    return false;
                }
            }else {
                if(this.right != null){
                    return this.right.containsNode(data);
                }else {
                    return false;
                }
            }
        }
        /**
         * 获取要删除节点的对象
         * @param date //可比较的数据对象
         * @return  返回node
         */
        public Node getRemoveNode(Comparable<T> date){
            if(data.compareTo((T)this.data) == 0){
                return this; //找到了
            }
            else if(data.compareTo((T)this.data) < 0){
                if(this.left !=null){
                    return this.left.getRemoveNode(data);
                }else {
                    return null;
                }
            }else {
                if(this.right != null){
                    return this.right.getRemoveNode(data);
                }else {
                    return null;
                }
            }
        }

    }

    //----------- 以下是二叉树功能实现 -----------

    private Node root; //保存根节点
    private int count;
    private Object[] returnData; //返回树内的数据
    private int foot; //角标控制
    /**
     * 进行数据存储
     * @param data 要保存的数据内同
     * @exception NullPointerException 保存的数据不能为空
     */
    public void add(Comparable<T> data){
        if(data == null){
            throw new NullPointerException("保存的数据不嫩他为空");
        }
        //所有数据本身不具备有节点关系的匹配，那么一定要将其包装在Node类之中
        Node newNode = new Node(data);
        if (this.root == null){
            this.root = newNode;
        }else {
            this.root.addNode(newNode); //交由Node类处理
        }
        this.count ++;
    }

    /**
     * 以对象数组的形式返回全部数据
     * @return
     */
    public Object[] toArray(){
        if(this.count == 0){
            return null;
        }
        this.returnData = new Object[this.count];
        this.foot = 0;  //角标清零
        this.root.toArrayNode();    //直接通过node类负责
        return this.returnData; //返回全部的node数据
    }

    /*
            数据删除处理：
            1.如果删除的节点没有子节点，直接删除
            2.如果删除的节点只有一个子节点，则删除节点，字节带你代替源节点
            3.如果删除节点有两个字节点，首先找出其后继节点，
            然后处理后继节点和被删除节点的付姐带你之间的关系，
            最后处理后继节点的子节点和被杀出节点的子节点之间的关系
         */
    public void remove(Comparable<T> data){
        Node removeNode = this.root.getRemoveNode(data);
        if(removeNode != null){
            if (removeNode.left == null && removeNode.left == null){ //没有子节点，父节点断开连接
                removeNode.parent = null;
            }else if(removeNode.left != null && removeNode.right == null){  //没有右节点，左子节点代替原节点
                removeNode.left.parent = removeNode.parent;
            }else  if(removeNode.left == null && removeNode.right != null){//没有左节点，右子节点代替原节点
                removeNode.right.parent = removeNode.parent;
            }else{  //两边都有节点，则将右节点中最左的节点找到改变其指向
                Node moveNode = removeNode.right;   //移动的节点
                while(moveNode.left != null){
                    moveNode = moveNode.left;   //将删除节点的右节点的最左节点付给移动节点
                }
                moveNode.parent.left = null;
                moveNode.parent = removeNode.parent;
                moveNode.right = removeNode.right;
            }
        }
    }
}

class Person implements Comparable<Person>{
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age;
    }
}