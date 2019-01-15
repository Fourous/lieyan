package com.lieyan.Service;

import com.lieyan.Entity.Comment;
import com.lieyan.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    /**
     *
     * @param tid
     * @return
     */
    List<Comment> commentbyid(Integer tid);

    /**
     *
     * @param tid
     * @param openid
     * @param comment
     * @return
     */
    boolean commentinsert(Integer tid,String openid,String comment);

}
