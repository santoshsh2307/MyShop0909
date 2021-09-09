package com.myshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	Users findByPhone(String phone);

	Users findByUserName(String userName);

	Users findByPhoneAndPassword(String phone, String password);

	Users findByUserNameAndPassword(String userName, String password);
	
	Users findByPhoneAndOtp(String phone, String otp);
	
	
	@Query(value = "SELECT count(*) FROM appointment_slots AS asl WHERE asl.owner_id=?1 AND asl.shop_id=?2 ",nativeQuery = true)
	Long getTotalCustomer(Long ownerId, Long shopId, Long bookingStatus);
	
	@Query(value = "SELECT count(*) FROM appointment_slots AS asl JOIN appointment AS app ON app.id = asl.slot_id WHERE asl.owner_id=?1 AND asl.shop_id=?2 AND app.app_date=?3 ",nativeQuery = true)
	Long getTotalCustomerOfDay(Long ownerId, Long shopId, String date);
	
	
	@Query(value = "SELECT count(*) FROM appointment_slots AS asl JOIN appointment AS app ON app.id = asl.slot_id WHERE asl.owner_id=?1 AND asl.shop_id=?2 AND app.app_date=?3 AND app.booking_status_id=?4 ",nativeQuery = true)
	Long getTotalCustomerOfDay(Long ownerId, Long shopId, String date, Long bookingStatusId);

	@Query(value = "SELECT sum(osr.service_amount) FROM appointment_slots AS osr WHERE osr.owner_id=?1 AND osr.shop_id=?2 ",nativeQuery = true)
	Float getTotalEarn(Long ownerId, Long shopId);
	
	

}
