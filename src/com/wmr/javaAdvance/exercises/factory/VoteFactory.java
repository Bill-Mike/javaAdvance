package com.wmr.javaAdvance.exercises.factory;

import com.wmr.javaAdvance.exercises.service.IVoteService;
import com.wmr.javaAdvance.exercises.service.impl.VoteServiceImpl;

public class VoteFactory {
    private VoteFactory(){}

    public static IVoteService getInstance(){
        return new VoteServiceImpl();
    }
}
