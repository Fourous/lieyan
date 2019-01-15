package com.lieyan.Service;
import com.lieyan.Entity.Student;
import com.lieyan.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicempl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getAreaByAreaId(Integer id){
        return studentMapper.queryAreaById(id);
    }
    public List<Student> getAreaList() {
        return studentMapper.queryArea();
    }

}
