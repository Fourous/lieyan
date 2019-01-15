package com.lieyan.controller;

import com.lieyan.Entity.Adver;
import com.lieyan.Service.AdverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class AdverController {
@Autowired
    private AdverService adverService;
//获取广告的接口
@PostMapping("adverget")
    public Map<String,Object> adverget(Integer adverid){
    Map<String,Object> mao=new HashMap<>();
    Adver adver=adverService.adverget(adverid);
    mao.put("adver",adver);
    return mao;
}

}
