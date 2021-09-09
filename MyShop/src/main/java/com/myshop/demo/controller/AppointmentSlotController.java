package com.myshop.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.entity.AppointmentSlots;
import com.myshop.demo.service.AppointmentSlotsService;

@RestController
@RequestMapping(value= "/appointmentslot")
public class AppointmentSlotController {
	@Autowired
	AppointmentSlotsService appSer;
	
	
	@PostMapping(value= "saveAppointmentSlot")
	public HashMap<String,Object>saveAppointmentSlot(@RequestBody AppointmentSlots apps){
	AppointmentSlots saveDataApp=appSer.save(apps);
	HashMap<String,Object>map=new HashMap<>();
	if(saveDataApp!=null) {
		map.put("code", "200");
		map.put("content", saveDataApp);
	}else {
		map.put("code", "201");
		map.put("content", "nodata");
	}
	return map;
	}
	@GetMapping(value= "appSlotAll")
	public HashMap<String,Object>appSlotAll(){
	List<AppointmentSlots>findAppData=appSer.findAll();
	HashMap<String,Object>map=new HashMap<>();
	if(findAppData!=null) {
		map.put("code", "200");
		map.put("content", findAppData);
	}else {
		map.put("code", "201");
		map.put("content", "nodata");
	}
	return map;
	}
	@GetMapping(value= "/findByAppIdSlots")
   public HashMap<String,Object>findByAppIdSlots(Long id){
	   Optional<AppointmentSlots>findByIdData=appSer.findById(id);
	   HashMap<String,Object> map=new HashMap<>();
	   if(findByIdData!=null) {
		   map.put("code", "200");
		   map.put("content", findByIdData);
	   }else {
		   map.put("code", "201");
		   map.put("content", "nodata");
	   }
	   return map;
	   }
	@PutMapping(value= "updateAppointmentSlot")
	public HashMap<String,Object>updateAppointmentSlot(@RequestBody AppointmentSlots apps){
	AppointmentSlots updateDataApp=appSer.save(apps);
	HashMap<String,Object>map=new HashMap<>();
	if(updateDataApp!=null) {
		map.put("code", "200");
		map.put("content", updateDataApp);
	}else {
		map.put("code", "201");
		map.put("content", "nodata");
	}
	return map;
   }
}