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

    /**
     *
     * @param fid
     * @param fteacher
     * @return
     */
    int userformupdate(@Param("fid") Integer fid,@Param("fteacher") String fteacher);

    /**
     *
     * @param fid
     * @return
     */
    int userformdelete(Integer fid);

    /**
     *
     * @param fid
     */
    Form userformquerybyid(Integer fid);

    List<Form> userformquerybyopenid(String openid);


}
