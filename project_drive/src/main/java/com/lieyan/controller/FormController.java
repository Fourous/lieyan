package com.lieyan.controller;

import com.lieyan.Entity.Form;
import com.lieyan.Service.FormService;
import com.lieyan.Service.UserService;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class FormController {
    @Autowired
    private FormService formService;
    @Autowired
    private UserService userService;
    //获取所有报名表的信息
    @PostMapping("formget")
    public Map<String,Object> formget(){
        Map<String ,Object> mapform=new HashMap<>();
        List<Form> list=formService.userformget();
        mapform.put("list",list);
        return mapform;
    }


    //提交报名表插入报名信息
    @PostMapping("forminsert")
    public boolean forminsert(@RequestBody Form form){
        Map<String,Object> formdetail =new HashMap<>();
        userService.userissign(form.getOpenid());
        return formService.userforminsert(form);
    }

//    获取主键id
    @PostMapping("formgetid")
    public Integer formgetid(@RequestBody Form form){
        formService.userforminsert(form);
        return form.getFid();
    }

        //这里是绑定教练操作
    @PostMapping("userformupdate")
    public boolean userformupdate(Integer fid,String fteacher){
        return formService.userformupdate(fid,fteacher);
    }

    @PostMapping("formgetform")
    public Form formgetform (Integer fid){
        return formService.userformquerybyid(fid);
    }
    @PostMapping("testform")
    public boolean testform(String openid){
        if(formService.userformquerybyopenid(openid).size()<=0){
            return true;
        }else return false;
    }

}
