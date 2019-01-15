package com.lieyan.Service;

import com.lieyan.Entity.Cardetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardetailService {
    /**
     *
     * @return
     */
    List<Cardetail> cardetailall();

    /**
     *
     * @param id
     * @return
     */
    Cardetail cardetailbyid(Integer id);
}
