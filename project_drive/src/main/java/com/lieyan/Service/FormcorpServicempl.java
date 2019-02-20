package com.lieyan.Service;

import com.lieyan.Entity.Formcorp;
import com.lieyan.mapper.FormcorpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormcorpServicempl implements FormcorpService{
    @Autowired
    private FormcorpMapper formcorpMapper;

    public List<Formcorp> formcorpquery(){
        return formcorpMapper.formcorpquery();
    }


    public Formcorp formcorpquerybyid(Integer fid){
        return formcorpMapper.formcorpquerybyid(fid);
    }

    public boolean formcorpinsert(Formcorp formcorp){
        if(formcorpMapper.formcorpinsert(formcorp)>0){
            return true;
        }else return false;
    }

}
