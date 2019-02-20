package com.lieyan.Service;

import com.lieyan.Entity.Teamform;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamformService {
    /**
     *
     * @param teamid
     * @param teamname
     * @param openid
     * @param formid
     * @return
     */
    Integer teamforminsert(String teamid, String teamname, String openid,  Integer formid);

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
    boolean teamformpush(String teamid);

}
