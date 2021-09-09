package com.myshop.demo.service;

import java.util.List;
import java.util.Optional;

import com.myshop.demo.entity.ShopDetails;

public interface ShopService  {


	ShopDetails saveShop(ShopDetails s);

	ShopDetails findShopById(Long id);
	List<ShopDetails> findAll();

	List<ShopDetails> findShopByShopName(String shopName);

	Optional<ShopDetails> findByAddress(String add);

}
