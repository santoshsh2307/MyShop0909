package com.myshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.ShopAvailablity;

@Repository
public interface ShopAvailablityRepository extends JpaRepository<ShopAvailablity, Long>{



}
