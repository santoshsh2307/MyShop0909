package com.myshop.demo.serviceImpl;

import java.util.Date;
import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.demo.entity.EmployeeShopOwnerRelation;
import com.myshop.demo.entity.ShopDetails;
import com.myshop.demo.repository.EmployeeShopOwnerRelationRepository;
import com.myshop.demo.service.ESORService;

@Service
public class ESORServiceImpl implements ESORService {
	
	@Autowired
	EmployeeShopOwnerRelationRepository esorRepo;

	@Transactional
	public EmployeeShopOwnerRelation saveESOR(EmployeeShopOwnerRelation esor) {
		esor.setCreatedAt(new Date());
		esor.setStatus(true);
		
		// TODO Auto-generated method stub
		EmployeeShopOwnerRelation data = esorRepo.save(esor);
		return data;
	}

	@Transactional
	public Optional<EmployeeShopOwnerRelation> findESORById(Long id) {
		// TODO Auto-generated method stub
		Optional<EmployeeShopOwnerRelation> data = esorRepo.findById(id);
		return data;
	}
	public List<EmployeeShopOwnerRelation> findAll() {
		// TODO Auto-generated method stub
		return esorRepo.findAll();
	}

	@Transactional
	public List<EmployeeShopOwnerRelation> getShopByEmpId(Long id) {
		// TODO Auto-generated method stub
		 List<EmployeeShopOwnerRelation> data = esorRepo.findAllByEmpId(id);
		return data;
	}

}
