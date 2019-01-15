package com.lieyan.controller;

import com.lieyan.Entity.CoachComone;
import com.lieyan.Entity.Comment;
import com.lieyan.Entity.User;
import com.lieyan.Service.CommentService;
import com.lieyan.mapper.CommentMapper;
import com.lieyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentService commentService;
    //获取评论所有数据
    @PostMapping("coach_comment")
    public Map<String,Object> coach_comment(Integer tid){
        Map<String,Object> map=new HashMap<>();
        List<Comment> list =commentMapper.commentbyid(tid);
        List<CoachComone> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            CoachComone coachComone=new CoachComone();
            coachComone.setComment(list.get(i).getComment());
            coachComone.setCommentid(list.get(i).getCommentid());
            coachComone.setCotime(list.get(i).getCotime());
            coachComone.setTid(list.get(i).getTid());
            coachComone.setAvatar(userMapper.userquerybyid(list.get(i).getOpenid()).getAvatarUrl());
            coachComone.setNickname(userMapper.userquerybyid(list.get(i).getOpenid()).getNickName());
            list1.add(i,coachComone);
        }
        map.put("comment_user",list1);
        return map;
    }

    @PostMapping("comment_insert")
    public boolean comment_insert(Integer tid,String openid,String comment){
        return commentService.commentinsert(tid,openid,comment);
    }






}
