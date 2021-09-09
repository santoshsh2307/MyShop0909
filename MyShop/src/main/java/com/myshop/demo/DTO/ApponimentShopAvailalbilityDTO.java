package com.myshop.demo.DTO;

import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

public class ApponimentShopAvailalbilityDTO {

	private Long AppointmentId;
	private Long shopId;
	private LocalTime appTime;
	private String appDate;
	private String createdDate;
	private Long bookingStatusId;
	private Boolean status;
	private Long userId;
	
	private Long id;
	private LocalTime loginTime;
	private LocalTime logoutTime;
	private String fromDate;
	private String toDate;
	
	private Long noOfSheet;
	
	public Long getAppointmentId() {
		return AppointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		AppointmentId = appointmentId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public LocalTime getAppTime() {
		return appTime;
	}
	public void setAppTime(LocalTime appTime) {
		this.appTime = appTime;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Long getBookingStatusId() {
		return bookingStatusId;
	}
	public void setBookingStatusId(Long bookingStatusId) {
		this.bookingStatusId = bookingStatusId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalTime getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(LocalTime loginTime) {
		this.loginTime = loginTime;
	}
	public LocalTime getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(LocalTime logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public Long getNoOfSheet() {
		return noOfSheet;
	}
	public void setNoOfSheet(Long noOfSheet) {
		this.noOfSheet = noOfSheet;
	}
	
	
	
	
}
