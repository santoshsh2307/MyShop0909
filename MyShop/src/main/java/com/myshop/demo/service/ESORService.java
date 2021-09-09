package com.myshop.demo.service;


import java.util.Optional;
import java.util.List;

import com.myshop.demo.entity.EmployeeShopOwnerRelation;

public interface ESORService {

	EmployeeShopOwnerRelation saveESOR(EmployeeShopOwnerRelation esor);

	Optional<EmployeeShopOwnerRelation> findESORById(Long id);
	List<EmployeeShopOwnerRelation> findAll();

	List<EmployeeShopOwnerRelation> getShopByEmpId(Long id);

}
