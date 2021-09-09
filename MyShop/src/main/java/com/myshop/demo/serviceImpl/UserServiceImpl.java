package com.myshop.demo.serviceImpl;

import java.util.Date;
import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.demo.DAO.AppointmentSlotForOwnerDAO;
import com.myshop.demo.DAO.TestDao;
import com.myshop.demo.entity.ShopDetails;
import com.myshop.demo.entity.Users;
import com.myshop.demo.repository.UsersRepository;
import com.myshop.demo.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {
	
	@Autowired
	UsersRepository uRepo;
	
	@Autowired
	TestDao dao;
	
	@Autowired
	AppointmentSlotForOwnerDAO appDAO;

	@Transactional
	public Users saveUsers(Users u) {
		// TODO Auto-generated method stub 
		u.setCreatedAt(new Date());
		u.setStatus(true);
		Users data = uRepo.save(u);
		
		return data;
	}

	@Transactional
	public Users findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Users> data = uRepo.findById(id);
		return data.get();
	}

	@Transactional
	public Users findByPhone(String phone) {
		Users data = uRepo.findByPhone(phone);
		// TODO Auto-generated method stub
		return data;
	}

	@Transactional
	public Users findUsersByUserName(String userName) {
		// TODO Auto-generated method stub
		Users data = uRepo.findByUserName(userName);
		return data;
	}

	@Transactional
	public Users getUserByPhoneNoAndPassword(String phone, String password) {
		// TODO Auto-generated method stub
		Users data = uRepo.findByPhoneAndPassword(phone,password);
		return data;
	}

	@Transactional
	public Users getUserByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		Users data = uRepo.findByUserNameAndPassword(userName,password);
		return data;
	}
		
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return uRepo.findAll();
	}

	@Transactional
	public Users getUserByPhoneAndOTP(String phone, String otp) {
		// TODO Auto-generated method stub
		 Users data = uRepo.findByPhoneAndOtp(phone,otp);
		return data;
	}

	@Transactional
	public Object getUserCompleteProfile(Long id,Long spId) {
		// TODO Auto-generated method stub
		return dao.getCustomerProfileByUserId(id,spId);
	}

	@Transactional
	public List<Object> getAppointmentsBasedOnStatus(Long ownerId, Long shopId, Long bookingStatus) {
		// TODO Auto-generated method stub
		return appDAO.getAppointmentsBasedOnStatus(ownerId,shopId,bookingStatus);
	}

	@Transactional
	public Long getTotalCustomer(Long ownerId, Long shopId, Long bookingStatus) {
		// TODO Auto-generated method stub
	 Long totalCustome =	uRepo.getTotalCustomer(ownerId,shopId,bookingStatus);
		return totalCustome;
	}

	@Transactional
	public Long getTotalCustomerOfDay(Long ownerId, Long shopId, String date) {
		// TODO Auto-generated method stub
		return uRepo.getTotalCustomerOfDay(ownerId,shopId,date);
	}

	@Transactional
	public Long getTotalCustomerOfDay(Long ownerId, Long shopId, String date, Long bookingStatusId) {
		// TODO Auto-generated method stub
		return uRepo.getTotalCustomerOfDay(ownerId,shopId,date,bookingStatusId);

	}

	@Transactional
	public Float getTotalEarn(Long ownerId, Long shopId) {
		// TODO Auto-generated method stub
		return uRepo.getTotalEarn(ownerId,shopId);
	}

	@Transactional
	public Object getOwnerDeatailByShopId(Long shopId) {
		// TODO Auto-generated method stub
		return dao.getOwnerDeatailByShopId(shopId);
	}

	@Transactional
	public Object getShopDeatailByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		List data = dao.getShopDeatailByOwnerId(ownerId);
		return data;
	}

}
