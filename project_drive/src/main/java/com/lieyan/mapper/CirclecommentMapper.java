package com.lieyan.mapper;

import com.lieyan.Entity.Circlecomment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CirclecommentMapper {
    /**
     *
     * @param circleid
     * @return
     */
    List<Circlecomment> circlecommentbycircleid(Integer circleid);

    /**
     *
     * @param circleid
     * @return
     */
    List<Circlecomment> circlecommentthree(Integer circleid);

    int circlecommentinsert(@Param("circleid") Integer circleid, @Param("openid") String openid, @Param("comment") String comment );

    /**
     *
     * @param commentid
     * @return
     */
    int circlecommentdeletebyid(Integer commentid);

    List<Circlecomment> circommentmore(@Param("circleid") Integer circleid,@Param("limit") Integer limit);
}
