package com.lieyan.Service;

import com.lieyan.App;
import com.lieyan.Entity.Appointime;
import com.lieyan.Entity.Weeksign;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointimeService {
    /**
     *
     * @param time
     * @return
     */
    int settableweek(long time);

    /**
     *
     * @param time
     * @return
     */
    int setabletime(long time);

    /**
     *
     * @param appointid
     * @return
     */
    Appointime appointbyid(Integer appointid);

    /**
     *
     * @param tid
     * @return
     */
    List<Appointime> appointbytid(Integer tid);

    List<Appointime> test(@Param("tid") Integer tid, @Param("week") Integer week);

    /**
     *
     * @param openid
     * @param tid
     * @param time
     * @return
     */
    List<Weeksign> Teatime(String openid,Integer tid,long time);

    /**
     *
     * @param openid
     * @param tid
     * @param appointid
     * @return
     */
    int isuserassign(String openid,Integer tid,Integer appointid);

    /**
     * 增加人数
      * @param appointid
     * @return
     */

    boolean appointadd(Integer appointid);

    /**
     * 减少人人数
     * @param appointid
     * @return
     */
    boolean appointdel(Integer appointid);

    /**
     * 改变预约的状态
     * @param appointid
     * @param state
     * @return
     */
    boolean appointstate(Integer appointid,Integer state);

    /**
     *
     * @param tid
     * @param week
     * @param classnum
     * @return
     */
    int findteacherappid(Integer tid,Integer week,Integer classnum);

}
