package com.user.credit.api.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Hariom
 *
 */

@Entity
@Table(name = "userCredit")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserCreditEntity implements Serializable {

	private static final long serialVersionUID = 6817872576429554546L;

	/**
	 * id : to store id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * user : to store user
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private UserEntity user;

	/**
	 * creditType : to store credit type
	 */
	@ManyToOne
	@JoinColumn(name = "credit_type_id", nullable = false)
	@JsonIgnore
	private CreditTypeEntity credtype;

	/**
	 * creditUsed : to store credit used
	 */
	private Long creditUsed;

	/**
	 * creditAvailable : credit available
	 */
	@Transient
	private Long creditAvailable;

	/**
	 * totalCredit : to store totalCredit
	 */
	private Long totalCredit;

	/**
	 * constructor
	 * 
	 * @param creditType
	 * @param creditUsed
	 * @param creditAvailable
	 */
	public UserCreditEntity(Long creditUsed, Long creditAvailable, Long totalCredit) {
		super();
		this.creditUsed = creditUsed;
		this.creditAvailable = creditAvailable;
		this.totalCredit = totalCredit;
	}

	public UserCreditEntity() {
	}

	public Long getCreditId() {
		return id;
	}

	public void setCreditId(Long creditId) {
		this.id = creditId;
	}

	public Long getCreditUsed() {
		return creditUsed;
	}

	public void setCreditUsed(Long creditUsed) {
		this.creditUsed = creditUsed;
	}

	public Long getCreditAvailable() {
		return creditAvailable = this.totalCredit - this.creditUsed;
	}

	public void setCreditAvailable(Long creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity users) {
		this.user = users;
	}

	public Long getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Long totalCredit) {
		this.totalCredit = totalCredit;
	}

	public CreditTypeEntity getCredtype() {
		return credtype;
	}

	public void setCredtype(CreditTypeEntity credtype) {
		this.credtype = credtype;
	}

}
