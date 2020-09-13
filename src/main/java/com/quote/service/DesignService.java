package com.quote.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quote.domain.model.Design;
import com.quote.domain.repository.DesignMapper;
import com.quote.form.DesignForm;

@Transactional
@Service
public class DesignService {

	@Autowired
	DesignMapper mapper;

	public List<Design> getList() {
		return mapper.getList();
	}

	public void insert(DesignForm form) {
		Design design = new Design();
		Date now = new Date();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		design.setCd(form.getCd());
		design.setName(form.getName());
		design.setUnit_price(form.getUnitPrice());
		design.setCreated_at(now);
		design.setCreated_user(userId);
		design.setUpdated_at(now);
		design.setUpdated_user(userId);;
		mapper.insert(design);
	}

}
