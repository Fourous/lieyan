package com.lieyan.Service;

import com.lieyan.Entity.Circlecol;
import com.lieyan.mapper.CirclecolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CirclecolServicempl implements CirclecolService {
    @Autowired
    private CirclecolMapper circlecolMapper;

    public Circlecol selectcirclecol(Integer circleid, String openid){
        return circlecolMapper.selectcirclecol(circleid,openid);
    }


    public boolean circleinsert(Integer circleid,String openid){
        int set=circlecolMapper.circleinsert(circleid,openid);
        if(set>0){
            return true;
        }else {
            return false;
        }
    }


   public boolean circleupdate(Integer circleid,String openid,Integer like){
       int set=circlecolMapper.circleupdate(circleid,openid,like);

       if(set>0){
           return true;
       }else {
           return false;
       }
    }
}
