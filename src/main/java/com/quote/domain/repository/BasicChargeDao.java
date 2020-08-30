package com.quote.domain.repository;

import org.springframework.dao.DataAccessException;

import com.quote.domain.model.BasicCharge;

public interface BasicChargeDao {
    public BasicCharge getOne() throws DataAccessException;
    public void update(BasicCharge basicCharge);
}
