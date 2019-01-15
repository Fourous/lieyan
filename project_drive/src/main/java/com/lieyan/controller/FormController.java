package com.lieyan.controller;

import com.lieyan.Entity.Form;
import com.lieyan.Service.FormService;
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
    public Map<String,Object> forminsert(@RequestBody Form form){
        Map<String,Object> formdetail =new HashMap<>();
        formdetail.put("formdetail",formService.userforminsert(form));
        return formdetail;
    }



}
