package com.bookmyshow.controller;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.entity.User;
import com.bookmyshow.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user)
	{
		try 
		{
			   String addUser = userService.addUser(user);
			  logger.error("User is added in db : {}", addUser);
			  return new ResponseEntity<>(addUser,HttpStatus.OK);
		}
		catch (Exception e)
		{
			logger.error("Error occurred while adding user: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
