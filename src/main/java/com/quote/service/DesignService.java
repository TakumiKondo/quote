package com.quote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quote.domain.model.Design;
import com.quote.domain.repository.DesignMapper;

@Transactional
@Service
public class DesignService {

	@Autowired
	DesignMapper mapper;

	public List<Design>  getList() {
		return mapper.getList();
	}

}
