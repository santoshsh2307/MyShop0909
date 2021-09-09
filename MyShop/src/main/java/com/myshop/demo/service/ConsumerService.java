package com.myshop.demo.service;

import java.util.List;
import java.util.Optional;

import com.myshop.demo.entity.Consumers;
import com.myshop.demo.entity.Users;

public interface ConsumerService {


	Consumers saveConsumers(Consumers c);

	Optional<Consumers> getConsumerById(Long id);

	Optional<Consumers> getConsumerByPhone(String phone);

	List<Consumers> getConsumerByAddress(String add);

	Optional<Consumers> getConsumerByPhoneAndPassword(String phone, String psw);


	Consumers getConsumerByUserName(String userName);

	List<Object> getAppointmentsBasedOnStatus(Long consumerId,  Long statusId);




}
