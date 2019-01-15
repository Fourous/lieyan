package com.lieyan.Service;

import com.lieyan.Entity.Form;
import com.lieyan.mapper.FormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServicempl implements FormService {
    @Autowired
    private FormMapper formMapper;

    /**
     *
     * @return
     */
    public List<Form> userformget(){
        return formMapper.userform();
    }

    /**
     *
     * @param form
     * @return
     */


    public boolean userforminsert(Form form){
        int setnum=formMapper.userforminsert(form);
        if(setnum>0){
            return true;
        }
        else {
            throw new RuntimeException("插入失败");
        }
    }

}
