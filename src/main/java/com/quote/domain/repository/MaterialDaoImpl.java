package com.quote.domain.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quote.domain.model.Material;
import com.quote.form.MaterialForm;

@Repository
public class MaterialDaoImpl implements MaterialDao {

	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate namedJdbc;


	@Override
	public List<Material> getList() throws DataAccessException {
		String sql = "SELECT * FROM materials WHERE deleted_at IS NULL";
		List<Map<String, Object>> results = jdbc.queryForList(sql);
		List<Material> materials = new ArrayList<Material>();
		for(Map<String, Object> result: results) {
			Material material = new Material();
			material.setCd(result.get("cd").toString());
			material.setName(result.get("name").toString());
			material.setUnit_price(Integer.valueOf(result.get("unit_price").toString()));
			material.setUpdated_at((Date)result.get("updated_at"));
			materials.add(material);
		}
		return materials;
	}


	@Override
	public void insert(Material material) throws DataAccessException {
		String sql = "INSERT INTO materials VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, material.getCd(), material.getName(), material.getUnit_price(),
				material.getCreated_at(), material.getCreatet_user(), material.getUpdated_at(),
				material.getUpdated_user(), material.getDeleted_at(), material.getDeleted_user());
	}


	@Override
	public boolean existCd(String cd) {
		String sql = "SELECT COUNT(*) FROM materials WHERE cd = ? AND deleted_at IS NULL";
		Integer result = jdbc.queryForObject(sql, Integer.class, cd);
		return result > 0 ? true : false;
	}


	@Override
	public MaterialForm selectOne(String cd) throws DataAccessException {
		String sql = "SELECT * FROM materials WHERE cd = ? AND deleted_at IS NULL";
		Map<String, Object> result = null;
		try {
			result = jdbc.queryForMap(sql, cd);
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getStackTrace());
			return new MaterialForm();
		}

		MaterialForm mf = new MaterialForm();
		mf.setCd((String)result.get("cd"));
		mf.setName((String)result.get("name"));
		mf.setUnitPrice(Integer.valueOf(result.get("unit_price").toString()));
		mf.setUpdatedAt((Date)result.get("updated_at"));
		return mf;
	}


	@Override
	public void update(Material material) throws DataAccessException {
		String sql = "UPDATE materials SET name = :name, unit_price = :unit_price, "
				+ "updated_at = :updated_at, updated_user = :updated_user "
				+ "WHERE cd = :cd";
		MapSqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("cd", material.getCd())
			.addValue("name", material.getName())
			.addValue("unit_price", material.getUnit_price())
			.addValue("updated_at", material.getUpdated_at())
			.addValue("updated_user", material.getUpdated_user());
		int result = namedJdbc.update(sql, parameters);
		if(result == 0)
			throw new IllegalStateException("更新対象が存在しませんでした。");
	}


	@Override
	public boolean isUpdated(Material material) throws DataAccessException {
		String sql = "SELECT COUNT(*) FROM materials WHERE cd = :cd AND updated_at = :updated_at";
		MapSqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("cd", material.getCd())
				.addValue("updated_at", material.getUpdated_at());
		Integer result = namedJdbc.queryForObject(sql, parameters, Integer.class);
		return result > 0 ? false : true;
	}


	@Override
	public void delete(Material material) throws DataAccessException {
		String sql = "UPDATE materials SET deleted_at = :deleted_at, deleted_user = :deleted_user "
				+ "WHERE cd = :cd";
		MapSqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("cd", material.getCd())
			.addValue("deleted_at", material.getDeleted_at())
			.addValue("deleted_user", material.getDeleted_user());
		int result = namedJdbc.update(sql, parameters);
		if(result == 0)
			throw new IllegalStateException("削除対象が存在しませんでした。");
	}

}
