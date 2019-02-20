package com.lieyan.mapper;

import com.lieyan.Entity.Formcorp;
import org.apache.ibatis.annotations.Mapper;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

@Mapper
public interface FormcorpMapper {
    /**
     *
     * @return
     */
    List<Formcorp> formcorpquery();

    /**
     *
     * @param fid
     * @return
     */
    Formcorp formcorpquerybyid(Integer fid);

    /**
     *
     * @param formcorp
     * @return
     */
    Integer formcorpinsert(Formcorp formcorp);

}
