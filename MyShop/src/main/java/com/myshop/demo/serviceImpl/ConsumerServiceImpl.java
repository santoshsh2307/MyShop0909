package com.myshop.demo.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.demo.DAO.AppointmentSlotForConsumer;
import com.myshop.demo.DAO.AppointmentSlotForOwnerDAO;
import com.myshop.demo.entity.Consumers;
import com.myshop.demo.repository.ConsumerRepository;
import com.myshop.demo.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	 
	@Autowired
	ConsumerRepository cRepo;
	
	@Autowired
	AppointmentSlotForConsumer appDAO;

	@Transactional
	public Consumers saveConsumers(Consumers c) { 
		// TODO Auto-generated method stub
		c.setCreatedAt(new Date());
		c.setStatus(true);
		 Consumers data= cRepo.save(c);
		 
		
		return data;
	}

	@Transactional
	public Optional<Consumers> getConsumerById(Long id) {
		// TODO Auto-generated method stub
		return cRepo.findById(id);

	}

	@Transactional
	public Optional<Consumers> getConsumerByPhone(String phone) {
		// TODO Auto-generated method stub
		return cRepo.findByPhone(phone);
	}

	@Transactional
	public List<Consumers> getConsumerByAddress(String add) {
		// TODO Auto-generated method stub
		List<Consumers> data = cRepo.findByAddress(add);
		return data;
	}

	@Transactional
	public Optional<Consumers> getConsumerByPhoneAndPassword(String phone, String psw) {
		// TODO Auto-generated method stub
		return cRepo.findByPhoneAndPassword(phone,psw);
	}

	@Transactional
	public Consumers getConsumerByUserName(String userName) {
		// TODO Auto-generated method stub
		return cRepo.findByUserName(userName);
	}

	@Transactional
	public List<Object> getAppointmentsBasedOnStatus(Long consumerId,  Long statusId) {
		// TODO Auto-generated method stub
		return appDAO.getAppointmentBasedOnStatus(consumerId,statusId);
	}

}
