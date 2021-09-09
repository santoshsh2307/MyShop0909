package com.myshop.demo.controller;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.demo.DTO.ApponimentShopAvailalbilityDTO;
import com.myshop.demo.entity.Appointments;
import com.myshop.demo.entity.ShopAvailablity;
import com.myshop.demo.service.AppointmentService;
import com.myshop.demo.service.ShopAvailabilityService;
import com.myshop.demo.util.DateConversion;

@RestController
@RequestMapping(value = "/shopAvailablityController")
public class ShopAvailablityController {

	@Autowired
	ShopAvailabilityService saSer;

	@Autowired
	AppointmentService appService;

	@PostMapping(value = "/saveShopAvailability")
	public HashMap<String, Object> saveShopAvailability(@RequestBody ApponimentShopAvailalbilityDTO sa) {
		ShopAvailablity sha = new ShopAvailablity();
		if (sa.getShopId() != null) {
			sha.setCreatedDate(new Date());
			sha.setFromDate(DateConversion.StringToDateConversionDBFields(sa.getFromDate()));
			sha.setToDate(DateConversion.StringToDateConversionDBFields(sa.getToDate()));
			sha.setLoginTime(sa.getLoginTime());
			sha.setLogoutTime(sa.getLogoutTime());
			sha.setShopId(sa.getShopId());
			sha.setStatus(true);
			ShopAvailablity data = saSer.saveShopAvailability(sha);

		}

		// add appointment time and date to app table
		Date fromDate = DateConversion.StringToDateConversionDBFields(sa.getFromDate());
		Date toDate = DateConversion.StringToDateConversionDBFields(sa.getToDate());
		while (!fromDate.after(toDate)) {
			LocalTime from = LocalTime.parse(sa.getLoginTime().toString());
			LocalTime to = LocalTime.parse(sa.getLogoutTime().toString());
			while (!from.isAfter(to)) {
				// System.out.println(from);
				for (int i = 0; i < sa.getNoOfSheet(); i++) {
					Appointments app = new Appointments();
					app.setAppDate(fromDate);
					app.setAppTime(from);
					app.setBookingStatusId(1l);
					if (sha.getShopId() == null) {
						app.setShopId(sa.getShopId());
					} else {
						app.setShopId(sha.getShopId());
					}
					app.setStatus(true);

					appService.saveAppointment(app);
				}
				from = from.plusMinutes(30);
			}

			long ltime = fromDate.getTime() + 1 * 24 * 60 * 60 * 1000;
			fromDate = new Date(ltime);
		}
		// end adding appointment to table
		HashMap<String, Object> map = new HashMap<>();
		if (sa.getShopId() != null) {
			map.put("code", "200");
			map.put("content", "success");
		} else {
			map.put("code", "201");
			map.put("content", "201");

		}
		return map;

	}

	@GetMapping(value = "/getShopAvailableById")
	public HashMap<String, Object> getShopAvailableById(Long id) {
		ShopAvailablity data = saSer.findShopAvailableById(id);
		HashMap<String, Object> map = new HashMap<>();
		if (data != null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "201");

		}
		return map;

	}

	@GetMapping(value = "/getAllShopAvailablity")
	public HashMap<String, Object> getAllShopAvailablity() {
		List<ShopAvailablity> shopdata = saSer.findAll();
		HashMap<String, Object> map = new HashMap<>();
		if (shopdata != null) {
			map.put("code", "200");
			map.put("content", shopdata);
		} else {
			map.put("code", "201");
			map.put("content", "noshopdata");

		}

		return map;
	}
}
