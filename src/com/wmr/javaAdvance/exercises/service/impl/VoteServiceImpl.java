package com.wmr.javaAdvance.exercises.service.impl;

import com.wmr.javaAdvance.exercises.entity.Candidate;
import com.wmr.javaAdvance.exercises.service.IVoteService;

import java.util.Arrays;

public class VoteServiceImpl implements IVoteService {
    Candidate[] candidates = new Candidate[]{new Candidate(1,"张三",0),new Candidate(2,"李四",0),new Candidate(3,"王五",0),new Candidate(4,"赵六",0)};
    @Override
    public Candidate[] result() {
        Arrays.sort(candidates);
        return this.candidates;
    }

    @Override
    public Candidate[] getData() {
        return this.candidates;
    }

    @Override
    public boolean inc(int num) {
        for(int x = 0; x < candidates.length; x++){
            if(this.candidates[x].getNum() == num){
                this.candidates[x].setPoll(this.candidates[x].getPoll() + 1);
                return true;
            }
        }
        return false;
    }
}
