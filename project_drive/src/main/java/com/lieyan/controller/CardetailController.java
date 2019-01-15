package com.lieyan.controller;

import com.lieyan.Entity.Cardetail;
import com.lieyan.Service.CardetailService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class CardetailController {
    @Autowired
    private CardetailService cardetailService;
    @PostMapping("cardetailall")
    public List<Cardetail> cardetailall(){
        return cardetailService.cardetailall();
    }
    @PostMapping("cardetailallsome")
    public List<Cardetail> cardetailallsome(){
        List<Cardetail> list =cardetailService.cardetailall();
        List<Cardetail> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Cardetail cardetail=new Cardetail();
            cardetail.setId(list.get(i).getId());
            cardetail.setIntroduce(list.get(i).getIntroduce());
            cardetail.setIntropic(list.get(i).getIntropic());
            list1.add(i,cardetail);
        }
        return list1;
    }
    @PostMapping("cardetailbyid")
    public Cardetail cardetailbyid(Integer id){
        return cardetailService.cardetailbyid(id);
    }

}
