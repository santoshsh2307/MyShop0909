package com.myshop.demo.service;

import java.util.List;
import java.util.Optional;

import com.myshop.demo.entity.AppointmentSlots;

public interface AppointmentSlotsService {

	AppointmentSlots save(AppointmentSlots apps);

	List<AppointmentSlots> findAll();

	Optional<AppointmentSlots> findById(Long id);

}