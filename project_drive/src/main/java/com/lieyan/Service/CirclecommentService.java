package com.lieyan.Service;

import com.lieyan.Entity.Circle;
import com.lieyan.Entity.Circlecomment;
import com.lieyan.Entity.Commentmore;
import com.lieyan.Entity.Commentone;
import com.sun.webkit.dom.CommentImpl;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface CirclecommentService {
    /**
     *
     * @param circleid
     * @param openid
     * @param comment
     * @return
     */
    boolean circlecommentinsert(Integer circleid,String openid,String comment);

    /**
     *
     * @param circleid
     * @return
     */
    List<Circlecomment> ciclecommentbycircleid(Integer circleid);

    /**
     *
     * @param commentid
     * @return
     */
    boolean circlecommentdeletebyid(Integer commentid);

    /**
     *
     * @param circleid
     * @return
     */
    List <Commentone> circlecommentthree(Integer circleid);

    /**
     *
     * @param circleid
     * @param limit
     * @return
     */
    List<Commentmore> circommentmore(Integer circleid, Integer limit);

}
