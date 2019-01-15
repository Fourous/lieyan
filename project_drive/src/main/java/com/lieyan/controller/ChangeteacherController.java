package com.lieyan.controller;

import com.lieyan.Service.ChangeteacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ChangeteacherController {
@Autowired
    private ChangeteacherService changeteacherService;
    @PostMapping("changeteacherinsert")
    public boolean changeteacherinsert(String openid,Integer tid,String reason){
        return changeteacherService.changeteacherinsert(openid,tid,reason);
    }
}
