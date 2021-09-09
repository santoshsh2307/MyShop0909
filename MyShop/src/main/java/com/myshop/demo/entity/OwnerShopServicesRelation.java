package com.myshop.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerators;

@Entity
@Table(name = "owner_shop_service_relation")
public class OwnerShopServicesRelation {
	private Long id;
	private Long ownerId;
	private Long shopId;
	private Long serviceId;
	private Date createdAt;
	private Float amount;
	private String status;
	
	public OwnerShopServicesRelation() {
		super();
	}

	public OwnerShopServicesRelation(Long id, Long ownerId, Long shopId, Long serviceId, Date createdAt,
			Float amount, String status) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.shopId = shopId;
		this.serviceId = serviceId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "owner_id")
	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	@Column(name = "shop_id")
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	@Column(name = "service_id")
	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Column(name = "amount")
	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
