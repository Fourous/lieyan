package com.lieyan.mapper;

import com.lieyan.Entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ScoreMapper {
    /**
     *
     * @return
     */

    List<Score> queryscore();

    /**
     *
     * @param id
     * @return
     */
    Score querybyid(@Param("id") Integer id);

    /**
     *
     * @param id
     * @return
     */
    int deleteScoreById (Integer id);

    /**
     *
     * @param score
     * @return
     */
    int insertScore(Score score);
}
