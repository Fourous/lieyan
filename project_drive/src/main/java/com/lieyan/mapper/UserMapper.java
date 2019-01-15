package com.lieyan.mapper;

import com.lieyan.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     *
     * @param user
     * @return
     */
    int userinsert(User user);

    /**
     * 查询用户信息，每次新用户登录，检索是否有重复的user-open-id，有则不用添加
     *
     * @return
     */
    List<User> userquery();

    /**
     *
     * @param openid
     * @return
     */

    User userquerybyid(String openid);

    /**
     *
     * @param openid
     * @return
     */
    int userdelete(String openid);

    int usersign(@Param("openid") String openid,@Param("signitem") Integer signitem);

    int bindteacher(@Param("openid") String openid,@Param("tid") Integer tid);

    int userchangename(@Param("openid") String openid,@Param("nickName") String nickName);
}
