package com.lieyan.mapper;

import com.lieyan.Entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    /**
     *
     * @return
     */
    List <Feedback> feedback();

    int feedbackinsert(@Param("openid") String openid,@Param("fbtxt") String fbtxt);
}
