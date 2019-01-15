package com.lieyan.mapper;

import com.lieyan.Entity.Circlecol;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

@Mapper
public interface CirclecolMapper {


    Circlecol selectcirclecol(@Param("circleid") Integer circleid,@Param("openid") String openid);

    int circleinsert(@Param("circleid") Integer circleid,@Param("openid") String openid);

    int circleupdate(@Param("circleid") Integer circleid,@Param("openid") String openid,@Param("like") Integer like);


}
