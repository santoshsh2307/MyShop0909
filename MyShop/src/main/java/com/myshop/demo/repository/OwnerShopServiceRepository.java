package com.myshop.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.OwnerShopServicesRelation;

@Repository
public interface OwnerShopServiceRepository extends JpaRepository<OwnerShopServicesRelation, Long>{

	@Query(value = "SELECT osr.amount FROM owner_shop_service_relation AS osr WHERE osr.owner_id=?1 AND osr.service_id=?2 AND osr.shop_id=?3 ",nativeQuery = true)
	Float findByOwnerIdAndShopIdAndServiceId(Long ownerId, Long shopId, Long serviceId);


}
