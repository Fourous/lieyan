package com.lieyan.Service;

import com.lieyan.Entity.TeacherLogin;
import com.lieyan.mapper.TeacherLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherLoginServicempl implements TeacherLoginService {
    @Autowired
    private TeacherLoginMapper teacherLoginMapper;
    public TeacherLogin teacherloginybyid(String username){
        return teacherLoginMapper.teacherloginybyid(username);
    }
}
