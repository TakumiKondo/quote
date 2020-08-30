package com.quote.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quote.domain.model.BasicCharge;

@Repository
public interface BasicChargeRepository {

	@Query("SELCT * FROM basic_charge bc WHERE deleted_at IS NULL ORDER BY bc.created_at DESC LIMIT 1")
    public BasicCharge findOne();
}
