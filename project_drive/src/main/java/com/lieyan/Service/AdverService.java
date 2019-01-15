package com.lieyan.Service;

import com.lieyan.Entity.Adver;
import org.springframework.stereotype.Service;

@Service
public interface AdverService {
    /**
     *
     * @param adverid
     * @return
     */
    Adver adverget(Integer adverid);
}
