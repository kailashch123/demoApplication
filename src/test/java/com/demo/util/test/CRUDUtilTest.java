package com.demo.util.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.controller.AbstractTest;
import com.demo.model.User;
import com.demo.util.CRUDUtil;

@RunWith(SpringRunner.class)
public class CRUDUtilTest extends AbstractTest{
	@InjectMocks
	CRUDUtil crudUtil;
	
	List<User> userList = new ArrayList<User>(Arrays.asList(
			new User("001","a_fname","a_lname","pwd_1"),
			new User("002","b_fname","b_lname","pwd_2"),
			new User("003","c_fname","c_lname","pwd_3")
			));	
	
	@Test
	public void getUserTest( ){
		String expected = "User found";

		User user = new User("001","a_fname","a_lname","pwd_1");
		
		String response = crudUtil.getUser(user);
		
		
		assertEquals(expected, response);
			
		}
	
	@Test
	public void getUserTestFailure( ){
		String expected = "User found";

		User user = new User("005","a_fname","a_lname","pwd_1");
		
		String response = crudUtil.getUser(user);
		
		
		assertEquals(expected, response);
			
		}
	
	@Test
	public void createUserTest() {
		String expected = "User created";
		User user = new User("004","d_fname","d_lname","pwd_4");
		
		String response =  crudUtil.createUser(user);
		
		
		assertEquals(expected, response);				
	}
	
	@Test
	public void updateUserTest() {
		
		String expected = "User updated for the userID: 002";
		User user = new User("002","change_fname","b_lname","pwd_2");
		
		String response =  crudUtil.updateUser(user);
		
	
		assertEquals(expected, response);				
	}
	
	@Test
	public void deleteUser() {
		
		String expected = "User deleted for the userID: 003";
		User user = new User("003","c_fname","c_lname","pwd_3");
		
		String response =  crudUtil.deleteUser(user);
		
		
		
		assertEquals(expected, response);				
	
	}
}
