package com.lieyan.controller;

import com.lieyan.Entity.*;
import com.lieyan.Service.CircleService;
import com.lieyan.Service.CirclecolService;
import com.lieyan.Service.CirclecommentService;
import com.lieyan.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class CircleController {
    @Autowired
    private CirclecommentService circlecommentService;
    @Autowired
    private CircleService circleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CirclecolService circlecolService;

//    返回所有的说说
//    @PostMapping("circleall")
//    public Map<String,Object> circleall(){
//        System.out.println("触发controller层");
//        Map<String,Object> map=new HashMap<>();
//        List<Circle> list=circleService.circleall();
//        map.put("circleall",list);
//        return map;
//    }
//    返回所有的个人说说，也就是发表过的
    @PostMapping("ciropenid")
    public Map<String,Object> ciropenid(String openid){
        Map<String,Object> map=new HashMap<>();
        List<Circle> list=circleService.circlebyopenid(openid);
        map.put("ciropenid",list);
        return map;
    }
//    发表说说
    @PostMapping("cirinsert")
    public int cirinsert(String openid,String mess){
        return circleService.circleinsert(openid,mess);
    }

//     通过id删除说说
    @PostMapping("cirdelete")
    public boolean cirdelete(Integer circleid){
        return circleService.circledeletebyid(circleid);
    }
//    插入图片
    @PostMapping("cirimage")
    public boolean cirimage(Integer circleid,String image1,String image2,String image3){
        return circleService.circleimage(circleid,image1,image2,image3);
    }
//    //    返回所有评论
    @PostMapping("circomall")
    public List<Commentone> circomall(Integer circleid){
        Map<String,Object> map=new HashMap<>();
        List<Commentone> commentoneList=new ArrayList<>();
        List<List> listone=new ArrayList<>();
        List<Circlecomment> list=circlecommentService.ciclecommentbycircleid(circleid);
        for(int i=0;i<list.size();i++){
            Commentone commentone=new Commentone();
            Circlecomment circlecommenttmp=list.get(i);
            commentone.setNickname(userService.useropenid(circlecommenttmp.getOpenid()).getNickName());
            commentone.setComment(circlecommenttmp.getComment());
            commentoneList.add(i,commentone);
        }
        return commentoneList;
    }
    //获取三条评论
//    @PostMapping("circlethree")
//    public Map<String,Object> circlethree(Integer circleid){
//        Map<String,Object> map=new HashMap<>();
//        List<Circlecomment> list=circlecommentService.circlecommentthree(circleid);
//        map.put("cirthree",list);
//        return map;
//    }
//    插入评论
    @PostMapping("circominsert")
    public boolean circominsert(Integer circleid,String openid,String comment){
        return circlecommentService.circlecommentinsert(circleid,openid,comment);
    }
//    删除评论
    @PostMapping("circomdelete")
    public boolean circomdelete (Integer commentid){
        return circlecommentService.circlecommentdeletebyid(commentid);
    }
//    这里给出单个说说的封装

    @PostMapping("circleone")
    public List<Circleone> circleone(Integer limit){
        List<Circleone> listcircleone=new ArrayList<>();
        List<Circle> circles=circleService.circleall(limit);
        for(int i=0;i<circles.size();i++){
            Circleone circleone=new Circleone();
            circleone.setNickname(userService.useropenid( circles.get(i).getOpenid()).getNickName());
            circleone.setAvatarurl(userService.useropenid( circles.get(i).getOpenid()).getAvatarUrl());
            circleone.setCircleid(circles.get(i).getCircleid());
            circleone.setImage1(circles.get(i).getImage1());
            circleone.setImage2(circles.get(i).getImage2());
            circleone.setImage3(circles.get(i).getImage3());
            circleone.setLike(circles.get(i).getLike());
            circleone.setMess(circles.get(i).getMess());
            circleone.setTime(circles.get(i).getTime());
            circleone.setComment(circlecommentService.circlecommentthree(circles.get(i).getCircleid()));
            listcircleone.add(i,circleone);
        }
        return listcircleone;
    }
    @PostMapping ("commentmore")
    public List<Commentmore> commentmore(Integer circleid,Integer limit){
        return  circlecommentService.circommentmore(circleid,limit);
    }
    @PostMapping("getcircleid")
    public Circleone getcircleid(Integer circleid){
        return circleService.circlebyid(circleid);
    }
    //朋友圈点赞记录，0代表没点赞，1代表点赞成功
    @PostMapping("circleselectlike")
    public Integer circleselectlike(Integer circleid,String openid){
        Circlecol circlecol=circlecolService.selectcirclecol(circleid,openid);
        if(circlecol==null){
            circlecolService.circleinsert(circleid,openid);
            return circlecolService.selectcirclecol(circleid,openid).getLike();
        }else {
            return circlecol.getLike();
        }
    }
    @PostMapping("circlelike")
    public boolean circlelike(Integer circleid,String openid,Integer like){
        return circlecolService.circleupdate(circleid,openid,like);
    }
}
