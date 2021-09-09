package com.myshop.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.demo.DAO.TestDao;
import com.myshop.demo.entity.ServicesInShop;
import com.myshop.demo.repository.servicesInShopRepository;
import com.myshop.demo.service.SercicesInShopService;

 @Service
public class servicesInShopServiceImpl implements SercicesInShopService {

	 @Autowired
	 servicesInShopRepository sRepo;
	 
	 @Autowired
	 TestDao dao;
	 
	 
	@Transactional
	public List<ServicesInShop> getAllService() {
		// TODO Auto-generated method stub
		List<ServicesInShop> data = sRepo.findAll();
		return data;
	}

	@Transactional
	public List<ServicesInShop> saveServicesInShop(List<ServicesInShop> ser) {
		// TODO Auto-generated method stub
		return sRepo.saveAll(ser);
	}

	@Transactional
	public Optional<ServicesInShop> getServiceBuId(Long id) {
		// TODO Auto-generated method stub
		return sRepo.findById(id);
	}

	@Override
	public List<ServicesInShop> getShopServicesByShopId(Long shopId) {
		// TODO Auto-generated method stub
		return dao.getShopServicesByShopId(shopId);
	}

}
