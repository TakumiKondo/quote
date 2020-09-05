package com.quote.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.quote.domain.model.Material;

public interface MaterialDao {
    public List<Material> getList() throws DataAccessException;
	public boolean insert(Material material) throws DataAccessException;
}
