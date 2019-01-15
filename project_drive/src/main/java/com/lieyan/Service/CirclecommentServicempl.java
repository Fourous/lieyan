package com.lieyan.Service;

import com.lieyan.Entity.*;
import com.lieyan.mapper.CircleMapper;
import com.lieyan.mapper.CirclecommentMapper;
import com.lieyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CirclecommentServicempl implements CirclecommentService {
    @Autowired
    private CirclecommentMapper circlecommentMapper;
    @Autowired
    private UserMapper userMapper;
    public boolean circlecommentinsert(Integer circleid,String openid,String comment){
        int set=circlecommentMapper.circlecommentinsert(circleid,openid,comment);
        if(set>0){
            return true;
        }else {
            return false;
        }
    }

    public List<Circlecomment> ciclecommentbycircleid(Integer circleid){

        return circlecommentMapper.circlecommentbycircleid(circleid);
    }

    public boolean circlecommentdeletebyid(Integer commentid){
        int set=circlecommentMapper.circlecommentdeletebyid(commentid);
        if(set>0){
            return true;
        }else {
            return false;
        }
    }

    public  List <Commentone> circlecommentthree(Integer circleid){
        List<Circlecomment> listcomment=circlecommentMapper.circlecommentthree(circleid);
        List<Commentone> list=new ArrayList<>();
        for (int i=0;i<listcomment.size();i++){
            Commentone commentone=new Commentone();
            commentone.setNickname(userMapper.userquerybyid(listcomment.get(i).getOpenid()).getNickName());
            commentone.setComment(listcomment.get(i).getComment());
            list.add(i,commentone);
        }
        return list;
    }
    public List<Commentmore> circommentmore(Integer circleid,Integer limit){
        List<Circlecomment> listcommentone=circlecommentMapper.circommentmore(circleid,limit);
        List<Commentmore> listmore=new ArrayList<>();
        for(int i=0;i<listcommentone.size();i++){
            Commentmore commentmore=new Commentmore();
            commentmore.setAvatarurl(userMapper.userquerybyid(listcommentone.get(i).getOpenid()).getAvatarUrl());
            commentmore.setCommentime(listcommentone.get(i).getCotime());
            commentmore.setMess(listcommentone.get(i).getComment());
            commentmore.setNickname(userMapper.userquerybyid(listcommentone.get(i).getOpenid()).getNickName());
            listmore.add(i,commentmore);
        }
        return listmore;
    }

}
