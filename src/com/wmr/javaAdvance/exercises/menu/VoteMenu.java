package com.wmr.javaAdvance.exercises.menu;

import com.wmr.javaAdvance.exercises.entity.Candidate;
import com.wmr.javaAdvance.exercises.factory.VoteFactory;
import com.wmr.javaAdvance.exercises.service.IVoteService;
import com.wmr.javaAdvance.exercises.utils.InputUtil;

import java.util.Arrays;

public class VoteMenu {
    private IVoteService voteService;

    public VoteMenu(){
        this.voteService = VoteFactory.getInstance();
        this.vote();
    }

    private void vote(){
        Candidate[] candidates = this.voteService.getData();
        for (Candidate candidate: candidates){
            System.out.println(candidate.getNum() + ":" + candidate.getName() + "【票数】"+ candidate.getPoll());
        }

        int num = 10;
        while (num != 0){
            num = InputUtil.getInt("请输入班长候选人代号（输入0结束）");
            if(num != 0){
                if(!this.voteService.inc(num)){
                    System.out.println("此选票无效，请输入正确的候选人代号");
                }
            }
        }

        System.out.println("投票结束");
        System.out.println(Arrays.toString(this.voteService.result()));
        System.out.println("候选人：" + candidates[0].getName() + "以"+candidates[0].getPoll()+"票数获胜");
    }
}
