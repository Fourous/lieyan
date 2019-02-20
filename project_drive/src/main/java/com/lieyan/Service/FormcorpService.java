package com.lieyan.Service;

import com.lieyan.Entity.Formcorp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormcorpService {
    /**
     *
     * @return
     */
    List<Formcorp> formcorpquery();

    /**
     *
     * @param fid
     * @return
     */
    Formcorp formcorpquerybyid(Integer fid);

    /**
     *
     * @param formcorp
     * @return
     */
    boolean formcorpinsert(Formcorp formcorp);


}
