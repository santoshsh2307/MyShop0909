package com.myshop.demo.controller;

import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.entity.EmployeeShopOwnerRelation;
import com.myshop.demo.service.ESORService;

@RestController
@RequestMapping(value = "/eSORController")
public class ESORController {
	
	@Autowired
	ESORService esorSer;
	
	//this api is to sace ESOR DATA
	
	@PostMapping(value = "/saveESOR")
	public HashMap<String, Object> saveESOR(@RequestBody EmployeeShopOwnerRelation esor ) {
		EmployeeShopOwnerRelation data = esorSer.saveESOR(esor);
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

	@GetMapping(value = "/getESORById")
	public HashMap<String, Object> getESORById(Long id) {
		 Optional<EmployeeShopOwnerRelation> data =esorSer.findESORById(id);
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


	 @GetMapping(value ="/getAllEsor")
	public HashMap<String,Object>getAllEsor(){
     List<EmployeeShopOwnerRelation> esordata=esorSer.findAll();
    HashMap<String,Object> map= new HashMap<>();
    if (esordata!=null) {
		map.put("code", "200");
		map.put("content", esordata);
	} else {
		map.put("code", "201");
		map.put("content", "no data");
		
	}
	return map;

}
	 @GetMapping(value = "/getShopByEmpId/{id}")
	 public HashMap<String, Object> getShopByEmpId(@PathVariable ("id")Long id) {
		List<EmployeeShopOwnerRelation> data = esorSer.getShopByEmpId(id);
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