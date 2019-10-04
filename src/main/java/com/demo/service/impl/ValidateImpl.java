package com.demo.service.impl;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.demo.model.User;
import com.demo.repo.inf.validateRepoImpl;
import com.demo.service.inf.ValidateInterface;

@Service
public class ValidateImpl implements ValidateInterface{
	
	@Autowired
	validateRepoImpl ValidateRepoInf; 

	@Override
	public String login(User user) {
		// TODO Auto-generated method stub
		String res = ValidateRepoInf.login(user);
		return res;
	}

	@Override
	public String create(User user) {
		// TODO Auto-generated method stub
		String response = ValidateRepoInf.create(user);
		
		return response;
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		String response = ValidateRepoInf.update(user);
		
		return response;
	}

	
	@Override
	public String delete(User user) {
		// TODO Auto-generated method stub
		String res = ValidateRepoInf.delete(user);
		return res;
	}

	
}
