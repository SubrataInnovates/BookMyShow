package com.bookmyshow.service;

import javax.swing.event.AncestorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.bookmyshow.entity.User;
import com.bookmyshow.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository userRepository;
	@Override
	public String addUser(User user)
	{
		user= userRepository.save(user);
		
		
		
		
		
		
		return "User is saved to db "+user;
	}

}
