package com.quote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quote.domain.model.Material;
import com.quote.domain.repository.MaterialDao;

@Transactional
@Service
public class MaterialService {

	@Autowired
	MaterialDao dao;

	public List<Material> getList() {
		return dao.getList();
	}

}
