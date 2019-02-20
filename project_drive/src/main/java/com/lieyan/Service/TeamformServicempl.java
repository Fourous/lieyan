package com.lieyan.Service;

import com.lieyan.Entity.Teamform;
import com.lieyan.mapper.TeamformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamformServicempl implements TeamformService {
    @Autowired
    private TeamformMapper teamformMapper;
    private TeamformService teamformService;

    public Integer teamforminsert(String teamid, String teamname, String openid,  Integer formid){
//        这里判断是不是加入其他战队
        if(teamformService.teamformquerybyopenid(openid)!=null){
            System.out.println(teamformService.teamformquerybyopenid(openid));
            return 1;//这里加入了其他战队
        }
        else if(teamformquerybyteamid(teamid).size()>=4){
            return 2;//这里是参与人数超了
        }
        else if(teamformMapper.teamforminsert(teamid,teamname,openid,formid)<=0){
            return 3;
        }
        else return 4;

    }

    /**
     *
     * @param teamid
     * @return
     */
    public List<Teamform> teamformquerybyteamid(String teamid){
        return teamformMapper.teamformquerybyteamid(teamid);
    }

    /**
     *
     * @param openid
     * @return
     */
    public Teamform teamformquerybyopenid(String openid){
        return teamformMapper.teamformquerybyopenid(openid);
    }

    /**
     *
     * @param teamid
     * @return
     */
    public boolean teamformpush(String teamid){
        if(teamformMapper.teamformpush(teamid)>0){
            return true;
        }else return false;
    }
}
