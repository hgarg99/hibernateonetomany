package com.user.credit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.credit.api.model.UserEntity;

/**
 * 
 * @author Hariom
 *
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
