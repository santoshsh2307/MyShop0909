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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.entity.Consumers;
import com.myshop.demo.entity.Users;
import com.myshop.demo.service.ConsumerService;

@RestController
@RequestMapping(value = "consumerConroller")
public class ConsumersController {
	
	@Autowired
	ConsumerService cSer;
	
	@PostMapping(value = "/saveConsumers")
	public HashMap<String, Object> saveConsumers(@RequestBody Consumers c) {
		 Optional<Consumers> phPresent = cSer.getConsumerByPhone(c.getPhone());
		 HashMap<String, Object> map = new HashMap<>();
		 if (phPresent.isPresent()) {
			 map.put("2001", "phone no is already exist");
			
		} else {
			Consumers data = cSer.saveConsumers(c);
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
	
	@GetMapping(value = "/getConsumerById")
	public HashMap<String, Object> getConsumerById(Long id) {
		 Optional<Consumers> data  = cSer.getConsumerById(id);
		 HashMap<String, Object> map = new HashMap<>();
			if (data.isPresent()) {
				map.put("code", "200");
				map.put("content", data);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
				
			}
			return map;
	}
	@GetMapping(value = "/getConsumerByPhone/{phone}")
	public HashMap<String, Object> getConsumerByPhone(@PathVariable("phone") String phone) {
		Optional<Consumers> data = cSer.getConsumerByPhone(phone);
		HashMap<String, Object> map = new HashMap<>();
		if (data.isPresent()) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
		}
		return map;
		
	}
	@GetMapping(value = "/getConsumerByAddress/{address}")
	public HashMap<String , Object> getConsumerByAddress(@PathVariable("address") String add) {
	 List<Consumers> data =	cSer.getConsumerByAddress(add);
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
	@PostMapping(value = "/getConsumerByPhoneAndPassword")
	public HashMap<String, Object> getConsumerByPhoneAndPassword(String phone, String psw) {
		Optional<Consumers> data = cSer.getConsumerByPhoneAndPassword(phone,psw);
		 HashMap<String, Object> map = new HashMap<>();
			if (data.isPresent()) {
				map.put("code", "200");
				map.put("content", data);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
				
			}
			return map;
		
	}
	@GetMapping(value = "/getConsumerByUserName/{name}")
	public HashMap<String, Object> getConsumerByUserName(@PathVariable ("name") String userName) {
		 Consumers data = cSer.getConsumerByUserName(userName);
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
	@RequestMapping(value = "/getAppointmentsBasedOnStatus",method = RequestMethod.GET)
	public HashMap<String, Object> getAppointmentsBasedOnStatus(Long consumerId, Long statusId) {
		List<Object> aapData = cSer.getAppointmentsBasedOnStatus(consumerId,statusId);
		 HashMap<String, Object> map = new HashMap<>();
			if (aapData!=null) {
				map.put("code", "200");
				map.put("content", aapData);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
				
				
			}
			return map;
		
		
	}

}