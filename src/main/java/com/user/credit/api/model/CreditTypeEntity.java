package com.user.credit.api.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "creditType")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CreditTypeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3391320560844594871L;

	/**
	 * id : to store id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * type : to store credit type
	 */
	private String type;

	private UserCreditEntity credit;

	public CreditTypeEntity() {
	}

	public CreditTypeEntity(Long id, String type) {
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserCreditEntity getCredit() {
		return credit;
	}

	public void setCredit(UserCreditEntity credit) {
		this.credit = credit;
	}

}
