package com.quote.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quote.domain.model.Material;
import com.quote.domain.repository.MaterialDao;
import com.quote.form.MaterialForm;

@Transactional
@Service
public class MaterialService {

	@Autowired
	MaterialDao dao;

	public List<Material> getList() {
		return dao.getList();
	}

	public boolean insert(MaterialForm form) {
		Material material = new Material();
		Date date = new Date();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();

		material.setCd(form.getCd());
		material.setName(form.getName());
		material.setUnit_price(form.getUnitPrice());
		material.setCreated_at(date);
		material.setCreatet_user(userId);
		material.setUpdated_at(date);
		material.setUpdated_user(userId);
		return dao.insert(material);
	}

}
