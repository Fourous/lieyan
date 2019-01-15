package com.lieyan.Service;

import com.lieyan.Entity.User;
import com.lieyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicempl implements UserService{
    @Autowired
    private UserMapper userMapper;
    private AppointimeService appointimeService;
//这里是上传的接口，微信登录的时候
    public boolean  userwechatlogin(User user){
            int setnum=userMapper.userinsert(user);
            if(setnum>0){
                return true;
            }
        else{
                return false;
                //throw new RuntimeException("插入失败");

        }


 }

    public List<User> userquery(){
        return userMapper.userquery();
    }
    public User useropenid(String openid){
        return userMapper.userquerybyid(openid);
    }

    public boolean userdelete(String openid){
        int setnum=userMapper.userdelete(openid);
        if(setnum>0){
            return true;
        }else return false;
    }


    public boolean usersign(String openid,Integer signitem){
        int setnum=userMapper.usersign(openid,signitem);
        if(setnum>0){
            return true;
        }else {
            return false;
        }
    }
//    这里执行两步才能返回数据
//    public boolean bindteacher(String openid,Integer tid){
//        int set=userMapper.bindteacher(openid,tid);
//        if(set>0){
//            if(appointimeService.appointinsert(openid,tid)){
//                return true;
//            }else {
//                return false;
//            }
//
//        }else {
//            return false;
//        }
//    }

public boolean userchangename(String openid,String nickName){
        int set=userMapper.userchangename(openid,nickName);
        if(set>0){return true;
        }
        else {
            return false;
        }
}
}
