package com.myshop.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.Appointments;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long>{

	List<Appointments> findByAppDate(Date appDate);

	Appointments findAppByUserId(Long id);


}
