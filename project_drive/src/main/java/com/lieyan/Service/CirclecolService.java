package com.lieyan.Service;

import com.lieyan.Entity.Circlecol;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface CirclecolService {
    /**
     *
     * @param circleid
     * @param openid
     * @return
     */
    Circlecol selectcirclecol(Integer circleid,String openid);

    /**
     *
     * @param circleid
     * @param openid
     * @return
     */
    boolean circleinsert(Integer circleid,String openid);

    /**
     *
     * @param circleid
     * @param openid
     * @param like
     * @return
     */
    boolean circleupdate(Integer circleid,String openid,Integer like);

}
