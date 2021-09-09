package com.myshop.demo.DTO;

public class ServiceAmountDTO {

	
	private Long serviceId;
	private Float amount;
	
	public ServiceAmountDTO() {
		super();
	}
	public ServiceAmountDTO(Long serviceId, Float amount) {
		super();
		this.serviceId = serviceId;
		this.amount = amount;
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	
}
