package com.lieyan.Service;

import com.lieyan.Entity.Comment;
import com.lieyan.Entity.User;
import com.lieyan.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicempl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    public List<Comment> commentbyid(Integer tid){
        return commentMapper.commentbyid(tid);
    }
    public boolean commentinsert(Integer tid,String openid,String comment){
        int setnum=commentMapper.commentinsert(tid,openid,comment);
        if(setnum>0){
            return true;
        }
        else {
            return false;
        }
    }


}
