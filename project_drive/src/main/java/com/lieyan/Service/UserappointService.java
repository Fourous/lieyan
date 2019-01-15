package com.lieyan.Service;

import com.lieyan.Entity.Userappoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserappointService {
    /**
     *
     * @param openid
     * @param appointid
     * @return
     */
    boolean userappoint(String openid,Integer appointid);



    /**
     *
     * @param openid
     * @param appointid
     * @return
     */
    boolean userappointdele(String openid,Integer appointid);

    /**
     *
     * @param openid
     * @return
     */
    List<Userappoint> userappointall(String openid);

    /**
     *
     * @param appointid
     * @return
     */
    List<Userappoint> userappoinbyid(Integer appointid);


}
