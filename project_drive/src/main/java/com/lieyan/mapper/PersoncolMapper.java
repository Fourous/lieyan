package com.lieyan.mapper;

import com.lieyan.Entity.Personcol;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

@Mapper
public interface PersoncolMapper {
    /**
     *
     * @param tid
     * @param openid
     * @return
     */
    Personcol perorigin(@Param("tid") Integer tid, @Param("openid") String openid);

    /**
     *
     * @param personcol
     * @return
     */
    int perinsert(Personcol personcol);
    int perupdate(@Param("tid") Integer tid, @Param("openid") String openid, @Param("islike") Integer islike, @Param("unlike") Integer unlike);
}
