package com.myshop.demo.DTO;

import java.util.Date;
import java.util.List;

public class OwnerShopServiceSaveDTO {
	private Long id;
	private Long ownerId;
	private Long ShopId;
	private List<ServiceAmountDTO> serviceAmount;
	private Date createdAt;
	private String status;
	
	
	public OwnerShopServiceSaveDTO() {
		super();
	}
	public OwnerShopServiceSaveDTO(Long id, Long ownerId, Long shopId, List<ServiceAmountDTO> serviceAmount,
			Date createdAt, String status) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		ShopId = shopId;
		this.serviceAmount = serviceAmount;
		this.createdAt = createdAt;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getShopId() {
		return ShopId;
	}
	public void setShopId(Long shopId) {
		ShopId = shopId;
	}
	public List<ServiceAmountDTO> getServiceAmount() {
		return serviceAmount;
	}
	public void setServiceAmount(List<ServiceAmountDTO> serviceAmount) {
		this.serviceAmount = serviceAmount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
