package com.lieyan.mapper;

import com.lieyan.Entity.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface CoachMapper {
    /**
     *
     * @return
     */
    List<Coach> coachall();

    /**
     *
     * @param tid
     * @return
     */
    Coach coachquerybyid(Integer tid);

    int coachlike(@Param("tid") Integer tid,@Param("islike") Integer islike);

    int coachunlike(@Param("tid") Integer tid,@Param("unlike") Integer unlike);

    //这里是取消这个的时候减去一
    int coachlikere(@Param("tid") Integer tid,@Param("islike") Integer islike);

    int coachunlikere(@Param("tid") Integer tid,@Param("unlike") Integer unlike);



}
