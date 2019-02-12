package com.lieyan.Service;

import com.lieyan.Entity.Packdetail;
import com.lieyan.mapper.PackdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackdetailServicempl implements PackdetailService {
    @Autowired
    private PackdetailMapper packdetailMapper;
    public Packdetail packdetailbyid(Integer packid){
        return packdetailMapper.packdetailbyid(packid);
    }

}
