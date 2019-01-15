package com.lieyan.controller;

import com.lieyan.Entity.Address;
import com.lieyan.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("addresslist")
    public Map<String,Object> addresslist(){
        Map<String,Object> map=new HashMap<>();
        List<Address> list=addressService.addresslist();
        map.put("data",list);
        return map;
    }
}
