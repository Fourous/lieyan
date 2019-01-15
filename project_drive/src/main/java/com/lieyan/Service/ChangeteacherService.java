package com.lieyan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ChangeteacherService {
    /**
     *
     * @param openid
     * @param tid
     * @param reason
     * @return
     */
    boolean changeteacherinsert(String openid,Integer tid,String reason);

}
