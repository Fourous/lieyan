package com.lieyan.Service;

import com.lieyan.Entity.Packdetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackdetailService {
    /**
     *
     * @param packid
     * @return
     */
    Packdetail packdetailbyid(Integer packid);

    /**
     *
     * @return
     */
    List<Packdetail> packdetailall();
}
