package com.lieyan.mapper;

import com.lieyan.Entity.Useradmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UseradminMapper {
    /**
     *
     * @return
     */
    List<Useradmin> useradminquery();

    /**
     *
     * @param userid
     * @return
     */
    Useradmin useradminbyid(Integer userid);

    /**
     *
     * @param username
     * @return
     */
    Useradmin useradminbyname(String username);

    /**
     *
     * @param username
     * @param userpasswd
     * @return
     */
    int useradmininsert(String username,String userpasswd);

    /**
     *
     * @param userid
     * @return
     */
    int useradmindelete(Integer userid);


}
