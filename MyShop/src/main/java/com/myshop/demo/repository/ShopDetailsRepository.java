package com.myshop.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.ShopDetails;

@Repository
public interface ShopDetailsRepository extends JpaRepository<ShopDetails, Long>{

	ShopDetails findShopById(Long id);

	List<ShopDetails> findByShopName(String shopName);


	Optional<ShopDetails> findByAddress(String add);


}
