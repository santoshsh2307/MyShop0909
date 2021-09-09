package com.myshop.demo.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.DTO.OwnerShopServiceSaveDTO;
import com.myshop.demo.entity.OwnerShopServicesRelation;
import com.myshop.demo.service.OwnerShopService;

@RestController
@RequestMapping(value = "/ossController")
public class OwnerShopServiceController {
	
	@Autowired
	OwnerShopService oSer;

	@PostMapping(value = "/saveOwnerShopService")
	public HashMap<String, Object> saveOwnerShopService(@RequestBody OwnerShopServiceSaveDTO dto) {
		for (int i = 0; i < dto.getServiceAmount().size(); i++) {
			OwnerShopServicesRelation entity = new OwnerShopServicesRelation();
			entity.setOwnerId(dto.getOwnerId());
			entity.setShopId(dto.getShopId());
			entity.setAmount(dto.getServiceAmount().get(i).getAmount());
			entity.setServiceId(dto.getServiceAmount().get(i).getServiceId());
			entity.setCreatedAt(new Date());
			entity.setStatus("true");
			
			 oSer.saveOwnerShopService(entity);
		}
		
		return null;
	}
}
