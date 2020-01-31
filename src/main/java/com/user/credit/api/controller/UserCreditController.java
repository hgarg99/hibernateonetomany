package com.user.credit.api.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.user.credit.api.model.CreditTypeEntity;
import com.user.credit.api.model.UserCreditEntity;
import com.user.credit.api.repository.CreditTypeRepository;
import com.user.credit.api.repository.UserCreditRepository;
import com.user.credit.api.repository.UserRepository;

@RestController
@RequestMapping(value = { "/api" })
public class UserCreditController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserCreditRepository userCreditRepository;

	@Autowired
	private CreditTypeRepository creditTypeRepository;

	/**
	 * Method to create user credit
	 * 
	 * @param userid
	 * @param userEntity
	 * @return
	 */
	@PostMapping("/user/{userid}/{type}/usercredit")
	@ResponseBody
	public ResponseEntity<UserCreditEntity> createUserCredit(@PathVariable Long userid, @PathVariable String type,
			@Valid @RequestBody UserCreditEntity userEntity) {
		ResponseEntity<UserCreditEntity> responseEntity = null;
		try {
			if (isCreditTypeExists(type)) {
				UserCreditEntity usrCrdtEntity = isUserHaveCreditType(userid, type);
				if (usrCrdtEntity == null) {
					userRepository.findById(userid).map(user -> {
						userEntity.setUser(user);
						userEntity.setCredtype(creditTypeRepository.findByTypeEquals(type));
						return new ResponseEntity<>(userCreditRepository.save(userEntity), HttpStatus.CREATED);
					});
				} else {
					// update exist one
					userRepository.findById(userid).map(user -> {
						Long creditUsed = usrCrdtEntity.getCreditUsed() + userEntity.getCreditUsed();
						Long totalcredit = usrCrdtEntity.getTotalCredit() - creditUsed;
						Long id = usrCrdtEntity.getId();
						System.out.println("@@@"+creditUsed + "  " + totalcredit + "  " + id);
						return new ResponseEntity<>(
								userCreditRepository.updateUserCreditEntityById(creditUsed, totalcredit, id),
								HttpStatus.OK);
					});
				}
			} else {
				responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	/**
	 * Method to check given user have credit_type or not.
	 * 
	 * @param userId
	 * @param type
	 * @return
	 */
	private UserCreditEntity isUserHaveCreditType(Long userId, String type) {
		List<UserCreditEntity> userCreditEntityList = userCreditRepository.findByUserId(userId);
		UserCreditEntity userCredit = userCreditEntityList.stream()
				.filter(userCreditEntity -> userCreditEntity.getCredtype().getType().equals(type)).findAny()
				.orElse(null);
		return userCredit;
	}

	/**
	 * Method to check given type is exist or not in database
	 * 
	 * @param type
	 * @return isCreditType
	 */
	private boolean isCreditTypeExists(String type) {
		boolean isCreditType = false;
		CreditTypeEntity creditTypeEntity = creditTypeRepository.findByTypeEquals(type);
		if (creditTypeEntity != null) {
			isCreditType = true;
		} else {
			isCreditType = false;
		}
		return isCreditType;
	}
}
