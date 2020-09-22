package com.quote.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.quote.domain.model.Material;
import com.quote.form.MaterialForm;

public interface MaterialDao {
    public List<Material> getList() throws DataAccessException;
	public void insert(Material material) throws DataAccessException;
	public boolean existCd(String cd) throws DataAccessException;
	public MaterialForm selectOne(String cd) throws DataAccessException;
	public void update(Material material) throws DataAccessException;
	public void delete(Material material) throws DataAccessException;
}
