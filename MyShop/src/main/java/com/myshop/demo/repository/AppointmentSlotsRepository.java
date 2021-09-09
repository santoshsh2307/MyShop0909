package com.myshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.AppointmentSlots;
@Repository
public interface AppointmentSlotsRepository extends JpaRepository<AppointmentSlots,Long>{

}