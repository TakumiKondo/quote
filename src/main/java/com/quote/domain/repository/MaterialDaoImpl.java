package com.quote.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quote.domain.model.Material;

@Repository
public class MaterialDaoImpl implements MaterialDao {

	@Autowired
	JdbcTemplate jdbc;

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
			materials.add(material);
		}
		return materials;
	}

	@Override
	public boolean insert(Material material) throws DataAccessException {
		if(existCd(material)) {
			return false;
		}
		String sql = "INSERT INTO materials VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("material : " + material);
		int result = jdbc.update(sql, material.getCd(), material.getName(), material.getUnit_price(),
				material.getCreated_at(), material.getCreatet_user(), material.getUpdated_at(),
				material.getUpdated_user(), material.getDeleted_at(), material.getDeleted_user());
		return result == 1 ? true : false;
	}

	private boolean existCd(Material material) {
		String sql = "SELECT COUNT(*) FROM materials WHERE cd = ? AND deleted_at IS NULL";
		Integer result = jdbc.queryForObject(sql, Integer.class, material.getCd());
		return result > 0 ? true : false;
	}

}
