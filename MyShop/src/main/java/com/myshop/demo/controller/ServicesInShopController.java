package com.myshop.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.entity.ServicesInShop;
import com.myshop.demo.service.SercicesInShopService;

@RestController
@RequestMapping(value = "/serviceInShopController")
public class ServicesInShopController {
	
	@Autowired
	SercicesInShopService sSer;
	
	@GetMapping(value = "/getAllService")
	public HashMap<String, Object> getAllService(Long id) {
		HashMap<String, Object> map = new HashMap<>();
		
		if (id!=null) {
			Optional<ServicesInShop> data = sSer.getServiceBuId(id);
			if (data!=null) {
				map.put("code", "200");
				map.put("content", data);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
			}
			
		} else {
			List<ServicesInShop> data = sSer.getAllService();
			if (data!=null) {
				map.put("code", "200");
				map.put("content", data);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
			}
		}
		
		return map;
	}
	@RequestMapping(value = "/saveServicesInShop")
	public HashMap<String, Object> saveServicesInShop(@RequestBody  List<ServicesInShop> ser) {
		List<ServicesInShop> serData =  sSer.saveServicesInShop(ser);
		HashMap<String, Object> map = new HashMap<>();
		if (!serData.isEmpty()) {
			map.put("code", "200");
			map.put("content", serData);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
		}
		return map;
		
	}
	@GetMapping("/getShopServicesByShopId")
	public HashMap<String, Object> getShopServicesByShopId(Long shopId) {
		List<ServicesInShop> data = sSer.getShopServicesByShopId(shopId);
		HashMap<String, Object> map = new HashMap<>();
		if (!data.isEmpty()) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
		}
		return map;
		
		
	}
}
