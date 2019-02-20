package com.lieyan.controller;

import com.lieyan.Entity.Formcorp;
import com.lieyan.Service.FormService;
import com.lieyan.Service.FormcorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class FormcorpController {
    @Autowired
    private FormcorpService formcorpService;

    @PostMapping("formcorpinsert")
    public boolean formcorpinsert(@RequestBody Formcorp formcorp){
        return formcorpService.formcorpinsert(formcorp);
    }
//    返回所有的数据
    @PostMapping("formcorpquery")
    public List<Formcorp> formcorpquery(){
        return formcorpService.formcorpquery();
    }
}
