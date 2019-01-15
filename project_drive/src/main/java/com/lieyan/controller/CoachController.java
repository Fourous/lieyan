package com.lieyan.controller;

import com.lieyan.Entity.Coach;
import com.lieyan.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class CoachController {
    @Autowired
    private CoachService coachService;

    @PostMapping("coachall")
    public Map<String ,Object> coachall(){
         Map<String ,Object> map =new HashMap<>();
         List<Coach> list=coachService.coachall();
         map.put("coachall",list);
         return map;
     }

     //获取单个教练的信息，传入教练的id
     @PostMapping("coach_single")
    public Map<String,Object> coach_single(Integer tid,Integer openid){
        Map<String,Object> map=new HashMap<>();
        Coach coach=coachService.coachone(tid);
        map.put("coach",coach);
        return map;
     }
    @PostMapping("getcoachname")
    public String getcoachname(Integer tid){
        Coach coach=coachService.coachone(tid);
        return coach.getTname();
    }

     @PostMapping("coachlike")
     public boolean coachisli(Integer tid,Integer isli){
        //传进来的是0就是like，1就是unlike
         System.out.println(tid);
         System.out.println(isli);
        if(isli==0){
            boolean sub=coachService.coachlike(tid);
            if(sub){
                return true;
            }
            else return false;

        }
        else if(isli==1){
            boolean sub=coachService.coachunlike(tid);
            if(sub){
                return true;
            }
            else return false;
        }
        else {
            return false;
        }


     }
     //这里是取消的时候减去一个，同样的是0是like的减去，1是unlike的减去
     @PostMapping("coachlikere")
     public boolean coachislire(Integer tid,Integer isli){
         //传进来的是0就是like，1就是unlike
         System.out.println(tid);
         System.out.println(isli);
         if(isli==0){
             boolean sub=coachService.coachlikere(tid);
             if(sub){
                 return true;
             }
             else return false;

         }
         else if(isli==1){
             boolean sub=coachService.coachunlikere(tid);
             if(sub){
                 return true;
             }
             else return false;
         }
         else {
             return false;
         }


     }
     //这是读取like的默认值得，返回0是初始状态，1是点击状态
     @PostMapping("like_original")
    public Integer like_original(Integer tid,Integer openid){

        return 1;
     }

}
