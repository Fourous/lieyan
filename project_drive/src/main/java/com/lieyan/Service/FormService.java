package com.lieyan.Service;

import com.lieyan.Entity.Form;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {
    /**
     *
     * @return
     */
    List<Form> userformget();

    /**
     *
     * @param form
     * @return
     */
    boolean userforminsert(Form form);

    /**
     *
     * @param fid
     * @param fteacher
     * @return
     */
    boolean userformupdate(Integer fid,String fteacher);

    /**
     *
     * @param fid
     * @return
     */
    boolean userformdelete(Integer fid);

    /**
     *
     * @param fid
     * @return
     */
    Form userformquerybyid(Integer fid);


}
