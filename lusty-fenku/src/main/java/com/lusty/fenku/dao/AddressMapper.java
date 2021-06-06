package com.lusty.fenku.dao;

import com.lusty.fenku.entity.Address;
import com.lusty.fenku.entity.User;

public interface AddressMapper {
    /**
     * 保存
     */
    void save(Address address);

    /**
     * 查询
     * @param id
     * @return
     */
    Address get(Long id);
}
