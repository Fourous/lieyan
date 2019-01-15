package com.lieyan.mapper;

import com.lieyan.Entity.Circle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface CircleMapper {
    /**
     *
     * @param limit
     * @return
     */
    List<Circle> circleall(Integer limit);

    /**
     *
     * @param cicleid
     * @return
     */
    Circle circlebyid(Integer cicleid);

    /**
     *
     * @param openid
     * @return
     */
    List<Circle> circlebyopenid(String openid);

    /**
     *
     * @param circle
     * @return
     */
    int circleinsert(Circle circle);

    /**
     *
     * @param circleid
     * @return
     */
    int circledeletebyid(Integer circleid);

    int circleimage(@Param("circleid") Integer circleid,@Param("image1") String image1,@Param("image2") String image2,@Param("image3") String image3);

    int circlelike(@Param("circleid") Integer circleid,@Param("like") Integer like);

    int circleunlike(@Param("circleid") Integer circleid,@Param("like") Integer like);
}
