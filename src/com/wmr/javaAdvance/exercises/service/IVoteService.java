package com.wmr.javaAdvance.exercises.service;

import com.wmr.javaAdvance.exercises.entity.Candidate;

public interface IVoteService {
    public boolean inc(int num); //根据候选人编号进行增长
    public Candidate[] result(); //获取投票结果信息
    public Candidate[] getData(); //获取未排序前的投票信息
}
