package com.lieyan.Service;

import com.lieyan.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 用户登录接口，插入信息进入数据库
     * @param user
     * @return
     */
    boolean userwechatlogin(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> userquery();

    /**
     *
     * @param openid
     * @return
     */
    User useropenid(String openid);

    /**
     *
     * @param openid
     * @return
     */
    boolean userdelete(String openid);
    /**
     *
     * @param openid
     * @param signitem
     * @return
     */
    boolean usersign(String openid,Integer signitem);

//    /**
//     *
//     * @param openid
//     * @param tid
//     * @return
//     */
////    boolean bindteacher(String openid,Integer tid);
boolean userchangename(String openid,String nickName);

    /**
     *
     * @param openid
     * @return
     */
    boolean userissign(String openid);

}
