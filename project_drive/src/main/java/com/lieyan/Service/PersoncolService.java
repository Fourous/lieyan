package com.lieyan.Service;

import com.lieyan.Entity.Personcol;
import org.springframework.stereotype.Service;

@Service
public interface PersoncolService {
    /**
     *
     * @param tid
     * @param openid
     * @return
     */
    Personcol perorigin(Integer tid,String openid);

    /**
     *
     * @param personcol
     * @return
     */
    boolean perinsert (Personcol personcol);

    /**
     *
     * @param tid
     * @param openid
     * @param islike
     * @param unlike
     * @return
     */
    boolean perupdate(Integer tid,String openid,Integer islike,Integer unlike);
}
