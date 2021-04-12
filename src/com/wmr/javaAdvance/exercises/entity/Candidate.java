package com.wmr.javaAdvance.exercises.entity;

public class Candidate implements Comparable<Candidate>{
    private int num;    //候选人编号
    private String name;    //候选人名称
    private int poll;   //候选人得票数

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoll() {
        return poll;
    }

    public void setPoll(int poll) {
        this.poll = poll;
    }

    public Candidate(int num, String name, int poll){
        this.num = num;
        this.name = name;
        this.poll = poll;
    }
    public Candidate(){

    }
    @Override
    public int compareTo(Candidate o) {
        return o.poll - this.poll;
    }

    @Override
    public String toString() {
        return "【编号：" + this.num + "姓名："+this.name+"票数："+this.poll+ "】";
    }
}
