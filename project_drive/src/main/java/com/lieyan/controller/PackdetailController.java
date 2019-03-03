package com.lieyan.controller;

import com.lieyan.Entity.Packdetail;
import com.lieyan.Service.PackdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class PackdetailController {
    @Autowired
    private PackdetailService packdetailService;

    @PostMapping("packageid")
    public Packdetail packdetailbyid(Integer packid){
        return packdetailService.packdetailbyid(packid);
    }
//    返回所有的列表
    @PostMapping("packdetailall")
    public List<Packdetail> packdetailall(){
        return packdetailService.packdetailall();
    }

}
