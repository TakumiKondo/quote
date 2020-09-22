package com.quote.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quote.domain.model.BasicCharge;
import com.quote.domain.repository.BasicChargeDao;

@Transactional
@Service
public class BasicChargeService {

	@Autowired
	BasicChargeDao dao;

	public BasicCharge getOne() {
		return dao.getOne();
	}

	public void update(BasicCharge basicCharge) throws ObjectOptimisticLockingFailureException {
		Date date = new Date();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		basicCharge.setCreated_at(date);
		basicCharge.setCreatet_user(userId);
		basicCharge.setUpdated_at(date);
		basicCharge.setUpdated_user(userId);
		dao.update(basicCharge);
	}
}
