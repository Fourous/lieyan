package com.lieyan.Service;

import com.lieyan.Entity.Coach;
import com.lieyan.mapper.CoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServicempl implements CoachService{
    @Autowired
    private CoachMapper coachMapper;
    public List<Coach> coachall (){
        return coachMapper.coachall();
    }

    public Coach coachone(Integer tid)
    {
        return coachMapper.coachquerybyid(tid);
    }

    public boolean coachlike(Integer tid) {
        Coach coach=coachMapper.coachquerybyid(tid);
        int like=coach.getLike();
        like+=1;
        System.out.println(like);
        int num=coachMapper.coachlike(tid,like);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean coachunlike(Integer tid){
        Coach coach=coachMapper.coachquerybyid(tid);
        int unlike=coach.getUnlike();
        unlike+=1;
        System.out.println(unlike);
        int num=coachMapper.coachunlike(tid,unlike);
        if(num>0){
            return true;
        }else {
            return false;
        }

    }

    public boolean coachlikere(Integer tid){
        Coach coach=coachMapper.coachquerybyid(tid);
        int like=coach.getLike();
        like-=1;
        int num=coachMapper.coachlikere(tid,like);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean coachunlikere(Integer tid){
        Coach coach=coachMapper.coachquerybyid(tid);
        int unlike=coach.getUnlike();
        unlike-=1;
        int num=coachMapper.coachunlikere(tid,unlike);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }




}
