package com.lieyan.Service;

import com.lieyan.Entity.Useradmin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UseradminService {
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
    boolean useradmininsert(String username,String userpasswd);

    /**
     *
     * @param userid
     * @return
     */
    boolean useradmindelete(Integer userid);
}
