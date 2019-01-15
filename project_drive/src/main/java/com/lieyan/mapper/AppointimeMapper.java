package com.lieyan.mapper;

import com.lieyan.App;
import com.lieyan.Entity.Appointime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppointimeMapper {

    
    List<Appointime> appointoneday(@Param("tid") Integer tid,@Param("week") Integer week);

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

    int appointweeksta(@Param("week") Integer week,@Param("state") Integer state);

    int appointweekstasta(@Param("week") Integer week,@Param("state") Integer state);

    int appointtimesta(@Param("week") Integer week,@Param("classnum") Integer classnum,@Param("state") Integer state);

    int appointtimestasta(@Param("week") Integer week,@Param("classnum") Integer classnum,@Param("state") Integer state);

    int appointchanum(@Param("appointid") Integer appointid,@Param("personum") Integer personum);

    int appointchasta(@Param("appointid") Integer appointid,@Param("state") Integer state);

    Appointime appofindappid(@Param("tid") Integer tid,@Param("classnum") Integer classnum,@Param("week") Integer week);
}
