package com.lieyan.controller;
import com.lieyan.Entity.Appointime;
import com.lieyan.Entity.Classsign;
import com.lieyan.Entity.Userappoint;
import com.lieyan.Entity.Weeksign;
import com.lieyan.Service.AppointimeService;
import com.lieyan.Service.UserService;
import com.lieyan.Service.UserappointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;

@RestController
@SpringBootApplication
public class AppointmentController {
    //这里获取到的是小程序的当前时间
    @Autowired
    private AppointimeService appointimeService;
    @Autowired
    private UserappointService userappointService;
    @Autowired
    private UserService userService;
    //这里初始化之后，开始封装数据
    @PostMapping("Getime")
    public List<Weeksign> Getime(String openid,Integer tid){
        System.out.println("教练的tid"+tid);
        long nowTimestamp=System.currentTimeMillis();
        System.out.println(nowTimestamp);
        appointimeService.settableweek(nowTimestamp);
        appointimeService.setabletime(nowTimestamp);
        return appointimeService.Teatime(openid,tid,nowTimestamp);
        }


        @PostMapping ("test")
        public List<Appointime> test(Integer tid, Integer week){
//        long time=System.currentTimeMillis();
//            List<String> list=new ArrayList<>();
//            List<String> listlast=new ArrayList<>();
//        int now=0;
//        String last="";
//        String temp="";
//        System.out.println("当前时间为"+time);
//        String timeformat=appointimeService.test(time);
//            System.out.println(timeformat);
//
//        StringTokenizer st = new StringTokenizer(timeformat);
//            while(st.hasMoreElements()){
//                System.out.println("Token:" + st.nextToken());
//                list.add(st.nextToken());
//            }
//            for(int i=0;i<list.size();i++){
//                temp+=list.get(i);
//            }
//            System.out.println(temp);
//           String[] strings=temp.split("\\:");
//           for (int j=0;j<2;j++){
//               last+=strings[j];
//           }
//           System.out.println(last);
//           int timenum=Integer.parseInt(last);
//
//            return strings;
            return appointimeService.test(tid,week);
        }
        //这里是用户开始预约
        @PostMapping("userappoint")
    public boolean userappoint(String openid,Integer tid,Integer week,Integer classid){
        int appointid=appointimeService.findteacherappid(tid,week,classid);
        System.out.println(openid+tid+week+classid);
        return userappointService.userappoint(openid,appointid);

        }
        @PostMapping("userdeleappoint")
    public boolean userdeleappoint(String openid,Integer tid,Integer week,Integer classid){
            int appointid=appointimeService.findteacherappid(tid,week,classid);
            System.out.println(openid+tid+week+classid);
        return userappointService.userappointdele(openid,appointid);
        }
        @PostMapping("findappidtest")
        public int findappidtest(Integer tid,Integer week,Integer classid){
        return appointimeService.findteacherappid(tid,week,classid);
        }
        @PostMapping("userappointall")
    public List<Userappoint> userappointall(String openid){
        return userappointService.userappointall(openid);
        }


        @PostMapping("userappointmap")
    public List<Weeksign> userappointmap(String openid){
        List<Userappoint> userappoints=userappointService.userappointall(openid);
        List<Weeksign> weeksigns=new ArrayList<>();
//        List<Classsign> classsigns=new ArrayList<>();
        //初始造表
        for (int j=0;j<7;j++){
            Weeksign weeksign=new Weeksign();
            List<Classsign> classsigns1=new ArrayList<>();
            for(int k=0;k<4;k++){
                Classsign classsign=new Classsign();
                classsign.setUserstate(0);
                classsigns1.add(k,classsign);
            }
            weeksign.setClasssigns(classsigns1);
            weeksigns.add(j,weeksign);
        }

            for(int i=0;i<userappoints.size();i++){
                int appid=userappoints.get(i).getAppointid();
                Appointime appointime=appointimeService.appointbyid(appid);
                int week=appointime.getWeek();
                int classnum=appointime.getClassnum();
                weeksigns.get(week-1).getClasssigns().get(classnum-1).setUserstate(1);

            }
            return weeksigns;


        }
        @PostMapping("teachermap")
    public List<Weeksign> teachermap(Integer tid){
            List<Weeksign> weeksigns=new ArrayList<>();
        List<Integer> appointidtid=new ArrayList<>();
            //这里找出所有的的教练预约对应的id
        List<Appointime> appointimes=appointimeService.appointbytid(tid);

            //初始造表
            for (int j=0;j<7;j++){
                Weeksign weeksign=new Weeksign();
                List<Classsign> classsigns1=new ArrayList<>();
                for(int k=0;k<4;k++){
                    Classsign classsign=new Classsign();
                    classsign.setUserstate(0);
                    classsigns1.add(k,classsign);
                }
                weeksign.setClasssigns(classsigns1);
                weeksigns.add(j,weeksign);
            }
            for (int i=0;i<appointimes.size();i++){
                List<String> username=new ArrayList<>();//名字
                int appid=appointimes.get(i).getAppointid();
                int week=appointimes.get(i).getWeek();
                int classnum=appointimes.get(i).getClassnum();
                List<Userappoint> listuser=userappointService.userappoinbyid(appid);
                for(int j=0;j<listuser.size();j++){
                    String openid=listuser.get(j).getOpenid();
                    String name=userService.useropenid(openid).getNickName();
                    username.add(j,name);
                }
                weeksigns.get(week-1).getClasssigns().get(classnum-1).setUsername(username);
            }
           return weeksigns;
        }
}
