package com.myshop.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.entity.ShopDetails;
import com.myshop.demo.service.ShopService;

@RestController
@RequestMapping(value = "/shopController")
public class ShopController {

	@Autowired
	ShopService sSer; 
	
	@PostMapping(value = "/createShop")
	public HashMap<String, Object> createShop(@RequestBody ShopDetails s) {
		ShopDetails data = sSer.saveShop(s);
		HashMap<String, Object> map = new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
		}
		return map;
	
		
		
	}

	@GetMapping(value = "/getShopById")
	public HashMap<String, Object> getShopById(Long id) {
		ShopDetails data = sSer.findShopById(id);
		HashMap<String, Object> map = new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
		}
		return map;
		
		
	}

	@GetMapping(value ="/getAllShopDetails")
	public HashMap<String,Object>getAllShopDetails(){
	List<ShopDetails>shopdata=sSer.findAll();
	HashMap<String,Object>map=new HashMap<>();
	if (shopdata!=null) {
		map.put("code", "200");
		map.put("content", shopdata);
	} else {
		map.put("code", "201");
		map.put("content", "noshopdata");
		
	}
	return map;

	}
	@GetMapping(value = "/getShopByShopName/{name}")
	public HashMap<String, Object> getShopByShopName(@PathVariable ("name")String shopName) {
		List<ShopDetails> data = sSer.findShopByShopName(shopName);
		 HashMap<String, Object> map = new HashMap<>();
			if (data!=null) {
				map.put("code", "200");
				map.put("content", data);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
				
				
			}
			return map;
		
		
	}
	@GetMapping(value = "/getShopByAddress/{address}")
	public HashMap<String, Object> getShopByAddress(@PathVariable("address") String add) {
		Optional<ShopDetails> data = sSer.findByAddress(add);
		 HashMap<String, Object> map = new HashMap<>();
			if (data!=null) {
				map.put("code", "200");
				map.put("content", data);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
				
				
			}
			return map;
		
		
	}
}
