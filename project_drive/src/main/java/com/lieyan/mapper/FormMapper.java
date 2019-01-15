package com.lieyan.mapper;

import com.lieyan.Entity.Form;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FormMapper {
    /**
     *
     * @return
     */
    List<Form> userform();

    /**
     *
     * @param form
     * @return
     */
    int userforminsert(Form form);
}
