package com.quote.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quote.domain.model.BasicCharge;

@Repository
public class BasicChargeDaoImpl implements BasicChargeDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public BasicCharge getOne() throws DataAccessException {
		String sql = "SELECT * FROM basic_charge WHERE deleted_at IS NULL";
		Map<String, Object> result = null;
		BasicCharge basicCharge = new BasicCharge();
		Integer price = new Integer(0);
		String description = "";
		try {
			result = jdbc.queryForMap(sql);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("マスターにデータがありません。");
		}
		if(result != null) {
			price = Integer.valueOf(result.get("price").toString());
			description = result.get("Discription").toString();
		}
		basicCharge.setPrice(price);
		basicCharge.setDiscription(description);
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
