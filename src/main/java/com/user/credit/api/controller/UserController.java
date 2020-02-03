package com.user.credit.api.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.credit.api.model.CreditTypeEntity;
import com.user.credit.api.model.UserEntity;
import com.user.credit.api.repository.CreditTypeRepository;
import com.user.credit.api.repository.UserRepository;
import com.user.credit.common.Constants;
import com.user.credit.exception.NotFoundException;

@RestController
@RequestMapping(value = { "/api" })
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CreditTypeRepository creditTypeRepository;

	/**
	 * Method to get User by user id
	 * 
	 * '@param id'
	 * @return UserEntity
	 */
	@GetMapping("/user/{id}")
	public UserEntity getUserByID(@PathVariable Long id) {
		Optional<UserEntity> optUser = userRepository.findById(id);
		if (optUser.isPresent())  
			return optUser.get();
		} else {
			throw new NotFoundException(Constants.USER_NOT_FOUND + id);
		}
		
	}

	/**
	 * Method to create user
	 * 
	 * '@param userEntity'
	 * @return UserEntity
	 */
	@PostMapping("/createuser")
	public UserEntity createUser(@Valid @RequestBody UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	/**
	 * Method to create credit type
	 * 
	 * @paramtype
	 *
	 * @return CreditTypeEntity
	 */
	@PostMapping("/type")
	public CreditTypeEntity createType(@RequestBody CreditTypeEntity creditTypeEntity) {
		return creditTypeRepository.save(creditTypeEntity);
	}

}
