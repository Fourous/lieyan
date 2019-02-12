package com.lieyan.Service;

import com.lieyan.Entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    /**
     *
     * @return
     */
    List<Address> addresslist();

    /**
     *
     * @param id
     * @return
     */
    Address addressbyid(Integer id);
}
