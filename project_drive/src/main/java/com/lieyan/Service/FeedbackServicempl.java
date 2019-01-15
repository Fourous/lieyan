package com.lieyan.Service;

import com.lieyan.Entity.Feedback;
import com.lieyan.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackServicempl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    //这里返回所有的反馈建议，以列表的方式返回

    public List<Feedback> feedbackall(){
        return feedbackMapper.feedback();
    }

     public boolean feedbackinsert(String openid,String fbtxt){
        int setnum=feedbackMapper.feedbackinsert(openid,fbtxt);
        if(setnum>0){
            return true;
        }else {
            return false;
        }
     }


}
