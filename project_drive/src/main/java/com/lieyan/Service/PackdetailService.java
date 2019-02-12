package com.lieyan.Service;

import com.lieyan.Entity.Packdetail;
import org.springframework.stereotype.Service;

@Service
public interface PackdetailService {
    /**
     *
     * @param packid
     * @return
     */
    Packdetail packdetailbyid(Integer packid);
}
