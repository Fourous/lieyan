package com.lieyan.Service;
import com.lieyan.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService{

    /**
     * 根据区域的id 获取区域的信息
     *
     * @param areaId
     * @return
     */
    public Student getAreaByAreaId(Integer areaId);
    public List<Student>  getAreaList();
}