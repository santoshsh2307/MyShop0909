package com.myshop.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.Consumers;
import com.myshop.demo.entity.Users;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumers, Long> {

	Optional<Consumers> findByPhone(String phone);

	List<Consumers> findByAddress(String add);

	Optional<Consumers> findByPhoneAndPassword(String phone, String psw);

	Consumers findByUserName(String userName);



}
