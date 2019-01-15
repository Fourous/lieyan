package com.lieyan.mapper;

import com.lieyan.Entity.Coach;
import com.lieyan.Entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     *
     * @param tid
     * @return
     */
    List<Comment> commentbyid(Integer tid);


    int commentinsert(@Param("tid") Integer tid,@Param("openid") String openid,@Param("comment") String comment);

    //这里读取默认值
    Coach likeorigin(@Param("tid") Integer tid, @Param("openid") String openid);

    Coach unlikeorigin(@Param("tid") Integer tid,@Param("openid") String openid);
}
