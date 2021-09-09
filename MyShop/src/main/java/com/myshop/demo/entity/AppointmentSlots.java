package com.myshop.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "appointment_slots")

public class AppointmentSlots {
	
	private Long id;
	private String appointType;
	private Long customerId;
	private Long shopId;
	private Long slotId;
	private Long ownerId;
	private Long serviceId;
	private Float serviceAmount;
	private Boolean status;
	private Date createdAt;
	public AppointmentSlots() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentSlots(Long id, String appointType, Long customerId, Long shopId, Long slotId, Long ownerId,
			Boolean status, Date createdAt) {
		super();
		this.id = id;
		this.appointType = appointType;
		this.customerId = customerId;
		this.shopId = shopId;
		this.slotId = slotId;
		this.ownerId = ownerId;
		this.status = status;
		this.createdAt = createdAt;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name= "appoint_type")
	public String getAppointType() {
		return appointType;
	}
	public void setAppointType(String appointType) {
		this.appointType = appointType;
	}
	@Column(name= "customer_id")
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	@Column(name= "shop_id")
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	@Column(name= "slot_id")
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	@Column(name= "owner_id")
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	@Column(name= "status")
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Column(name= "create_at")
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Column(name= "service_id")
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	@Column(name= "service_amount")
	public Float getServiceAmount() {
		return serviceAmount;
	}
	public void setServiceAmount(Float serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

}

