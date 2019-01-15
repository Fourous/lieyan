package com.lieyan.Service;

import com.lieyan.Entity.Circle;
import com.lieyan.Entity.Circleone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CircleService {
    /**
     *
     * @return
     */
    List<Circle> circleall(Integer limit);

    /**
     *
     * @param circleid
     * @return
     */
    Circleone circlebyid(Integer circleid);

    /**
     *
     * @param openid
     * @return
     */
    List<Circle> circlebyopenid(String openid);

    /**
     *
     * @param openid
     * @param mess
     * @return
     */
    int circleinsert(String openid,String mess);

    /**
     *
     * @param circleid
     * @return
     */
    boolean circledeletebyid(Integer circleid);

    /**
     *
     * @param circleid
     * @param image1
     * @param image2
     * @param image3
     * @return
     */
    boolean circleimage(Integer circleid,String image1,String image2,String image3);

    /**
     *
     * @param circleid
     * @param like
     * @return
     */
    boolean circlelike(Integer circleid,Integer like);

    /**
     *
     * @param circleid
     * @param like
     * @return
     */
    boolean circleunlike(Integer circleid,Integer like);
}
