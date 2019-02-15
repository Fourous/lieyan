package com.lieyan.mapper;

import com.lieyan.Entity.Form;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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


    int userformupdate(@Param("fid") Integer fid,@Param("fteacher") String fteacher);
}
