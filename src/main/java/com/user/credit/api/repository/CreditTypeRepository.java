package com.user.credit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.credit.api.model.CreditTypeEntity;

public interface CreditTypeRepository extends JpaRepository<CreditTypeEntity, Long> {

	CreditTypeEntity findByTypeEquals(String type);
}
