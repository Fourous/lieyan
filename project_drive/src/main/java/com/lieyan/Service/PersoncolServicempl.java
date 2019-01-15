package com.lieyan.Service;

import com.lieyan.Entity.Personcol;
import com.lieyan.mapper.PersoncolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersoncolServicempl implements PersoncolService {
    @Autowired
    private PersoncolMapper personcolMapper;

    /**
     *
     * @param tid
     * @param openid
     * @return
     */
    public Personcol perorigin(Integer tid, String openid){

        return personcolMapper.perorigin(tid,openid);
    }
    //插入这个动作记录

    /**
     *
     * @param personcol
     * @return
     */
    public boolean perinsert (Personcol personcol){
        int setnum=personcolMapper.perinsert(personcol);
        if(setnum>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     *
     * @param tid
     * @param openid
     * @param islike
     * @param unlike
     * @return
     */
    public boolean perupdate(Integer tid,String openid,Integer islike,Integer unlike){
        int senum=personcolMapper.perupdate(tid,openid,islike,unlike);
        System.out.println(tid+openid+islike+unlike);
        if(senum>0){
            return true;
        }else {
            return false;
        }

    }


}
