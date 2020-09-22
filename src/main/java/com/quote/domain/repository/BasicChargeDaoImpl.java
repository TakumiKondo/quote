package com.quote.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import com.quote.domain.model.BasicCharge;
import com.quote.domain.model.Material;

@Repository
public class BasicChargeDaoImpl implements BasicChargeDao {

	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate namedJdbc;

	@Override
	public BasicCharge getOne() throws DataAccessException {
		String sql = "SELECT * FROM basic_charge WHERE deleted_at IS NULL";
		Map<String, Object> result = null;
		BasicCharge basicCharge = new BasicCharge();
		result = jdbc.queryForMap(sql);
		basicCharge.setPrice(Integer.valueOf(result.get("price").toString()));
		basicCharge.setDescription(result.get("Description").toString());
		basicCharge.setVersion(Integer.valueOf(result.get("version").toString()));
		return basicCharge;
	}

	@Override
	public void update(BasicCharge basicCharge) throws DataAccessException {
		String sql = "UPDATE basic_charge SET price = :price, description = :description, "
				+ "updated_at = :updated_at, updated_user = :updated_user, "
				+ "version = :version + 1 "
				+ "WHERE version = :version";
		MapSqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("price", basicCharge.getPrice())
			.addValue("description", basicCharge.getDescription())
			.addValue("updated_at", basicCharge.getUpdated_at())
			.addValue("updated_user", basicCharge.getUpdated_user())
			.addValue("version", basicCharge.getVersion());
		int result = namedJdbc.update(sql, parameters);
		if(result == 0)
			throw new ObjectOptimisticLockingFailureException(Material.class, "1001");
	}

}
