package com.lieyan.Service;

import com.lieyan.Entity.Useradmin;
import com.lieyan.mapper.UseradminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseradminServicempl implements UseradminService {

    @Autowired
    private UseradminMapper useradminMapper;

    public List<Useradmin> useradminquery(){
        return useradminMapper.useradminquery();
    }


    public Useradmin useradminbyid(Integer userid){
        return useradminMapper.useradminbyid(userid);
    }


    public Useradmin useradminbyname(String username){
        return useradminMapper.useradminbyname(username);
    }


    public boolean useradmininsert(String username,String userpasswd){
        if(useradminMapper.useradmininsert(username,userpasswd)>0){
            return true;
        }
        else return false;
    }


    public boolean useradmindelete(Integer userid){
       if(useradminMapper.useradmindelete(userid)>0){
           return true;
       }else return false;
    }

}
