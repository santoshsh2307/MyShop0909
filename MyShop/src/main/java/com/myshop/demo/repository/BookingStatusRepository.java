package com.myshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.BookingStatus;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long>{

}
