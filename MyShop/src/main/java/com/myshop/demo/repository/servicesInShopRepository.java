package com.myshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.ServicesInShop;

@Repository
public interface servicesInShopRepository extends JpaRepository<ServicesInShop, Long> {

}
