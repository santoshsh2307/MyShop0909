package com.myshop.demo.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointments {

	private Long id;
	private Long shopId;
	private LocalTime appTime;
	private Date appDate;
	private Date createdDate;
	private Long bookingStatusId;
	private Boolean status;
	private Long userId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "shop_id")
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	@Column(name = "app_time")
	public LocalTime getAppTime() {
		return appTime;
	}
	public void setAppTime(LocalTime appTime) {
		this.appTime = appTime;
	}
	
	@Column(name = "app_date")
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "booking_status_id")
	public Long getBookingStatusId() {
		return bookingStatusId;
	}
	public void setBookingStatusId(Long bookingStatusId) {
		this.bookingStatusId = bookingStatusId;
	}
	
	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
