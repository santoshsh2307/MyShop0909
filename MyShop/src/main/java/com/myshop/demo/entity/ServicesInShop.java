package com.myshop.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "services_in_shop")
public class ServicesInShop {
	private Long id;
	private String serviceName;
	private Boolean status;
	
	public ServicesInShop() {
		super();
	}

	public ServicesInShop(Long id, String serviceName,Boolean status) {
		super();
		this.id = id;
		this.setServiceName(serviceName);
		this.setStatus(status);
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

	@Column(name = "swervice_name")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	

}
