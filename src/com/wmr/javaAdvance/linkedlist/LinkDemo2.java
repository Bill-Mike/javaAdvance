package com.wmr.javaAdvance.linkedlist;

interface Ilink<E>{
    public void add(E e);
    public E get(int index);
    public int size();
    public void remove(int index);
    public boolean isEmpty();
    public boolean contains(E e);
    public void clean();
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
        Node thisE = this.root;
        int i = 1;
        while (i < this.count){
            if(i == index){
                thisE= thisE.next.next;

            }else {
                thisE = thisE.next;
                break;
            }
            i++;
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        if(this.count == 0)
        return true;
        return false;
    }

    @Override
    public boolean contains(E e) {
        Node data = this.root;
        int i = 1;
        while (i <= this.count){
            if(data.data.equals(e)){
                return true;
            }
            data = data.next;
            i++;
        }
        return false;
    }

    @Override
    public void clean() {
        this.root = null;
        this.count = 0;
    }
}
public class LinkDemo2 {
    public static void main(String[] args) {
        Ilink<String> ilink = new Linkimpl<>();
        System.out.println(ilink.isEmpty());
        ilink.add("hello");
        ilink.add("world");
        ilink.add("!");
        System.out.println(ilink.isEmpty());
        System.out.println(ilink.contains("!"));
        System.out.println(ilink.size());
        System.out.println("--------------------");
        for(int i = 1; i <= ilink.size(); i++){
            System.out.println(ilink.get(i));
        }
        ilink.remove(2);
        System.out.println("_______________");
        for(int i = 1; i <= ilink.size(); i++){
            System.out.println(ilink.get(i));
        }
        printData(ilink);
        System.out.println(ilink.get(1));

    }
    public static void printData(Ilink ilink){
        System.out.println(ilink.get(2));
    }
}
