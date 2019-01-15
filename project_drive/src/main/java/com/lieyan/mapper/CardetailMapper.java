package com.lieyan.mapper;

import com.lieyan.Entity.Cardetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardetailMapper {
    /**
     *
     * @return
     */
    List<Cardetail> cardetilall();

    /**
     *
     * @param id
     * @return
     */
    Cardetail cardetailbyid(Integer id);
}
