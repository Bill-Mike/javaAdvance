package com.wmr.javaAdvance.linkedlist;

class Node<E>{
    private E data;
    private Node next;
    public Node(E data){
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class LinkDemo {
    public static void main(String[] args) {
        Node<String> n1 = new Node<String>("火车头");
        Node<String> n2 = new Node<String>("车厢1");
        Node<String> n3 = new Node<String>("车厢2");
        Node<String> n4 = new Node<String>("车厢3");
        Node<String> n5 = new Node<String>("车厢4");
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        printData(n1);
    }

    public static void printData(Node<?> node){
        if (node != null){
            System.out.println(node.getData());
            printData(node.getNext());
        }
    }
}
