package com.myshop.demo.serviceImpl;

import java.util.Date;
import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.demo.entity.Appointments;
import com.myshop.demo.repository.AppointmentRepository;
import com.myshop.demo.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository appRepo;

	@Transactional
	public Appointments saveAppointment(Appointments a) {
		//a.setCreatedDate(new Date());
		//a.setBookingStatusId(9l);
		//a.setStatus(true);
		// TODO Auto-generated method stub
		Appointments data = appRepo.save(a);
		return data;
	}

	@Transactional
	public Optional<Appointments> findAppointmentById(Long id) {
		// TODO Auto-generated method stub
		Optional<Appointments> data = appRepo.findById(id);
		
		return data;
	}
	public List<Appointments> findAll() {
		// TODO Auto-generated method stub
	
		return appRepo.findAll();
	}

	@Transactional
	public List<Appointments> findAppByAppDate(Date appDate) {
		List<Appointments> data = appRepo.findByAppDate(appDate);
		// TODO Auto-generated method stub
		return data;
	}

	@Transactional
	public Appointments findAppByUserId(Long id) {
		// TODO Auto-generated method stub
		Appointments data = appRepo.findAppByUserId(id);
		return data;
	}

}
