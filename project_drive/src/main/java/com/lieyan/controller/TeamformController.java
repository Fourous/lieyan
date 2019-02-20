package com.lieyan.controller;

import com.lieyan.Entity.Form;
import com.lieyan.Entity.Teamform;
import com.lieyan.Service.FormService;
import com.lieyan.Service.TeamformService;
import com.lieyan.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class TeamformController {
    @Autowired
    private TeamformService teamformService;
    private FormService formService;
    private UserService userService;
//检测是否已经报名参加
    @PostMapping("teamisoff")
    public boolean teamisoff (String openid){
       if(teamformService.teamformquerybyopenid(openid)!=null){
           return false;
       } else return true;
    }

    //创建战队??
    @PostMapping("teamcreate")
    public int teamcreate(String fname,String ftel,String address,String fpack,String teamname,String openid){
       Form form=new Form();
       form.setFname(fname);
       form.setFtel(ftel);
       form.setFaddress(address);
       form.setFpack(fpack);
       System.out.println("1");

       formService.userforminsert(form);
        System.out.println("1");
       return teamformService.teamforminsert(openid,teamname,openid,form.getFid());
    }
//    参与战队
    @PostMapping("teamgetin")
    public int teamgetin(String fname,String ftel,String address,String fpack,String teamid,String openid){
        if(teamid==""||teamid==null||teamformService.teamformquerybyteamid(teamid)==null){
            return 1;//这里是没有发现战队
        }
        else if(teamformService.teamformquerybyteamid(teamid).size()>=4){
            System.out.println(teamformService.teamformquerybyteamid(teamid));
            return 2;//战队已满
        }
        else return 3;
    }
//    判断是否能进行练车
    @PostMapping("canpush")
    public boolean canpush(String openid){
        System.out.println(teamformService.teamformquerybyopenid(openid).getTeamid());
        System.out.println(teamformService.teamformquerybyteamid(teamformService.teamformquerybyopenid(openid).getTeamid()));
        System.out.println(teamformService.teamformquerybyteamid(teamformService.teamformquerybyopenid(openid).getTeamid()).size());
        System.out.println(teamformService.teamformquerybyteamid(teamformService.teamformquerybyopenid(openid).getTeamid()).size()<=4);
        if(teamformService.teamformquerybyteamid(teamformService.teamformquerybyopenid(openid).getTeamid()).size()<=4){
        return true;
        }
        else return false;
    }
//    战队列表
    @PostMapping("listteam")
public List<String> listteam(String openid){
        List<String> list=new ArrayList<>();
        if(teamformService.teamformquerybyopenid(openid)==null){
            return null;
        }
        List<Teamform> teamforms = teamformService.teamformquerybyteamid(teamformService.teamformquerybyopenid(openid).getTeamid());
        for (int i=0;i<teamforms.size();i++){
            list.add(i,formService.userformquerybyid(teamforms.get(i).getFormid()).getFname());
        }
        return list;
    }
//    进行练车
    @PostMapping("pushlist")
    public boolean pushlist(String openid){
        return teamformService.teamformpush(teamformService.teamformquerybyopenid(openid).getTeamid());
    }


}
