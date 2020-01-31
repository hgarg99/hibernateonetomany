package com.user.credit.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.user.credit.api.model.UserCreditEntity;
import com.user.credit.common.QueryConstants;

/**
 * 
 * @author Hariom
 *
 */
public interface UserCreditRepository extends JpaRepository<UserCreditEntity, Long> {

	/**
	 * Method to find usercredit by userid
	 * 
	 * @param studentId
	 * @return
	 */
	List<UserCreditEntity> findByUserId(Long userId);

	@Modifying
	@Transactional
	@Query(value = QueryConstants.UPDATE_USERCREDIT)
	int updateUserCreditEntityById(@Param("creditUsed") Long usedCredit, @Param("totalCredit") Long totalCredit,
			@Param("id") Long id);
}
