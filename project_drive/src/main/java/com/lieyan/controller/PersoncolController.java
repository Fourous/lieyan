package com.lieyan.controller;

import com.lieyan.Entity.Personcol;
import com.lieyan.Service.PersoncolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class PersoncolController {
    @Autowired
    private PersoncolService personcolService;
    //获取初始化的过程，如果返回空或者返回的是like 0 unlike 0 就是未操作的时候
    @PostMapping("likeorigin")
    public Map<String,Object> likeorigin(Integer tid,String openid){
        Map<String,Object> map=new HashMap<>();
        Personcol personcol=personcolService.perorigin(tid,openid);
        if(personcol==null){
            Personcol personcolor=new Personcol();
            personcolor.setOpenid(openid);
            personcolor.setTid(tid);
            personcolor.setLike(0);
            personcolor.setUnlike(0);
            boolean isint=personcolService.perinsert(personcolor);
            if(isint){
                //插入成功
                personcol=personcolService.perorigin(tid,openid);
            }
            else {
                personcol=null;
            }
        }
        map.put("personcol",personcol);
        return map;
    }

    @PostMapping("peracti")
    //这个地方需要用x-www-form访问
    public boolean peracti(Integer tid,String openid,Integer islike,Integer unlike){
        System.out.println(tid+openid+islike+unlike);
        boolean result=personcolService.perupdate(tid,openid,islike,unlike);
        return result;
    }
}
