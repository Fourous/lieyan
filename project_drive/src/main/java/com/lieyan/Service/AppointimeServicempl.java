package com.lieyan.Service;

import com.lieyan.Entity.Appointime;
import com.lieyan.Entity.Classsign;
import com.lieyan.Entity.Userappoint;
import com.lieyan.Entity.Weeksign;
import com.lieyan.mapper.AppointimeMapper;
import com.lieyan.mapper.UserappointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class AppointimeServicempl implements AppointimeService{
    @Autowired
    private AppointimeMapper appointimeMapper;
    @Autowired
    private UserappointService userappointService;
    private static final int t1=800;
    private static final int t2=940;
    private static final int t3=1000;
    private static final int t4=1140;
    private static final int t5=1330;
    private static final int t6=1530;
    private static final int t7=1550;
    private static final int t8=1740;
    //这里是首先传入一个week的值，将week这个，将数据库当前的状态置位
    public int settableweek(long time){
        int week=Convertime.getWeek(time);
    int set=appointimeMapper.appointweeksta(week,1);
    int set1=appointimeMapper.appointweekstasta(week,0);
    if(set>0&&set1>0){
        return 1;
    }else{
        return 0;
        }
    }

    public int setabletime(long time){
//        从这里开始判断，是属于那节课
        int week=Convertime.getWeek(time);//这里判断是周几
        String timeformat=Convertime.getTime(time);
        System.out.println(timeformat);
        //这里字符串分割
        List<String> list=new ArrayList<>();
        List<String> listlast=new ArrayList<>();
        int now=0;
        int classnumdiv=0;
        String last="";
        String temp="";
        System.out.println("当前时间为"+time);
        String timeformatone=Convertime.getTime(time);
        System.out.println(timeformatone);

        StringTokenizer st = new StringTokenizer(timeformatone);
        while(st.hasMoreElements()){
            System.out.println("Token:" + st.nextToken());
            list.add(st.nextToken());
        }
        for(int i=0;i<list.size();i++){
            temp+=list.get(i);
        }
        System.out.println(temp);
        String[] strings=temp.split("\\:");
        for (int j=0;j<2;j++){
            last+=strings[j];
        }
        System.out.println("￥￥￥￥￥这里是第几节课￥￥￥￥￥"+last);
        int timenum=Integer.parseInt(last);
        //这里得到这个last的值以后，开始判断是为那节课
        if(timenum<t1){
            classnumdiv=0;
        }else if(timenum>t1&&timenum<t3){
            classnumdiv=1;
        }else if(timenum>t3&&timenum<t5){
            classnumdiv=2;
        }else if(timenum>t5&&timenum<t7){
            classnumdiv=3;
        }else if(timenum>t7) {
        classnumdiv=4;
        }
        int set=appointimeMapper.appointtimesta(week,classnumdiv,1);
        int set1=appointimeMapper.appointtimestasta(week,classnumdiv,0);
        if(set>0&&set1>0)
        {return 1;}
        else return 0;

    }
//    判断用户是否预约
    public int isuserassign(String openid,Integer tid,Integer appointid){
        System.out.println("终端1");
        int total=0;
        List<Userappoint> userappoints=userappointService.userappointall(openid);
        System.out.println(userappoints);
        System.out.println("终端2");
        if(userappoints==null){
            return 0;
        }else {
            System.out.println("××××××××××这里是显示判断×××××××××××××");
            System.out.println(openid+"++"+tid+"++"+appointid);
            for(int i=0;i<userappoints.size();i++){
                Integer userappointid=userappoints.get(i).getAppointid();
                System.out.println("这是用户比较"+userappointid+appointid);
                if(userappointid==appointid){
                    System.out.println("判断结果");
                    System.out.println(userappointid==appointid);
                    total+=1;
                }
            }
            if(total>0){
                return 1;
            }else return 0;
        }

//        System.out.println("终端3");

    }
public List<Appointime> test(Integer tid, Integer week){
        return appointimeMapper.appointoneday(tid,week);
}

    public List<Weeksign> Teatime(String openid,Integer tid, long time) {
        //首先讲时间戳改成可识别的与数据库tid对应的时间表
        System.out.println("这里是传进来的当前时间"+time);
        System.out.println("这里测试是什么周，这里是一个测试");
        System.out.println("测试结果"+Convertime.getWeek(time));
        List<Weeksign> weeksigns=new ArrayList<>();


        //这里打印出来所传进来的时间，通过当前时间，来返回当前时间的教练排班表
//        if(time>0){
//            System.out.println("这里是但这个long在值大于0的时候，的触发函数");
//        }else{
//            System.out.println("这里是小于0的时候的触发函数");
//        }
        //分别对应一周七天

        for(int i=1;i<8;i++){
            Weeksign weeksign=new Weeksign();
//            List<Classsign> classsigns=new ArrayList<>();
//            weeksign.setWeekid(i);

            List<Classsign> classsigns=new ArrayList();
          List<Appointime> listapp=appointimeMapper.appointoneday(tid,i);
          //这里是组装每周能否预约的数据
          for(int j=0;j<listapp.size();j++){
                Classsign classsign=new Classsign();
                classsign.setClassid(j);
                classsign.setNum(listapp.get(j).getClassnum());
                classsign.setState(listapp.get(j).getState());
                classsign.setUserstate(isuserassign(openid,tid,listapp.get(j).getAppointid()));
                classsigns.add(j,classsign);
          }
          weeksign.setClasssigns(classsigns);
//           List<Integer> sta=new ArrayList<>();
//           List<Integer> person=new ArrayList<>();
//           System.out.println("上面没问题");
//           System.out.println(listapp.get(0).getState());
//           System.out.println(listapp.get(2).getState());
//           for(int k=0;k<listapp.size();k++){
//               sta.add(k,listapp.get(k).getState());
//               person.add(k,listapp.get(k).getPersonum());
//           }
//
//            System.out.println("这里是表示获取到的周几的记录"+listapp);
//            weeksign.setSta(sta);
//            weeksign.setPernum(person);
//            weeksigns.add(i-1,weeksign);
//            System.out.println("这里表示周几的排班"+weeksign);
            weeksigns.add(i-1,weeksign);
        }
            return weeksigns;
    }

    public boolean appointadd(Integer appointid){
        Appointime appointime=appointimeMapper.appointbyid(appointid);
        int num=appointime.getPersonum();//获取当前的人数
        if(num>=7){//当大于7人的时候
            appointimeMapper.appointchasta(appointid,1);//把数据库的值置为不可用
            return false;
        }else{
            if(num==6){
                appointimeMapper.appointchanum(appointid,num+1);
                appointimeMapper.appointchasta(appointid,1);
                return true;
            }else {
                appointimeMapper.appointchanum(appointid,num+1);
                return true;
            }
        }
    }

    public boolean appointdel(Integer appointid){
        Appointime appointime=appointimeMapper.appointbyid(appointid);
        int num=appointime.getPersonum();
        if(num<=0){
            appointimeMapper.appointchanum(appointid,0);
            appointimeMapper.appointchasta(appointid,0);
            return true;
        }else {
            if(num>=7){
                appointimeMapper.appointchanum(appointid,6);
                appointimeMapper.appointchasta(appointid,0);
                return true;
            }else {
                appointimeMapper.appointchanum(appointid,num-1);
                return true;
            }
        }
    }
    public  boolean appointstate(Integer appointid,Integer state){
        int num=appointimeMapper.appointchasta(appointid,state);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    public Appointime appointbyid(Integer appointid){
        return appointimeMapper.appointbyid(appointid);
    }
    public List<Appointime> appointbytid(Integer tid){
        return appointimeMapper.appointbytid(tid);
    }

    public int findteacherappid(Integer tid,Integer week,Integer classnum){
        Appointime appointime=appointimeMapper.appofindappid(tid,classnum,week);
        return appointime.getAppointid();
    }
}
