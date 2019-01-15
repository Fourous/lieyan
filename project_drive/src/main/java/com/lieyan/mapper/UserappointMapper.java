package com.lieyan.mapper;

import com.lieyan.Entity.Userappoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserappointMapper {
    /**
     *
     * @param openid
     * @return
     */
    List<Userappoint> userappointquery(String openid);

    /**
     *
     * @param appointid
     * @return
     */
    List<Userappoint> userappoinbyid(Integer appointid);

    int userappointinsert(@Param("openid") String openid,@Param("appointid") Integer appointid );

    int userappointdelete(@Param("openid") String openid,@Param("appointid") Integer appointid);
}
