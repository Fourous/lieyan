package com.lieyan.mapper;

import com.lieyan.Entity.Teamform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeamformMapper {

//    这里是首次进行插入的时候的表单
    Integer teamforminsert(@Param("teamid") String teamid,@Param("teamname") String teamname,@Param("openid") String openid,@Param("formid") Integer formid);

    /**
     *
     * @param teamid
     * @return
     */
    List<Teamform> teamformquerybyteamid(String teamid);

    /**
     *
     * @param openid
     * @return
     */
    Teamform teamformquerybyopenid(String openid);

    /**
     *
     * @param teamid
     * @return
     */
    Integer teamformpush(String teamid);

}

