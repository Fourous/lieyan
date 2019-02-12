package com.lieyan.mapper;

import com.lieyan.Entity.Packdetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PackdetailMapper {
    /**
     *
     * @param packid
     * @return
     */
    Packdetail packdetailbyid(Integer packid);
}
