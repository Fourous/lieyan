package com.lieyan.Service;

import com.lieyan.Entity.Circle;
import com.lieyan.Entity.Circleone;
import com.lieyan.mapper.CircleMapper;
import com.lieyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CircleServicempl implements CircleService {
@Autowired
private CircleMapper circleMapper;
@Autowired
private UserMapper userMapper;
    public List<Circle> circleall(Integer limit){
        System.out.println("触发service层");
        return circleMapper.circleall(limit);
    }

    public Circleone circlebyid(Integer circleid){
        Circle circle=circleMapper.circlebyid(circleid);
        Circleone circleone=new Circleone();
        circleone.setAvatarurl(userMapper.userquerybyid(circle.getOpenid()).getAvatarUrl());
        circleone.setTime(circle.getTime());
        circleone.setMess(circle.getMess());
        circleone.setLike(circle.getLike());
        circleone.setImage1(circle.getImage1());
        circleone.setImage2(circle.getImage2());
        circleone.setImage3(circle.getImage3());
        circleone.setCircleid(circle.getCircleid());
        circleone.setNickname(userMapper.userquerybyid(circle.getOpenid()).getNickName());
        circleone.setUnlike(circle.getUnlike());
        return circleone;
    }

    public List<Circle> circlebyopenid(String openid){
        return circleMapper.circlebyopenid(openid);
    }

    public int circleinsert(String openid,String mess){
        Circle circle=new Circle();
        circle.setOpenid(openid);
        circle.setMess(mess);
        int set=circleMapper.circleinsert(circle);
        if(set>0){
            return circle.getCircleid();
        }else {
            return 0;
        }
    }

    public boolean circledeletebyid(Integer circleid){
        int set=circleMapper.circledeletebyid(circleid);
        if(set>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean circleimage(Integer circleid, String image1, String image2, String image3) {
        int set=circleMapper.circleimage(circleid,image1,image2,image3);
        if(set>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean circlelike(Integer circleid,Integer like){
        Circle circle=circleMapper.circlebyid(circleid);
       int set= circleMapper.circlelike(circleid,circle.getLike()+1);
        if(set>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean circleunlike(Integer circleid,Integer like){
        Circle circle=circleMapper.circlebyid(circleid);
        int set= circleMapper.circlelike(circleid,circle.getLike()-1);
        if(set>0){
            return true;
        }else {
            return false;
        }
    }

}
