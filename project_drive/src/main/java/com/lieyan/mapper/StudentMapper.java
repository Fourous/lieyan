package com.lieyan.mapper;
import com.lieyan.Entity.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 列出区域信息
     *
     * @return
     */
    List<Student> queryArea();
    /**
     * 根据查询某一个区域信息
     *
     * @param id
     * @return
     */
    Student queryAreaById(Integer id);
    /**
     * 插入一个区域信息
     *
     * @param area 区域
     * @return
     */
    //int insertArea(Student area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    //int updateArea(Student area);

    /**
     * 删除某一个区域信息
     *
     * @param id
     * @return
     */
    //int deleteAreaById(Integer id);
}
