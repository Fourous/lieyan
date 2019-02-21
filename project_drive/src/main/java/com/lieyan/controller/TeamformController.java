package com.lieyan.controller;

import com.lieyan.Entity.Form;
import com.lieyan.Entity.Teamform;
import com.lieyan.Entity.Teamreunite;
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
    @Autowired
    private FormService formService;
    @Autowired
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
        System.out.println(form.getFid());
       return teamformService.teamforminsert(openid,teamname,openid,form.getFid());
    }
    @PostMapping("testin")
    public int testin(String teamid,String openid){
        if(teamformService.teamformquerybyopenid(openid)!=null){
            return 1;//这里加入了其他战队
        }
        else if(teamformService.teamformquerybyteamid(teamid).size()>=4){
            System.out.println("ddd");
            return 2;//这里是参与人数超了
        }
        else if(teamid==""||teamid==null||teamformService.teamformquerybyteamid(teamid)==null){
            return 3;
        }
        else return 4;
    }
//    参与战队
    @PostMapping("teamgetin")
    public int teamgetin(String fname,String ftel,String address,String fpack,String teamid,String openid){
        Form form=new Form();
        form.setFname(fname);
        form.setFtel(ftel);
        form.setFaddress(address);
        form.setFpack(fpack);
        System.out.println("1");
        formService.userforminsert(form);
        System.out.println("1");
        System.out.println(form.getFid());
        if(teamid==""||teamid==null||teamformService.teamformquerybyteamid(teamid)==null){
            return 0;//这里是没有发现战队
        }
//        String teamid, String teamname, String openid,  Integer formid
        else return teamformService.teamforminsert(teamid,teamformService.teamformquerybyteamid(teamid).get(0).getTeamname(),openid,form.getFid());
    }


//    判断是否能进行练车
    @PostMapping("canpush")
    public boolean canpush(String openid){
        List<Teamform> teamforms=new ArrayList<>();
        teamforms = teamformService.teamformquerybyteamid(teamformService.teamformquerybyopenid(openid).getTeamid());
        System.out.println("这里是那个Team的个数"+teamforms);
        if(teamforms.size()>=4){
        return true;
        }
        else return false;
    }
//    战队列表
    @PostMapping("listteam")
//    private Integer tid;
//    private String teamid;
//    private String teamname;
//    private String openid;
//    private String name;
//    private Integer push;
    public List<Teamreunite> listteam(String openid){
        List<Teamreunite> list=new ArrayList<>();//这里是名字的集合
        List<Teamform> teamforms=new ArrayList<>();
        if(teamformService.teamformquerybyopenid(openid)==null){
//            list.add(null);
            return null;
        }else {
            teamforms = teamformService.teamformquerybyteamid(teamformService.teamformquerybyopenid(openid).getTeamid());
            System.out.println("这里打印战队列表");
            System.out.println(teamforms);
            for (int i=0;i<teamforms.size();i++){
                Teamreunite teamreunite=new Teamreunite();
                System.out.println(teamforms.get(i).getFormid());
                System.out.println(formService.userformquerybyid(teamforms.get(i).getFormid()).getFname());
                if(teamforms.get(i)!=null){
                    teamreunite.setName(formService.userformquerybyid(teamforms.get(i).getFormid()).getFname());
                    teamreunite.setTid(teamforms.get(i).getTid());
                    teamreunite.setTeamid(teamforms.get(i).getTeamid());
                    teamreunite.setTeamname(teamforms.get(i).getTeamname());
                    teamreunite.setOpenid(teamforms.get(i).getOpenid());
                    teamreunite.setPush(teamforms.get(i).getPush());
                    list.add(i,teamreunite);
                }

            }
            return list;
        }


    }
//    进行练车
    @PostMapping("pushlist")
    public boolean pushlist(String openid){
        return teamformService.teamformpush(teamformService.teamformquerybyopenid(openid).getTeamid());
    }


}
