package com.lieyan.mapper;

import com.lieyan.Entity.TeacherLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherLoginMapper {
    /**
     *
     * @param username
     * @return
     */
    TeacherLogin teacherloginybyid(String username);
}
