package com.myshop.demo.serviceImpl;

import java.util.Date;
import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.demo.entity.ShopAvailablity;
import com.myshop.demo.repository.ShopAvailablityRepository;
import com.myshop.demo.service.ShopAvailabilityService;

@Service
public class ShopAvailabilityServiceImpl implements ShopAvailabilityService {
	
	@Autowired
	ShopAvailablityRepository saRepo;

	@Transactional
	public ShopAvailablity saveShopAvailability(ShopAvailablity sa) {
		sa.setCreatedDate(new Date());
		sa.setStatus(true);
		
		ShopAvailablity data = saRepo.save(sa);
		// TODO Auto-generated method stub
		return data;
	}

	@Transactional
	public ShopAvailablity findShopAvailableById(Long id) {
		// TODO Auto-generated method stub
		Optional<ShopAvailablity> data = saRepo.findById(id);
		return data.get();
	}
	public List<ShopAvailablity> findAll() {
		// TODO Auto-generated method stub

		return saRepo.findAll() ;
	}

}
