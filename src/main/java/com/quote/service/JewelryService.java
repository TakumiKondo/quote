package com.quote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quote.domain.model.Jewelry;
import com.quote.domain.repository.JewelryMapper;

@Transactional
@Service
public class JewelryService {

	@Autowired
	JewelryMapper mapper;

	public List<Jewelry> getList() {
		return mapper.getList();
	}

//	public void insert(DesignForm form) {
//		Design design = new Design();
//		Date now = new Date();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String userId = auth.getName();
//		design.setCd(form.getCd());
//		design.setName(form.getName());
//		design.setUnit_price(form.getUnitPrice());
//		design.setCreated_at(now);
//		design.setCreated_user(userId);
//		design.setUpdated_at(now);
//		design.setUpdated_user(userId);;
//		mapper.insert(design);
//	}
//
//	public DesignForm selectOne(DesignForm form) {
//		Design design = mapper.selectOne(form.getCd());
//		DesignForm df = new DesignForm();
//		df.setCd(design.getCd());
//		df.setName(design.getName());
//		df.setUnitPrice(design.getUnit_price());
//		df.setVersion(design.getVersion());
//		return df;
//	}
//
//	public void update(DesignForm form) {
//		Design design = new Design();
//		design.setCd(form.getCd());
//		design.setName(form.getName());
//		design.setUnit_price(form.getUnitPrice());
//		design.setUpdated_at(new Date());
//		design.setUpdated_user(SecurityContextHolder.getContext().getAuthentication().getName());
//		design.setVersion(form.getVersion());
//		int result = mapper.update(design);
//		if(result == 0) {
//			throw new ObjectOptimisticLockingFailureException(Design.class, "1001");
//		}
//	}
//
//	public boolean isUpdated(DesignForm form) {
//		Design design = new Design();
//		design.setCd(form.getCd());
//		design.setVersion(form.getVersion());
//		return mapper.isUpdate(design) > 0 ? false : true;
//	}
//
//	public void delete(DesignForm form) {
//		Design design = new Design();
//		design.setCd(form.getCd());
//		design.setDeleted_at(new Date());
//		design.setDeleted_user(SecurityContextHolder.getContext().getAuthentication().getName());
//		mapper.delete(design);
//	}
//
//	public boolean existCd(DesignForm form) {
//		return mapper.countRow(form.getCd()) > 0 ? true : false;
//	}

}
