package com.wmr.javaAdvance.linkedlist;

interface Ilink<E>{
    public void add(E e);
    public E get(int index);
    public int size();
    public void remove(int index);
}
class Linkimpl<E> implements Ilink<E>{
    private int count;
    private class Node{
        private E data;
        private Node next;
        public Node(E data){
            this.data = data;
        }

        private void addNode(Node node){
            if(this.next == null){
                this.next = node;
            }else {
                this.next.addNode(node);
            }
        }
    }
    // ----------------------- 以下为Link类中定义的结构----------------------
    private Node root; //根元素
    @Override
    public void add(E e) {
        if(e == null){
            return;
        }
        Node newnode = new Node(e);
        if (root == null){
            this.root = newnode;
        }else{
            this.root.addNode(newnode);
        }
        this.count++;
    }
    public E get(int index){
        E data = null;
        int i = 0;
        Node node = this.root;
        if(index > this.count){
            try {
                throw new Exception("索引越界！");
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        while (i < this.count){
            if(i < index -1){
                node = node.next;
            }else if(i == index -1){
                data = node.data;
            }
            i++;
        }

        return data;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public void remove(int index) {
        if(this.count < index || index <0){
            return;
        }
        Node last = null;
        int i = 0;
        while (i < this.count){
            //if(i)
            i++;
        }
        this.count--;
    }
}
public class LinkDemo2 {
    public static void main(String[] args) {
        Ilink<String> ilink = new Linkimpl<>();
        ilink.add("hello");
        ilink.add("world");
        ilink.add("!");
        System.out.println(ilink.size());
        printData(ilink);

    }
    public static void printData(Ilink ilink){
        System.out.println(ilink.get(4));
    }
}
