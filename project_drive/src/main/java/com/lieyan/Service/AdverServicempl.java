package com.lieyan.Service;

import com.lieyan.Entity.Adver;
import com.lieyan.mapper.AdverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdverServicempl implements AdverService{
    @Autowired
    private AdverMapper adverMapper;
    public Adver adverget(Integer adverid){
        return adverMapper.adverbyid(adverid);
    }
}
