package com.user.credit.api.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Hariom
 *
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7912113764622830449L;

	/**
	 * id : to store id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * userCredit : to store userCredit
	 */

	@OneToMany(mappedBy = "user")
	private Set<UserCreditEntity> userCredit;

	/**
	 * firstName : to store firstName
	 */
	private String firstName;

	/**
	 * lastName : to store lastName
	 */
	private String lastName;

	public UserEntity() {

	}

	public UserEntity(Long userId, String userFirstName, String userLastName) {
		super();
		this.id = userId;
		this.firstName = userFirstName;
		this.lastName = userLastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<UserCreditEntity> getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(Set<UserCreditEntity> userCredit) {
		this.userCredit = userCredit;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
