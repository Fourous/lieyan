package com.lieyan.controller;

import com.lieyan.Entity.TeacherLogin;
import com.lieyan.Service.TeacherLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TeacherLoginController {
    @Autowired
    private TeacherLoginService teacherLoginService;
    @PostMapping("islogin")
    public int TeacherLogin(String username,String passwd){
        //这里判断用户不存在和用户密码账号不对应的情况
        TeacherLogin teacherLogin=teacherLoginService.teacherloginybyid(username);
        if(teacherLogin==null){
            return -1;
            //这里代表不存在这个用户
        }
        //这里不能用==，==是引用内存中的的地址，quals才是比较字符串的内容
        else if(teacherLogin.getUsername().equals(username) && teacherLogin.getPasswd().equals(passwd)){

            return teacherLogin.getTid();//成功匹配
        }
        else{
            return 0;//这里是不匹配
        }
    }
}
