package com.lieyan.mapper;

import com.lieyan.Entity.Packdetail;
import org.apache.ibatis.annotations.Mapper;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

@Mapper
public interface PackdetailMapper {
    /**
     *
     * @param packid
     * @return
     */
    Packdetail packdetailbyid(Integer packid);

    /**
     *
     * @return
     */
    List<Packdetail> packdetailall();
}
