package com.myshop.demo.controller;

import java.util.Date;
import java.util.HashMap;

import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.entity.Appointments;
import com.myshop.demo.service.AppointmentService;

@RestController
@RequestMapping(value = "/appointmentsController")
public class AppointmentsController {
	
	@Autowired
	AppointmentService apSer;
	
	//this APi is to save / create new appointment 
	
	@PostMapping(value = "/saveAppointment")
	public HashMap<String, Object> saveAppointment(@RequestBody Appointments a) {
		 Appointments data =apSer.saveAppointment(a);
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
	@GetMapping(value = "/getAppointById")
	public HashMap<String, Object> getAppointById( Long id) {
		Optional<Appointments> data = apSer.findAppointmentById(id);
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
	
  @GetMapping(value = "/getAllAppointment")
  public  HashMap<String, Object> getAllAppointment(){
	  List<Appointments>appointmentdata=apSer.findAll();
	HashMap<String,Object> map= new HashMap<>();
	if (appointmentdata!=null) {
		map.put("code", "200");
		map.put("content", appointmentdata);
	} else {
		map.put("code", "201");
		map.put("content", "no data");
		
	}
	return map;
  }

  @GetMapping(value = "/getAppByAppData/{date}")
  public HashMap<String, Object> getAppByAppData(@PathVariable ("date") String addDate) {
	  List<Appointments> data = apSer.findAppByAppDate(new Date(addDate));
	  HashMap<String,Object> map= new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
		}
		return map;
	
}
  @GetMapping(value = "/getAppByUserId/{id}")
  public HashMap<String, Object> getAppByUserId(@PathVariable("id") Long id) {
	 Appointments data= apSer.findAppByUserId(id);
	 HashMap<String,Object> map= new HashMap<>();
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
