package com.myshop.demo.service;

import java.util.List;

import com.myshop.demo.entity.ShopAvailablity;

public interface ShopAvailabilityService {

	ShopAvailablity saveShopAvailability(ShopAvailablity sa);

	ShopAvailablity findShopAvailableById(Long id);
	List<ShopAvailablity> findAll();

}
