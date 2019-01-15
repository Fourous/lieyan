package com.lieyan.controller;

import com.lieyan.Entity.Feedback;
import com.lieyan.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
//    获取所有的评论反馈，链表形式返回
    @PostMapping("feedall")
    public Map<String,Object> feedall(){
    Map<String,Object> map=new HashMap<>();
        List<Feedback> list=feedbackService.feedbackall();
        map.put("feedback",list);
        return map;
        }
//        这里是插入的接口
   @PostMapping("feedinsert")
   public boolean feedinsert(String openid,String fbtxt){
        boolean set=feedbackService.feedbackinsert(openid,fbtxt);
        if(set){
            return true;
        }else {
            return false;
        }

   }
}
