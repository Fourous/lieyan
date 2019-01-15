package com.lieyan.Service;

import com.lieyan.Entity.Score;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ScoreService {
    /**
     * @return
     */
    public List<Score> getScoreList();//获取记录实体表

    /**
     *
     * @param id
     * @return
     */
    Score getscoreByid(Integer id);

    /**
     *
     * @param id
     * @return
     */

    boolean deletecoreByid(Integer id);

    /**
     *
     * @param score
     * @return
     */
    boolean insertscore(Score score);
}
