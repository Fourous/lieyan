package com.lieyan.Service;

import com.lieyan.Entity.Coach;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoachService {
    /**
     *
     * @return
     */
    List<Coach> coachall ();

    /**
     *
     * @param tid
     * @return
     */
    Coach coachone(Integer tid);

    /**
     *
     * @param tid
     * @return
     */
    boolean coachlike(Integer tid);

    /**
     *
     * @param tid
     * @return
     */
    boolean coachunlike(Integer tid);

    /**
     *
     * @param tid
     * @return
     */
    boolean coachlikere(Integer tid);

    /**
     *
     * @param tid
     * @return
     */
    boolean coachunlikere(Integer tid);




}
