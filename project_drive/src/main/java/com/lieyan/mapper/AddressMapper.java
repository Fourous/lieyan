package com.lieyan.mapper;

import com.lieyan.Entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
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
