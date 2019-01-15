package com.lieyan.Service;

import com.lieyan.Entity.Address;
import com.lieyan.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServicempl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> addresslist() {
        return addressMapper.addresslist();
    }
}
