package com.lieyan.Service;

import com.lieyan.Entity.TeacherLogin;
import org.springframework.stereotype.Service;

@Service
public interface TeacherLoginService {
    /**
     *
     * @param username
     * @return
     */
    TeacherLogin teacherloginybyid(String username);
}
