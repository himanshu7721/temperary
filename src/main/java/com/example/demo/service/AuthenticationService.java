package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginModel;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class AuthenticationService {
	@Autowired
	UserRepository userrepo;
	
	public User addnewuser(User user)
	{
		return userrepo.save(user);
	}

	public User loginUser(LoginModel loginmodel) {
		User user=userrepo.findByEmail(loginmodel.getEmail());
		if(user.getPassword().equals(loginmodel.getPassword()))
		return user;
		else
		{
			return null;
		}
	}
}
