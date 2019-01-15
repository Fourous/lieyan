package com.lieyan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChangeteacherMapper {

int changeteacherinsert(@Param("openid") String openid,@Param("tid") Integer tid,@Param("reason") String reason);
}
