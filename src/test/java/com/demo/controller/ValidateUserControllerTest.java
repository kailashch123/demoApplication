package com.demo.controller;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import com.demo.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.service.impl.ValidateImpl;

@RunWith(SpringRunner.class)
public class ValidateUserControllerTest extends AbstractTest {
	
	@InjectMocks
	ValidateUserController valUserCont;
	
	@Mock
	ValidateImpl validateImpl;

	@Before
	@Override
	public void setUp() {
		super.setUp();
	}
	
	
	@Test
	public void loginTest() throws Exception{
		
		User user = new User("001","a_fname","a_lname","pwd_1");
				
		when(validateImpl.login(user)).thenReturn("User found with user Id: " +user.getUserId());
		String response = valUserCont.login(user);
		String expected = "User found with user Id: 001";
		assertEquals(expected, response);
		
	}
	
	
	
	@Test
	public void createTest() {
		String Response = "User created";
		User user = new User("004","d_fname","d_lname","pwd_4");
		
		when(validateImpl.create(user)).thenReturn(Response);
		ResponseEntity<String> response = valUserCont.create(user);
		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
	}
	
	@Test
	public void createTestFailure() {
		User user = new User("", "", "", "");	
		
		when(validateImpl.create(user)).thenReturn(null);
		ResponseEntity<String> response = valUserCont.create(user);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatusCodeValue());
	}
	
	@Test
	public void updateTest() throws Exception {
		
		/*
		 * String uri = "validate/update";
		 * 
		 * MvcResult mvcResult =
		 * mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.
		 * APPLICATION_JSON_VALUE)).andReturn();
		 * 
		 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
		 */
		 
		
		
		
		  String Response = "User updated for the userID: 002"; User user = new
		  User("002","change_fname","b_lname","pwd_2");
		  
		  when(validateImpl.update(user)).thenReturn(Response); ResponseEntity<String>
		  response = valUserCont.update(user); assertEquals(HttpStatus.OK.value(),
		  response.getStatusCodeValue());
		 
	}
	
	@Test
	public void updateTestFailure() throws Exception {
				
		User user = new User("", "", "", "");	
		
		when(validateImpl.update(user)).thenReturn(null);
		ResponseEntity<String> response = valUserCont.update(user);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatusCodeValue());
	}
	
	@Test
	public void deleteTest() {
		String Response = "User deleted for the userID: 003";
		User user = new User("003","c_fname","c_lname","pwd_3");
		
		when(validateImpl.delete(user)).thenReturn(Response);
		ResponseEntity<String> response = valUserCont.delete(user);
		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
	}
	
	@Test
	public void deleteTestFailure() {
		User user = new User("", "", "", "");	

		
		when(validateImpl.delete(user)).thenReturn(null);
		ResponseEntity<String> response = valUserCont.delete(user);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatusCodeValue());
	}
	

}
