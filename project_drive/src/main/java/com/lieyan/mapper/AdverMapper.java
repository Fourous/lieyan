package com.lieyan.mapper;

import com.lieyan.Entity.Adver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdverMapper {
    /**
     *
     * @param adverid
     * @return
     */
    Adver adverbyid(Integer adverid);

}
