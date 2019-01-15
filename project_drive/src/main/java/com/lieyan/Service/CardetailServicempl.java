package com.lieyan.Service;

import com.lieyan.Entity.Cardetail;
import com.lieyan.mapper.CardetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardetailServicempl implements CardetailService {
    @Autowired
    private CardetailMapper cardetailMapper;

    @Override
    public List<Cardetail> cardetailall() {
        return cardetailMapper.cardetilall();
    }

    @Override
    public Cardetail cardetailbyid(Integer id) {
        return cardetailMapper.cardetailbyid(id);
    }

}
