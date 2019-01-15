package com.lieyan.Service;

import com.lieyan.mapper.ChangeteacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeteacherServicempl implements ChangeteacherService {
    @Autowired
    private ChangeteacherMapper changeteacherMapper;

    @Override
    public boolean changeteacherinsert(String openid, Integer tid, String reason) {
        if(changeteacherMapper.changeteacherinsert(openid,tid,reason)>0){
            return true;
        }
        else return false;
    }
}
