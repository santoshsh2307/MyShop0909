package com.myshop.demo.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.demo.entity.OwnerShopServicesRelation;
import com.myshop.demo.repository.OwnerShopServiceRepository;
import com.myshop.demo.service.OwnerShopService;

@Service
public class OwnerShopServiceImpl implements OwnerShopService {
	
	@Autowired
	OwnerShopServiceRepository oRepo;

	@Transactional
	public void saveOwnerShopService(OwnerShopServicesRelation entity) {
		oRepo.save(entity);
		// TODO Auto-generated method stub
		
		
	}

}
