package com.myshop.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.EmployeeShopOwnerRelation;
import com.myshop.demo.entity.ShopDetails;

@Repository
public interface EmployeeShopOwnerRelationRepository extends JpaRepository<EmployeeShopOwnerRelation, Long>{

	List<EmployeeShopOwnerRelation> findAllByEmpId(Long id);

}
