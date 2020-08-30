package com.quote.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quote.domain.model.BasicCharge;

@Repository
public class BasicChargeDaoImpl implements BasicChargeDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public BasicCharge getOne() throws DataAccessException {
		String sql = "SELECT * FROM basic_charge bc WHERE deleted_at IS NULL ORDER BY bc.created_at DESC LIMIT 1";
		Map<String, Object> result = jdbc.queryForMap(sql);
		BasicCharge basicCharge = new BasicCharge();
		basicCharge.setPrice(Integer.valueOf(result.get("price").toString()));
		basicCharge.setDiscription((result.get("Discription").toString()));
		return basicCharge;
	}

	@Override
	public void update(BasicCharge basicCharge) throws DataAccessException {
		delete();
		insert(basicCharge);
	}

	private void delete() throws DataAccessException {
		String sql = "DELETE FROM basic_charge";
		jdbc.update(sql);
	}

	private void insert(BasicCharge basicCharge) throws DataAccessException {
		String sql = "INSERT INTO basic_charge(price, discription, created_at, createt_user, updated_at, updated_user) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, basicCharge.getPrice(), basicCharge.getDiscription(), basicCharge.getCreated_at(),
				basicCharge.getCreatet_user(), basicCharge.getUpdated_at(), basicCharge.getUpdated_user());
	}

}
