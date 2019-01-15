package com.lieyan.Service;

import com.lieyan.Entity.Userappoint;
import com.lieyan.mapper.UserappointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserappointServicempl implements UserappointService{
@Autowired
    private UserappointMapper userappointMapper;
@Autowired
    private AppointimeService appointimeService;
    public boolean userappoint(String openid,Integer appointid){
        int set= userappointMapper.userappointinsert(openid,appointid);
    if(set>0){
        boolean is=appointimeService.appointadd(appointid);
        if(is==true) return true;
        else return false;
    }else{
        return false;
        }
    }


    public boolean userappointdele(String openid,Integer appointid){
        int set=userappointMapper.userappointdelete(openid,appointid);
        if(set>0){
            appointimeService.appointdel(appointid);
            return true;
        }else{
            return false;
        }
    }


    public List<Userappoint> userappointall(String openid){
        return userappointMapper.userappointquery(openid);
    }

    public List<Userappoint> userappoinbyid(Integer appointid){
        return userappointMapper.userappoinbyid(appointid);
    }


}

