package com.myshop.demo.service;

import java.util.List;
import java.util.Optional;

import com.myshop.demo.entity.ServicesInShop;

public interface SercicesInShopService {

	List<ServicesInShop> getAllService();

	List<ServicesInShop> saveServicesInShop(List<ServicesInShop> ser);

	Optional<ServicesInShop> getServiceBuId(Long id);

	List<ServicesInShop> getShopServicesByShopId(Long shopId);


}
