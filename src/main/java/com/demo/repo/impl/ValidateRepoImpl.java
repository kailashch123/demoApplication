package com.demo.repo.impl;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.User;
import com.demo.repo.inf.validateRepoImpl;
import com.demo.util.CRUDUtil;

@Service
public class ValidateRepoImpl implements validateRepoImpl{
	
	@Autowired
	CRUDUtil crud;
	@Override
	public String login(User user) {
		// TODO Auto-generated method stub
		String res = crud.getUser(user);
		return res;
	}

	@Override
	public String create(User user) {
		// TODO Auto-generated method stub
		String response = crud.createUser(user);
		return response;
	}


	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		String res = crud.updateUser(user);
		return res;
	}

	@Override
	public String delete(User user) {
		// TODO Auto-generated method stub
		String res = crud.deleteUser(user);
		return res;
	}

}
	