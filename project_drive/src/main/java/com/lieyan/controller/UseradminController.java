package com.lieyan.controller;

import com.lieyan.Entity.Useradmin;
import com.lieyan.Service.UseradminService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class UseradminController {
    @Autowired
    private UseradminService useradminService;

    @PostMapping("useradminquery")
    public List<Useradmin> useradminquery(){
        return useradminService.useradminquery();
    }

    @PostMapping("useradminbyid")
    public Useradmin useradminbyid(Integer userid){
        return useradminService.useradminbyid(userid);
    }

    @PostMapping("useradminbyname")
    public Useradmin useradminbyname(String username){
        return useradminService.useradminbyname(username);
    }

    @PostMapping("useradmininsert")
    public boolean useradmininsert(String username,String userpasswd){
        return useradminService.useradmininsert(username,userpasswd);
    }

    @PostMapping("useradmindelete")
    public boolean useradmindelete(Integer userid){
        return useradminService.useradmindelete(userid);
    }


}
