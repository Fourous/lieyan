package com.lieyan.Service;

import com.lieyan.Entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {
    /**
     *
     * @return
     */
    List<Feedback> feedbackall();

    /**
     *
     * @param openid
     * @param fbtxt
     * @return
     */
    boolean feedbackinsert(String openid,String fbtxt);
}
