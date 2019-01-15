package com.lieyan.Service;

import com.lieyan.Entity.Score;
import com.lieyan.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ScoreServicempl implements ScoreService{
@Autowired
private ScoreMapper scoreMapper;

    /**
     *
     * @return
     */
    public List<Score> getScoreList(){
        return scoreMapper.queryscore();
    }

    /**
     *
     * @param id
     * @return
     */
    public Score getscoreByid(Integer id){
        return scoreMapper.querybyid(id);
    }

    /**
     *
     * @param id
     * @return
     */

    public boolean deletecoreByid(Integer id){
       if(id>0){
           try{
                int effectnum=scoreMapper.deleteScoreById(id);
                if (effectnum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除失败！");
                }
           }catch (Exception e){
               throw new RuntimeException("删除信息失败"+e.getMessage());
           }
       }else{
           throw new RuntimeException("删除信息失败j");
       }
    }

    //@Transactional(rollbackFor = Exception.class)
    //回滚机制

    /**
     *
     * @param score
     * @return
     */
    @Override
    public boolean insertscore(Score score) {
        if(true){
            try {
                // 插入区域信息
                int effectedNum = scoreMapper.insertScore(score);

                if(effectedNum > 0){
                    return true;
                }else {
                    // @Transactional 默认只会回滚 RuntimeException 类型的异常
                    throw new RuntimeException("插入人物信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入人物信息失败！" + e.getMessage());
            }
        }else {
        throw new RuntimeException("插入人物信息失败");
    }
    }
}
